package org.example.services;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.example.advisors.UsagesPrinter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.document.Document;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ChatService {
    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    @Value("classpath:/prompts/users/chat-user-prompt.st")
    private Resource userPrompt;
    @Value("classpath:/prompts/users/chat-system-prompt.st")
    private Resource systemPrompt;

    public ChatService(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClientBuilder
                .defaultOptions(
                        OpenAiChatOptions.builder()
                                .build()
                ).build();
    }

    public String chat(String query, String userId) {
        var retrievalAdvisor = RetrievalAugmentationAdvisor.builder()
                .documentRetriever(VectorStoreDocumentRetriever
                        .builder()
                        .vectorStore(vectorStore)
                        .similarityThreshold(0.75)
                        .topK(3)
                        .build()
                ).queryAugmenter(ContextualQueryAugmenter.builder().allowEmptyContext(true).build())
                .build();


        return chatClient.prompt()
                .user(query)
                .advisors(
                        retrievalAdvisor,
                        new UsagesPrinter(),
                        new SimpleLoggerAdvisor(),
                        new SafeGuardAdvisor(List.of("bomb", "hack", "malware"))
                ).call().content();
    }

    public Flux<String> streamingChatResponse(String query) {
        return chatClient.prompt()
                .system(promptSystemSpec -> promptSystemSpec.text(systemPrompt))
                .user(promptUserSpec -> promptUserSpec.text(userPrompt).param("concept", query))
                .stream().content();
    }

    public String saveDataToVectorFormat(List<String> listData) {
        List<Document> documentList = listData.stream().map(Document::new).toList();
        this.vectorStore.add(documentList);
        return "Data Stored Successfully";
    }
}

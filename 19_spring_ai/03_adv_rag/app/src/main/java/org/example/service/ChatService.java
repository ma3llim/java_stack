package org.example.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.preretrieval.query.transformation.RewriteQueryTransformer;
import org.springframework.ai.rag.retrieval.join.ConcatenationDocumentJoiner;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private ChatClient chatClient;
    private VectorStore vectorStore;

    public ChatService(ChatClient chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }

    public String getResponse(String userQuery){

        // re-writing the user query with llm call
        RetrievalAugmentationAdvisor retrievalAugmentationAdvisor = RetrievalAugmentationAdvisor.builder()
                .queryTransformers(
                        RewriteQueryTransformer.builder()
                                .chatClientBuilder(chatClient.mutate().clone())
                                .build()
                )
                // fetching data for vector as per the user query
                .documentRetriever(
                        VectorStoreDocumentRetriever.builder()
                                .vectorStore(vectorStore)
                                .topK(3)
                                .similarityThreshold(0.3)
                                .build()
                )
                // documents joiner
                .documentJoiner(new ConcatenationDocumentJoiner())
                // query augmenter - context + user query
                .queryAugmenter(ContextualQueryAugmenter.builder().build())
                .build();

        return chatClient.prompt()
                .user(userQuery)
                .advisors(retrievalAugmentationAdvisor)
                .call()
                .content();
    }
}

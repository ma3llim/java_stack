package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmbeddingTest {

    private final EmbeddingModel embeddingModel;

    EmbeddingTest(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    @Test
    void testEmbedding() {

        System.out.println(
                "Embedding Model: " + embeddingModel.getClass().getName()
        );

        float[] vector = embeddingModel.embed("Java");

        System.out.println(
                "Vector size: " + vector.length
        );
    }
}
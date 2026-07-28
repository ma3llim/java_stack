package org.example.utils;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataTransformer {
    public List<Document> transform(List<Document> documents) {
        var splitter = new TokenTextSplitter();
        return splitter.transform(documents);
    }
}

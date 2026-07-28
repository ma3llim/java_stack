package org.example.utils;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.JsonReader;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    @Value("classpath:data/simple_data.json")
    private Resource jsonSimpleData;

    @Value("classpath:data/cricket_rules.pdf")
    private Resource pdfSimpleData;

    public List<Document> loadDocumentsFromJson() {
        var jsonReader = new JsonReader(jsonSimpleData);
        return jsonReader.get();
    }

    public List<Document> loadDocumentsFromDPF() {
        var pdfReader = new PagePdfDocumentReader(pdfSimpleData, PdfDocumentReaderConfig.builder()
                .withPageTopMargin(0)
                .withPageExtractedTextFormatter(
                        ExtractedTextFormatter.builder()
                                .withNumberOfTopTextLinesToDelete(0)
                                .build()
                )
                .build());

        return pdfReader.read();
    }
}

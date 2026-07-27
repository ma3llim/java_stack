package org.example;

import org.example.services.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppTests {
    @Autowired
    private ChatService chatService;

    @Test
    void testTemplateRender() {
        System.out.println("Template Render");
        var output = this.chatService.chat("Spring", "123");
        System.out.println(output);
    }

    @Test
    void
}


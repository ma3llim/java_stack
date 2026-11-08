package org.example.todo;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    private void create(String title) throws Exception {
        mvc.perform(post("/api/todos").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"" + title + "\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    void fullCrudFlow() throws Exception {
        mvc.perform(get("/api/todos")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(0)));

        mvc.perform(post("/api/todos").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"  Buy milk \"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/todos/1"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Buy milk"))
                .andExpect(jsonPath("$.completed").value(false));

        mvc.perform(patch("/api/todos/1").contentType(MediaType.APPLICATION_JSON).content("{\"completed\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Buy milk"))
                .andExpect(jsonPath("$.completed").value(true));

        mvc.perform(put("/api/todos/1").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Buy bread\",\"completed\":false}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Buy bread"))
                .andExpect(jsonPath("$.completed").value(false));

        mvc.perform(get("/api/todos/1")).andExpect(jsonPath("$.title").value("Buy bread"));

        mvc.perform(delete("/api/todos/1")).andExpect(status().isNoContent());
        mvc.perform(get("/api/todos/1")).andExpect(status().isNotFound());
    }

    @Test
    void rejectsBlankTitle() throws Exception {
        mvc.perform(post("/api/todos").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"   \"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail").value("title must not be blank"));
        create("x");
        mvc.perform(patch("/api/todos/1").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"  \"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void missingTodoReturns404() throws Exception {
        mvc.perform(patch("/api/todos/99").contentType(MediaType.APPLICATION_JSON).content("{\"completed\":true}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.detail").value("Todo 99 not found"));
        mvc.perform(delete("/api/todos/99")).andExpect(status().isNotFound());
    }

    @Test
    void deletesCompletedTodos() throws Exception {
        create("a");
        create("b");
        mvc.perform(patch("/api/todos/1").contentType(MediaType.APPLICATION_JSON).content("{\"completed\":true}"));

        mvc.perform(delete("/api/todos/completed")).andExpect(status().isOk()).andExpect(jsonPath("$.deleted").value(1));
        mvc.perform(get("/api/todos")).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].title").value("b"));
    }
}

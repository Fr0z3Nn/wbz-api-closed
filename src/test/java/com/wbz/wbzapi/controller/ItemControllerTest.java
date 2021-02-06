package com.wbz.wbzapi.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemControllerTest {
    private final ObjectMapper om = new ObjectMapper();

    private MockMvc mockMvc;
    Item item;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    public void setUp() {
        item = new Item();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        item.setName("TEST_ENTITY");
        item.setImage("image");
        item.setDescription("description");
        item.setPrice(100);
    }

    @Test
    @DisplayName("Добавление товара Item")
    public void addItemTest() throws Exception {
        String jsonItem = om.writeValueAsString(item);
        MvcResult result = mockMvc
                .perform(
                        post("/api/item/add")
                                .content(jsonItem)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Item> itemList = om.readValue(resultContent, new TypeReference<>() {
        });
        assertTrue(itemList.stream().anyMatch(n -> n.getName().equals("TEST_ENTITY")));
    }

    @Test
    @DisplayName("Получение Items")
    public void getAllItems() throws Exception {
        MvcResult result = mockMvc
                .perform(
                        post("/api/item/"))
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(result.getResponse());
    }

    @Test
    @DisplayName("Изменение итема Items")
    public void editItem() throws Exception {
        Item editedItem = itemRepository.findByName("TEST_ENTITY");
        item.setName("TEST_ENTITY_EDITED");
        item.setId(editedItem.getId());
        String jsonItem = om.writeValueAsString(item);
        MvcResult result = mockMvc
                .perform(
                        post("/api/item/edit")
                                .content(jsonItem)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Item> itemList = om.readValue(resultContent, new TypeReference<>() {
        });
        assertTrue(itemList.stream().anyMatch(n -> n.getName().equals("TEST_ENTITY_EDITED")));
        assertFalse(itemList.stream().anyMatch(n -> n.getName().equals("TEST_ENTITY")));
    }

    @Disabled("НУЖНО ПОНЯТЬ ПРИЧИНУ ПОЧЕМУ ТЕСТ ВАЛИТСЯ")
    @Test
    @DisplayName("Поиск итема Item (Итем существует)")
    public void searchItem() throws Exception {
        String name = "TEST_ENTITY";
        MvcResult result = mockMvc
                .perform(
                        post("/api/item/search/{name}",name))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        Item itemResponse = om.readValue(resultContent, Item.class);
        assertNotNull(itemResponse);
        assertEquals(name, itemResponse.getName());

    }

    @Test
    @DisplayName("Поиск итема Item (Итема не существует)")
    public void searchItemNotInDB() throws Exception {
        MvcResult result = mockMvc
                .perform(
                        post("/api/item/search/{name}", "null"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("",result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Удаление итема Item (Итем существует)")
    public void deleteItem() throws Exception {
        Item deletedItem = itemRepository.findByName("TEST_ENTITY");
        String id = String.valueOf(deletedItem.getId());
        MvcResult result = mockMvc
                .perform(
                        post("/api/item/delete/{id}",id))
                .andExpect(status().isOk())
                .andReturn();
        String resultContent = result.getResponse().getContentAsString();
        List<Item> itemList = om.readValue(resultContent, new TypeReference<>() {
        });
        assertFalse(itemList.stream().anyMatch(n -> "TEST_ENTITY".equals(n.getName())));
    }

}

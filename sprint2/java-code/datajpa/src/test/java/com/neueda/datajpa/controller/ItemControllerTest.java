package com.neueda.datajpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neueda.datajpa.entity.Item;
import com.neueda.datajpa.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllItems() throws Exception{
        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").exists());
    }
    @Test
    void testGetItemById() throws Exception{
        Item item= itemRepository.save(new Item(null,"TestItem",2.99));
        mockMvc.perform(get("/api/items/"+item.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("TestItem"));

    }
    @Test
    void testCreateItem() throws Exception{
        Item item = new Item(null,"CreatedItem",3.99);
        String json= objectMapper.writeValueAsString(item);
        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("CreatedItem"));

    }
    @Test
    void testCreateItemInvalidParameters() throws Exception{
        Item item = new Item(null,null,0);
        String json= objectMapper.writeValueAsString(item);
        mockMvc.perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Item name and price must be provided")));

    }
    @Test
    void testDeleteItem() throws Exception{
        Item item = itemRepository.save(new Item(null,"test",9.99));
        mockMvc.perform(delete("/api/items/"+item.getId()))
                .andExpect(status().isNoContent());
        Assertions.assertFalse(itemRepository.findById(item.getId()).isPresent());
    }
    @Test
    void testDeleteItemNotFound() throws Exception{
        mockMvc.perform(delete("/api/items/45"))
                .andExpect(status().isNotFound());

    }
    //create testCase getItemByIdNotFound()
    //create testCase createItemToCheckInvalidParameters()
    //create testCase updateItem()
    //create testCase updateItemNotFound()
    //create testCase updateItemInvalidParameters()
}













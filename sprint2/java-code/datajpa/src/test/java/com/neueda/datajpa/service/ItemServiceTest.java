package com.neueda.datajpa.service;

import com.neueda.datajpa.entity.Item;
import com.neueda.datajpa.exception.ItemNotFoundException;
import com.neueda.datajpa.repository.ItemRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void getAllItems(){
        List<Item> items= Arrays.asList(
                new Item(null,"Apple",0.99),
                new Item(null,"Pear",0.49));

        Mockito.when(itemRepository.findAll()).thenReturn(items);
        List<Item> foundItems = itemService.getAllItems();
        assertEquals(items,foundItems);
    }

    @Test
    void getItemById() throws ItemNotFoundException {
        Item mockItem= new Item(null,"Apple",0.99);
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(mockItem));
        Item item= itemService.getItemById(1L);
        assertEquals("Apple",item.getName());
    }
    @Test
    void getItemByIdNotFound(){
        Mockito.when(itemRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ItemNotFoundException.class,()->itemService.getItemById(2L));
    }

    @Test
    void testCreateItem(){
        Item mockItem= new Item(null,"Apple",0.99);
        Mockito.when(itemRepository.save(mockItem)).thenReturn(mockItem);
        Item saved= itemService.createItem(mockItem);
        assertEquals("Apple",saved.getName());
    }
    @Test
    void testUpdateItem() throws ItemNotFoundException{
        Item existing= new Item(null,"Apple",0.99);
        Item updateItem= new Item(null,"Green Apple",1.29);
        Mockito.when(itemRepository.findById(1L)).thenReturn(Optional.of(existing));
        Mockito.when(itemRepository.save(existing)).thenReturn(existing);
        Item updated= itemService.updateItem(1L,updateItem);
        assertEquals("Green Apple",updated.getName());
        assertEquals(1.29,updated.getPrice());
    }

    @Test
    void testUpdateItemNotFound() throws ItemNotFoundException{
        Item updateItem= new Item(null,"Green Apple",1.29);
        Mockito.when(itemRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(ItemNotFoundException.class,()-> itemService.updateItem(2L,updateItem));
    }

    //write 2 test cases
    // testDeleteItemFound()
    // testDeleteItemNotFound()
}













package com.neueda.datajpa.repository;

import com.neueda.datajpa.entity.Item;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;
    @Test
    void testAll(){
        List<Item> items = itemRepository.findAll();
        assertFalse(items.isEmpty(),"Items should not be empty");
        assertTrue(items.size()>=5,"should have at least 5 seeded data");
    }
    @Test
    void findById(){
        List<Item> items=itemRepository.findAll();
        Item first= items.get(0);
        Optional<Item> found =itemRepository.findById(first.getId());
        assertTrue(found.isPresent(),"Item should be found with given id");
        assertEquals(first.getName(),found.get().getName());
    }
    @Test
    void createNewItem(){
        Item item = new Item(null,"Laptop",999);
        Item saved = itemRepository.save(item);
        assertNotNull(saved.getId(),"Saved item should have Id");
        assertEquals("Laptop",saved.getName(),"match with name");

    }
    @Test
    void testDelete(){
        List<Item> items= itemRepository.findAll();
        Item toDelete= items.get(0);
        itemRepository.deleteById(toDelete.getId());//pass id to delete
        Optional<Item> found=itemRepository.findById(toDelete.getId());
        assertFalse(found.isPresent(),"Item should not present as its deleted");
    }
    // write test case for update logic
    // use .save() only for update
}

package com.neueda.datajpa.service;

import com.neueda.datajpa.entity.Item;
import com.neueda.datajpa.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository repository;
    private Logger logger= LoggerFactory.getLogger(ItemServiceImpl.class);
    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item createItem(Item item) {
        return repository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item update) {
        return repository.findById(id)
                .map(existingItem-> {
                    existingItem.setName(update.getName());
                    existingItem.setPrice(update.getPrice());
                    return repository.save(existingItem);
                }).orElse(null);

    }

    @Override
    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}

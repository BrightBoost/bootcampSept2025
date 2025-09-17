package com.neueda.datajpa.service;

import com.neueda.datajpa.entity.Item;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItems();
    public Item createItem(Item item);
    public Item getItemById(Long id);
    public Item updateItem(Long id,Item update);
    public void deleteItem(Long id);
}

package com.neueda.datajpa.service;

import com.neueda.datajpa.entity.Item;
import com.neueda.datajpa.exception.InvalidParameterException;
import com.neueda.datajpa.exception.ItemNotFoundException;

import java.util.List;

public interface ItemService {

    public List<Item> getAllItems();
    public Item createItem(Item item);
    public Item getItemById(Long id) throws ItemNotFoundException;
    public Item updateItem(Long id,Item update) throws ItemNotFoundException;
    public void deleteItem(Long id) throws ItemNotFoundException;
}

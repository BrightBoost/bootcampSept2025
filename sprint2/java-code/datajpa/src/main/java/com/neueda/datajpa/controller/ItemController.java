package com.neueda.datajpa.controller;

import com.neueda.datajpa.entity.Item;
import com.neueda.datajpa.exception.InvalidParameterException;
import com.neueda.datajpa.exception.ItemNotFoundException;
import com.neueda.datajpa.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items=itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) throws InvalidParameterException{
        if(item==null || item.getName() ==null || item.getName().isBlank()|| item.getPrice()==0){
            throw new InvalidParameterException("Item name and price must be provided");
        }
        Item newItem = itemService.createItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getByItemId(@PathVariable Long id) throws InvalidParameterException,
            ItemNotFoundException{
        if(id==null){
            throw new InvalidParameterException("Item id must be provided");
        }
        return ResponseEntity.ok(itemService.getItemById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateItem(@RequestBody Item item,@PathVariable Long id)
    throws InvalidParameterException, ItemNotFoundException {
        if(item==null || item.getName() ==null || item.getName().isBlank()|| item.getPrice()==0){
            throw new InvalidParameterException("Item name and price must be provided");
        }
        Item createdItem = itemService.updateItem(id,item);
        return ResponseEntity.ok(createdItem);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) throws ItemNotFoundException{
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}

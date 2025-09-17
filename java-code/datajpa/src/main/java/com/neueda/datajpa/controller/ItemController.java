package com.neueda.datajpa.controller;

import com.neueda.datajpa.entity.Item;
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
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        Item newItem = itemService.createItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getByItemId(@PathVariable Long id){
        Item item= itemService.getItemById(id);
        if(item==null)
            return new ResponseEntity<>("Item Not Found",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateItem(@RequestBody Item item,@PathVariable Long id){
        Item updatedItem=itemService.updateItem(id,item);
        if(item==null)
            return new ResponseEntity<>("Item Not Found",HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}

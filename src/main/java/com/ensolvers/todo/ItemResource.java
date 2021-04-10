package com.ensolvers.todo;

import com.ensolvers.todo.model.Item;
import com.ensolvers.todo.service.itemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@RestController
@RequestMapping("/item")
public class ItemResource {
    private final itemService itemservice;

    public ItemResource(itemService itemservice) {
        this.itemservice = itemservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items= itemservice.findAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<Item> getItemByName(@PathVariable("name") String name){
        Item item= itemservice.findItemByName(name);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem (@RequestBody Item item){
        Item newitem = itemservice.additem(item);
        return new ResponseEntity<>(newitem,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem (@RequestBody Item item){
        Item updateitem = itemservice.updateItem(item);
        return new ResponseEntity<>(updateitem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteItem (@PathVariable("name") String name){
        itemservice.deleteItem(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}

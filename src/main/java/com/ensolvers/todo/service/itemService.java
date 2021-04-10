package com.ensolvers.todo.service;

import com.ensolvers.todo.exception.ItemNotFoundException;
import com.ensolvers.todo.repo.itemRepo;
import com.ensolvers.todo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class itemService {
    private final itemRepo itemRepo;
    @Autowired
    public itemService(itemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item additem(Item item){
        return itemRepo.save(item);
    }

    public List<Item> findAllItems(){
        return itemRepo.findAll();
    }

    public Item updateItem(Item item){
        return itemRepo.save(item);
    }

    public Item findItemByName(String name){
        return itemRepo.findItemByName(name).orElseThrow(()->new ItemNotFoundException("No item with name: "+name));
    }

    public void deleteItem(String name){
        itemRepo.deleteItemByName(name);
    }

}

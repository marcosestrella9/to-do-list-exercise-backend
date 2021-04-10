package com.ensolvers.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ensolvers.todo.model.Item;

import java.util.Optional;

public interface itemRepo extends JpaRepository<Item, String>{
    void deleteItemByName(String name);

    Optional<Item> findItemByName(String name);
}

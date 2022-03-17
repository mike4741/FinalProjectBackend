package com.example.ItemsAPI.service;

import com.example.ItemsAPI.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item addItems(Item item);
    void  deleteItem(Integer id);
    List<Item> getAllItems();
    Optional<Item> getItemById(Integer id);
    void  updateItem(Integer id , String name, String description , String imageUrl);









}

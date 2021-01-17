package com.wbz.wbzapi.service;

import com.wbz.wbzapi.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> deleteItem(Long id);
    List<Item> getAllItems();
    List<Item> editItem(Long id, String name, String description, double price, String image);
    List<Item> addItem(String name, String description, double price, String image);
    Item getById(Long id);
}

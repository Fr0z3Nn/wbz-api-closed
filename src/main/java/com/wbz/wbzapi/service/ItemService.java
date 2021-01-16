package com.wbz.wbzapi.service;

import com.wbz.wbzapi.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> deleteItem(Long id);
    List<Item> getAllItems();
}

package com.wbz.wbzapi.service.Impl;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.repository.ItemRepository;
import com.wbz.wbzapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {


    private final ItemRepository itemRepository;

    @Override
    public List<Item> deleteItem(Long id) {
        itemRepository.deleteById(id);
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> editItem(Long id, String name, String description, double price, String image) {
        int searchKey = getSearchKey(id);
        Item updatedItem = itemRepository.findAll().get(searchKey);
        updatedItem.setName(name);
        updatedItem.setDescription(description);
        updatedItem.setPrice(price);
        updatedItem.setImage(image);
        itemRepository.deleteById(id);
        itemRepository.save(updatedItem);
        return itemRepository.findAll();
    }

    @Override
    public List<Item> addItem(String name, String description, double price, String image) {
        Item item = new Item();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setImage(image);
        itemRepository.save(item);
        System.out.println(item.getId());
        return itemRepository.findAll();
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.getOne(id);
    }

    private int getSearchKey(Long id){
        List<Item> items = itemRepository.findAll();
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }
}

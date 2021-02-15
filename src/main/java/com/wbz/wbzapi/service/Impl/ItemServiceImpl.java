package com.wbz.wbzapi.service.Impl;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.handler.exception.ItemNotFoundException;
import com.wbz.wbzapi.repository.ItemRepository;
import com.wbz.wbzapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> deleteItem(Long id) {
        itemRepository.deleteById(id);
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        if (itemRepository.findAll().isEmpty()) {
            throw new ItemNotFoundException("Список товаров пуст");
        } else {
            return itemList;
        }
    }

    @Override
    public List<Item> editItem(Item item) {
        itemRepository.findById(item.getId())
                .map(itemRepository::save)
                .orElseThrow(() -> new ItemNotFoundException("Данного товара не существует"));
        return itemRepository.findAll();
    }

    @Override
    public List<Item> addItem(Item item) {
        itemRepository.save(item);
        return itemRepository.findAll();
    }

    @Override
    public Item findItemByName(String name) {
        return itemRepository.findByName(name);
    }

}

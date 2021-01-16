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
        List<Item> l1 = new ArrayList<>();

        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}

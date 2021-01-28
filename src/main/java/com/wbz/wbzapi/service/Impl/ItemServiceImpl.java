package com.wbz.wbzapi.service.Impl;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.repository.ItemRepository;
import com.wbz.wbzapi.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return itemRepository.findAll();
    }

    @Override
    public List<Item> editItem(Long id, String name, String description, double price, String image) {
       Item updatedItem = itemRepository.findById(id).orElseThrow(IllegalStateException::new);
        updatedItem.setName(name);
        updatedItem.setDescription(description);
        updatedItem.setPrice(price);
        updatedItem.setImage(image);
        return itemRepository.findAll();
    }

    @Override
    public List<Item> addItem(String name, String description, double price, String image) {
        Item item = Item.builder()
                .name(name)
                .description(description)
                .price(price)
                .image(image)
                .build();
        itemRepository.save(item);
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findAllByName(String name) {
        return itemRepository.findAll().stream().filter(n -> n.getName().contains(name)).collect(Collectors.toList());
    }

}

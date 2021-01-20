package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.service.Impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item")
public class ItemController {

    private final ItemServiceImpl itemService;

    @RequestMapping("/")
    public List<Item> getItem() {
        System.out.println("запрос прилетел");
        return itemService.getAllItems();
    }

    @PostMapping("/edit")
    public List<Item> editItem(@RequestBody Item item) {
        itemService.editItem(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getImage());
        System.out.println("UPDATE " + item.getId());
        return itemService.getAllItems();
    }

    @PostMapping("/add")
    public List<Item> addItem(@RequestBody Item item) {
        System.out.println("ADD");
        return itemService.addItem(item.getName(), item.getDescription(), item.getPrice(), item.getImage());
    }
    @PostMapping("/delete/{id}")
    public List<Item> deleteItem(@PathVariable long id) {
        System.out.println("ОПАЧА УДАЛЯЕМ");
        itemService.deleteItem(id);
         return itemService.getAllItems();
    }
}


package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.service.Impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemServiceImpl itemService;

    @RequestMapping("/item")
    public List<Item> getItem() {
        System.out.println("запрос прилетел");
        return itemService.getAllItems();
    }

    @PostMapping("/editItem")
    public List<Item> editItem(@RequestBody Item item) {
        itemService.editItem(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getImage());
        System.out.println("UPDATE " + item.getId());
        return itemService.getAllItems();
    }

    @PostMapping("/addItem")
    public List<Item> addItem(@RequestBody Item item) {
        System.out.println("ADD");
        return itemService.addItem(item.getName(), item.getDescription(), item.getPrice(), item.getImage());
    }
    @PostMapping("/deleteItem")
    public List<Item> deleteItem(@RequestBody Item item) {
        System.out.println("ОПАЧА УДАЛЯЕМ");
         itemService.deleteItem(item.getId());
         return itemService.getAllItems();
    }
}


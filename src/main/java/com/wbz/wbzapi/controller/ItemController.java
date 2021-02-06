package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.service.Impl.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/item")
public class ItemController {

    private final ItemServiceImpl itemService;

    @RequestMapping("/")
    public List<Item> getItem() {
        log.info("IN getItem - query success / Прилетел запрос из метода getItem");
        return itemService.getAllItems();
    }

    @PostMapping("/edit")
    public List<Item> editItem(@RequestBody Item item) {
        itemService.editItem(item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getImage());
        log.info("IN editItem - query success / Прилетел запрос из метода editItem: - {}", item);
        return itemService.getAllItems();
    }

    @PostMapping("/add")
    public List<Item> addItem(@RequestBody Item item) {
        log.info("IN addItem - query success / Прилетел запрос из метода addItem: - {}", item);
        return itemService.addItem(item.getName(), item.getDescription(), item.getPrice(), item.getImage());
    }
    @PostMapping("/delete/{id}")
    public List<Item> deleteItem(@PathVariable long id) {
        log.info("IN deleteItem - query success / Прилетел запрос из метода deleteItem: - {}", id);
        itemService.deleteItem(id);
         return itemService.getAllItems();
    }

    @PostMapping("/search/{name}")
    public Item searchItem(@PathVariable String name) {
        log.info("IN searchItem - query success / Прилетел запрос из метода searchItem: - {}", name);
        return itemService.findItemByName(name);
    }
}


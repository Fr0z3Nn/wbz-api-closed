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
//
//    @PostMapping(
//            value = "/createItem", consumes = "application/json", produces = "application/json")
//    public List<Item> createItem(@RequestBody Item item) {
//        return ItemService.saveUpdateItem(item);
//    }
//
//    @PostMapping(
//            value = "/updateItem", consumes = "application/json", produces = "application/json")
//    public List<Item> updateItem(@RequestBody Item item) {
//
//        return ItemService.saveUpdateItem(item);
//    }
//
    @PostMapping(
            value = "/deleteItem")
    public void deleteItem(@RequestBody Item item) {
        System.out.println("ОПАЧА УДАЛЯЕМ");
         itemService.deleteItem(item.getId());
    }
}


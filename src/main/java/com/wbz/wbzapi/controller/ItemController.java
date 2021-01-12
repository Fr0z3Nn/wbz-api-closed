package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
public class ItemController {

    @RequestMapping("/item")
    public List<Item> getItem() {
        System.out.println("запрос прилетел");
        return ItemService.getAllItems();
    }

    @PostMapping(
            value = "/createItem", consumes = "application/json", produces = "application/json")
    public List<Item> createItem(@RequestBody Item item) {
        return ItemService.saveUpdateItem(item);
    }

    @PostMapping(
            value = "/updateItem", consumes = "application/json", produces = "application/json")
    public List<Item> updateItem(@RequestBody Item item) {

        return ItemService.saveUpdateItem(item);
    }

    @PostMapping(
            value = "/deleteItem")
    public List<Item> deleteItem(@RequestBody Item item) {
        System.out.println("ОПАЧА УДАЛЯЕМ");
        return ItemService.deleteItem(item);
    }
}


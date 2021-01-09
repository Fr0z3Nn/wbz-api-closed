package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
public class ItemController {
    Item item = new Item("dawd","dawd",20.1,"adwwad");

    @GetMapping
    public Item getItem() {
        return item;
    }
}


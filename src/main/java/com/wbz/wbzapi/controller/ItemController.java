package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import org.springframework.web.bind.annotation.*;


@RestController
public class ItemController {

    Item item = new Item("dawd","dawd",20.1,"adwwad");

    @RequestMapping("/item")
    public Item getItem() {
        System.out.println("запрос прилетел");
        return item;
    }
}


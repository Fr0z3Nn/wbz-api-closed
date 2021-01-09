package com.wbz.wbzapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String name;
    private String description;
    private double price;
    private String image;
}

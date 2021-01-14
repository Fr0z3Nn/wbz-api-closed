package com.wbz.wbzapi.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private String image;

    public Item() {
    }

    public Item(String name, String description, double price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }
}

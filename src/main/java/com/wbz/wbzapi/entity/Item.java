package com.wbz.wbzapi.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@Table(name = "item")
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


}

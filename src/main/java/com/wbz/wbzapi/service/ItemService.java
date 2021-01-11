package com.wbz.wbzapi.service;

import com.wbz.wbzapi.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemService {
    private static List<Item> items = new ArrayList<>(List.of(
            new Item("Молоко","нет его",12.2,"https://vk.com/away.php?utf=1&to=https%3A%2F%2Fcdn2.scratch.mit.edu%2Fget_image%2Fuser%2F22140082_60x60.png"),
            new Item("Кола","нет его",20.01,"https://vk.com/away.php?utf=1&to=https%3A%2F%2Fcdn2.scratch.mit.edu%2Fget_image%2Fuser%2F22140082_60x60.png"),
            new Item("Сникерс","нет его",510.1,"https://vk.com/away.php?utf=1&to=https%3A%2F%2Fcdn2.scratch.mit.edu%2Fget_image%2Fuser%2F22140082_60x60.png"),
            new Item("Карандаш","нет его",242351,"https://vk.com/away.php?utf=1&to=https%3A%2F%2Fcdn2.scratch.mit.edu%2Fget_image%2Fuser%2F22140082_60x60.png"),
            new Item("Коробка","нет его",201251,"https://vk.com/away.php?utf=1&to=https%3A%2F%2Fcdn2.scratch.mit.edu%2Fget_image%2Fuser%2F22140082_60x60.png")
    ));


    public static List<Item> saveUpdateItem(Item item){
        for (Item itemInList : items){
            if (itemInList.getName().equals(item.getName())){
                itemInList.setName(item.getName());
                itemInList.setImage(item.getImage());
                itemInList.setDescription(item.getDescription());
                itemInList.setImage(item.getImage());
            }
        }
        return items;
    }

    public static List<Item> deleteItem(Item item){
       items = items.stream().filter( n -> !n.equals(item)).collect(Collectors.toList());
        return items;
    }

   /* public static List<Item> addItem(Item item){
        items.add(item);
        return items;
    }*/

    public static List<Item> getAllItems(){
        return items;
    }
}

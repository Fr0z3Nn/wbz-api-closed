package com.wbz.wbzapi.service;

import com.wbz.wbzapi.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private static List<Item> items = new ArrayList<>();

    static {
        for (int i = 0; i<100; i++){
            items.add(new Item("Товар #" + i,"нет его",Math.random()*10000,"https://cdn2.scratch.mit.edu/get_image/user/22140082_60x60.png"));
        }
    }
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
        Item itemToDel = null;
        for (Item del : items){
            if (item.getName().equals(del.getName())){
                itemToDel = del;
            }
        }
        items.remove(itemToDel);
        System.out.println(items.size());
        return items;
       /*items = items.stream().filter( n -> !n.equals(item)).collect(Collectors.toList());
        return items;*/
    }

   /* public static List<Item> addItem(Item item){
        items.add(item);
        return items;
    }*/

    public static List<Item> getAllItems(){
        return items;
    }
}

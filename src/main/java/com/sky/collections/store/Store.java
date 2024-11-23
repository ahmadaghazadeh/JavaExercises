package com.sky.collections.store;

import java.util.*;

public class Store {
    private static Random random = new Random();
    private Map<String, InventoryItem> inventory;
    private NavigableSet<Cart> carts=new TreeSet<>(Comparator.comparing(Cart::getId));
    Map<Category,Map<String,InventoryItem>> aisleInventory;

    public static void main(String[] args) {
        Store myStore = new Store();
        myStore.stockStore();
        myStore.listInventory();

        myStore.stockAisles();
        myStore.listProductByCategory();
    }

    private void listProductByCategory() {
        aisleInventory.keySet().forEach(k ->{
            System.out.println("-".repeat(20)+"\n"+k+"\n"+"-".repeat(20));
            aisleInventory.get(k).keySet().forEach(System.out::println);
        });
    }

    private void stockStore(){
        inventory = new HashMap<>();
        List<Product> products = new ArrayList<>(List.of(
                new Product("A100", "apple", "local", Category.PRODUCE),
                new Product("B100", "banana", "local", Category.PRODUCE),
                new Product("P100", "pear", "local", Category.PRODUCE),
                new Product("L103", "lemon", "local", Category.PRODUCE),
                new Product("M201", "milk", "farm", Category.DAIRY),
                new Product("Y001", "yogurt", "farm", Category.DAIRY),
                new Product("C333", "cheese", "farm", Category.DAIRY),
                new Product("R777", "rice chex", "Nabisco", Category.CEREAL),
                new Product("G111", "granola", "Nat Valley", Category.CEREAL),
                new Product("BB11", "ground beef", "butcher", Category.MEAT),
                new Product("CC11", "chicken", "butcher", Category.MEAT),
                new Product("BC11", "bacon", "butcher", Category.MEAT),
                new Product("BC77", "coke", "coca cola", Category.BEVERAGE),
                new Product("BC88", "coffee", "value", Category.BEVERAGE),
                new Product("BC99", "tea", "herbal", Category.BEVERAGE)
        ));
        products.forEach(p-> inventory.put(p.sku(),
                new InventoryItem(p, random.nextDouble(0,1.25),1000,5 )));
    }


    private void  stockAisles(){
        aisleInventory = new EnumMap<>(Category.class);
        for(InventoryItem item : inventory.values()){
            Category aisle= item.getProduct().category();
            Map<String,InventoryItem> productMap=aisleInventory.get(aisle);

            if(productMap==null){
                 productMap = new TreeMap<>();
            }
            productMap.put(item.getProduct().name(),item);
            aisleInventory.putIfAbsent(aisle,productMap);
        }
    }

    private void listInventory(){
        System.out.println("-".repeat(80));
        System.out.println("inventory");
        System.out.println("-".repeat(80));
        inventory.values().forEach(System.out::println);
    }
}

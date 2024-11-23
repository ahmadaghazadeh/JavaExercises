package com.sky.collections.store;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    enum CartType {PHYSICAL, VIRTUAL}
    private static int lastId=1;
    private int id;
    private LocalDate cartDate;
    private CartType cartType;
    private Map<String,Integer> products;
    public Cart(CartType type,int days) {
        this.cartType = type;
        this.cartDate = LocalDate.now().plusDays(days);
        this.id = lastId++;
        this.products = new HashMap<>();
    }

    public Cart(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCartDate() {
        return cartDate;
    }
    public void addItem(InventoryItem item,int qty) {
        products.merge(item.getProduct().sku(),qty,Integer::sum);

        if(!item.reserveItem(qty)){
            System.out.println("Not enough space to reserve");
        }
    }

    public void removeItem(InventoryItem item,int qty) {
        int current = products.get(item.getProduct().sku());
        if(current <= qty){
            products.remove(item.getProduct().sku());
            System.out.println("Removed "+item.getProduct().sku());
        }else {
            products.merge(item.getProduct().sku(),qty,(oldValue,newValue)->oldValue-newValue);
            System.out.println("Removed "+item.getProduct().sku());
        }
        item.reserveItem(qty);
    }

    public void printSalesSlip(Map<String,InventoryItem> inventory){
        double total = 0;
        System.out.println("-".repeat(80));
        System.out.println("Thank you for your sale:");
        for (var cartItem: products.entrySet()){
            var item = inventory.get(cartItem.getKey());
            int qty= cartItem.getValue();
            double itemizedPrice = (item.getPrice()*qty);
            total += itemizedPrice;
            System.out.println("\t"+cartItem.getKey()+"\t"+item.getProduct().name()+itemizedPrice+"\t"+itemizedPrice);
        }
        System.out.printf("Total sale $%.2f%n:",total);
        System.out.println("-".repeat(80));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cartDate=" + cartDate +
                ", products=" + products +
                '}';
    }
}

package com.example.wei_007_lab4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Product {
    public static Map<String, Double> products;


    // 构造方法
    public Product() {
        // 创建商品名和价格的映射
        products = new HashMap<>();
        products.put("Apple", 5.5);
        products.put("Banana", 3.0);
        products.put("Orange", 4.2);
        products.put("Book", 14.2);
        products.put("Toys", 24.2);
    }

    public String[] getProductNames() {
        Set<String> productNamesSet = products.keySet(); // 获取所有商品名的集合
        String[] productNames = productNamesSet.toArray(new String[0]); // 转换为数组

        return productNames;
    }

    public static String getProductNamePriceList(Map<String, Integer> items) {
        String output = "";

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String price = products.get(entry.getKey()).toString();
            output += "Product:  " + entry.getKey() + ",  Price:  " + price + ",  Quantity:  " + entry.getValue() + "\n";
        }
        return output;
    }

    private static Double getOrderTotal(Map<String, Integer> items) {
        Double OrderTotal = 0.0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            OrderTotal += products.get(entry.getKey()) * entry.getValue();
        }
        return OrderTotal;
    }

    public static String getProductReceipt(Map<String, Integer> items) {
        return getProductNamePriceList(items);
    }

    public static String getProductReceipt(String name, String address, String Shipping, Map<String, Integer> items) {
        String receipt = "";
        if (items.isEmpty()) {
            receipt = "\n Your Cart is empty!";
        } else if (name.isEmpty() || address.isEmpty() ) {
            receipt = "\n Name and address can not be empty!";
        } else{
            Double price = getOrderTotal(items);
            Double shippingPrice = 0.0;
            shippingPrice = Shipping.equals("Home Delivery")?5.0:0.0;
            receipt += "\nName:  " + name;
            receipt += "\nAddress:  " + address;
            receipt += "\n\nGrocery Items:  \n";
            receipt += getProductNamePriceList(items);
            receipt += "\nOrder Total:  " + (double) Math.round(price * 100) / 100;
            receipt += "\nTax amount:  " + (double) Math.round(price * 1.1 * 100) / 100;
            receipt += "\nShipping:  " + shippingPrice;
            receipt += "\n\nFinal cost:  " + (double) Math.round((price * 1.1 + shippingPrice) * 100) / 100;
        }
        return receipt;
    }
}

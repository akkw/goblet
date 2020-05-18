package com.sxlg.goblet.data.model;

import java.io.Serializable;

public class MysqlType implements Serializable {
    private String id;
    private String name;
    private String price;
    private String serial_number;
    private String quantity_in_stock;
    private String merchandise_wantage;
    private String buy_limit;
    private String lower_limit;
    private String merchandise_gross;
    private String total_sales_volume;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(String quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getMerchandise_wantage() {
        return merchandise_wantage;
    }

    public void setMerchandise_wantage(String merchandise_wantage) {
        this.merchandise_wantage = merchandise_wantage;
    }

    public String getBuy_limit() {
        return buy_limit;
    }

    public void setBuy_limit(String buy_limit) {
        this.buy_limit = buy_limit;
    }

    public String getLower_limit() {
        return lower_limit;
    }

    public void setLower_limit(String lower_limit) {
        this.lower_limit = lower_limit;
    }

    public String getMerchandise_gross() {
        return merchandise_gross;
    }

    public void setMerchandise_gross(String merchandise_gross) {
        this.merchandise_gross = merchandise_gross;
    }

    public String getTotal_sales_volume() {
        return total_sales_volume;
    }

    public void setTotal_sales_volume(String total_sales_volume) {
        this.total_sales_volume = total_sales_volume;
    }
}

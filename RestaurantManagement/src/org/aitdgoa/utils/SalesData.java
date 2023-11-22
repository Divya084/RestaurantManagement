
package org.aitdgoa.utils;

public class SalesData {
    String date, location;
    int rid, amount;

    public SalesData(String date, String location, int rid, int amount) {
        this.date = date;
        this.location = location;
        this.rid = rid;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public int getRid() {
        return rid;
    }

    public int getAmount() {
        return amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
   

    
    
}



package org.aitdgoa.utils;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class MenuItems1
{
    String itemName;
    int price, itemid;
    CheckBox checkBox;
    TextField textField;

    public MenuItems1(String itemName, int price, int itemid) {
        this.itemName = itemName;
        this.price = price;
        this.itemid = itemid;
       checkBox = new CheckBox();
        textField = new TextField();
        textField.setText("1");
    }
     public MenuItems1(String itemName, int price, int itemid, String defaultQty) {
        this.itemName = itemName;
        this.price = price;
        this.itemid = itemid;
        checkBox = new CheckBox();
        textField = new TextField();
        textField.setText(defaultQty);
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public int getItemid() {
        return itemid;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }
    
    
}

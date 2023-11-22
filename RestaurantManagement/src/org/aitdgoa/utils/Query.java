
package org.aitdgoa.utils;

import java.sql.ResultSet;

public class Query 
{
    public static void insertOrder(String branchLocation, String date)
    {      
        //******************************Inserting order***********************************************
            String getRidQuery = "select rid from restaurent where location = '" + branchLocation + "'";
            try{
                ResultSet resultSet = Connection.statement.executeQuery(getRidQuery);
                resultSet.next();
                
                String insertToOrderQuery = "insert into order1(cid, rid) values(" + UserSideUI.customerId + ", " + resultSet.getInt(1) + ")";
                int c = Connection.statement.executeUpdate(insertToOrderQuery);
                System.out.println(c + " rows affected");
                
                InsertOrderDetails(date);
                
            }
            catch(Exception e){}
        //*******************************************************************************************
        
    }
    public static void addItemToMenu(String itemid, String itemname,String foodcateg,String price)
    {      

          try {
                    int itid=Integer.parseInt(itemid);
                    int p=Integer.parseInt(price);
                   

                    String insertitem = "insert into items(itemid,name,category,price) values(" + itid + ",'" + itemname + "','" + foodcateg + "'," + p + ")";
                    int cnt = Connection.statement.executeUpdate(insertitem);
                    System.out.println(cnt + " rows affected");
                    Customer.loadPromptScreen("Item Added Succesfully"); 
                   
                    
                } catch (Exception e) {}
                
            
        //*******************************************************************************************
        
    }
    
            public static void deleteItem(String itmid)
    {      
     
          try {
                    int itid=Integer.parseInt(itmid);
                  

                    String deleteitem = "delete from items where itemid="+itid;
                    int cnt = Connection.statement.executeUpdate(deleteitem);
                    System.out.println(cnt + " rows affected");
                    Customer.loadPromptScreen("Item Deleted Succesfully"); 
                   
                    
                } catch (Exception e) {}
                
            
        //*******************************************************************************************
        
    }
            public static void UpdateItem(String itemid,String iname,String foodcat,String price)
    {      
    
          try {
                    int itid=Integer.parseInt(itemid);
                   
                    int p=Integer.parseInt(price);
                   
              
                    String update = "update items set name='" + iname + "',category= '" + foodcat + "',price= " + p + " where itemid="+itid;
                    int cnt = Connection.statement.executeUpdate(update);
                    System.out.println(cnt + " rows affected");
                    Customer.loadPromptScreen("Item Updated Succesfully"); 
                   
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            
        //*******************************************************************************************
        
    }
    
    
    public static void InsertOrderDetails(String date) 
    {
        try
        {
            ResultSet resultSet = Connection.statement.executeQuery("select oid from order1 where cid=" + UserSideUI.customerId);
            resultSet.next();
            int orderId = resultSet.getInt(1);
            for(int i=0; i<Bill.count; i++)
            {
                String insertToOrderDetailsQuery = "insert into orderdetails(oid, itemid, orddate, quantity, amount) values(" + orderId + ", "  + Bill.itemIds[i] + ","
                                                        + " '" + date + "', " + Bill.itemQuantities[i] +", " + Bill.itemPrices[i] +")";
                int c = Connection.statement.executeUpdate(insertToOrderDetailsQuery);
                System.out.println(c + " rows affected");
            }
         
        }
        catch(Exception e){}        
    }
    
    public static void editUserDetails(String name, String address, String phno)
    {
        String editQuery = "update customer set cname='" + name + "', address='" + address +"', phno='" + phno + "' where cid=" + UserSideUI.customerId;
        try {
            int c = Connection.statement.executeUpdate(editQuery);
            System.out.println(c + " rows affected");
            
          
        } catch (Exception e) {}
    }
    
    public static void deleteUserAccount()
    {
        String deleteQuery = "delete from customer where cid=" + UserSideUI.customerId;
        try {
            int c = Connection.statement.executeUpdate(deleteQuery);
            System.out.println(c + " rows affected");
            Customer.loadPromptScreen("Account deleted successfully");
            UserSideUI.userStage.close();
        } catch (Exception e) {System.out.println(e);}
    }
    
    public static void addRestaurant(String restid,String branch,String phno)
    {      
        
          try {
                    int rid=Integer.parseInt(restid);
                    

                    String insertrest = "insert into restaurent(rid,location,rphno) values(" + rid + ",'" + branch + "','" + phno + "')";
                    int cnt = Connection.statement.executeUpdate(insertrest);
                    System.out.println(cnt + " rows affected");
                    Customer.loadPromptScreen("Restaurant branch Added Successfully"); 
                   
                    
                } catch (Exception e) {System.out.println(e);}
                
            
        //*******************************************************************************************
        
    }
    
    public static void deleteRestaurant(String restid)
    {      
       
          try {
                    int rd=Integer.parseInt(restid);
                  

                    String deleterest = "delete from restaurent where rid="+rd;
                    int cnt = Connection.statement.executeUpdate(deleterest);
                    System.out.println(cnt + " rows affected");
                    Customer.loadPromptScreen("Restaurant Branch Deleted Succesfully"); 
                   
                    
                } catch (Exception e) {}
      
    }
    
    public static void updateRestaurant(String restid,String branch,String phno)
    {      
     

          try {
                    int rd=Integer.parseInt(restid);
                    String update = "update restaurent set location='" + branch + "',rphno= '" + phno + "' where rid="+rd;
                    int cnt = Connection.statement.executeUpdate(update);
                    System.out.println(cnt + " rows affected");
                    Customer.loadPromptScreen("Restaurant Branch Updated Succesfully"); 
                   
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
      
    }
//    
}

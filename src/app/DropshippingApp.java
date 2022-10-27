package app;

import domain.*;
public class DropshippingApp {

    public static void main(String[] args){
        /* Customer[] customer = fileIO.FileIO.customerReader("src/dataFiles/Customers.csv");
        Product[] product = fileIO.FileIO.productReader("src/dataFiles/S1_Products.csv");
        Sales[] sales = fileIO.FileIO.salesReader("src/dataFiles/S1_Sales.csv", customer, product);
        
        for(int i=0; i<sales.length;i++){
            System.out.println(sales[i].getCustomer().getName());
        } */
        SalesQuery.runApp();
    }
    
    

    }

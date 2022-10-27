package domain;

import fileIO.FileIO;

public class SalesQuery{

    private final static Customer[] CUSTOMER = fileIO.FileIO.customerReader("src/dataFiles/Customers.csv");
      
    private final static Supplier SUPPLIER1 = new Supplier(FileIO.productReader("src/dataFiles/S1_Products.csv"));
    private final static Sales[] SALES1 = fileIO.FileIO.salesReader("src/dataFiles/S1_Sales.csv", CUSTOMER, SUPPLIER1.getProductArray()); 
    
    private final static Supplier SUPPLIER2 = new Supplier(FileIO.productReader("src/dataFiles/S2_Products.csv"));
    private final static Sales[] SALES2 = fileIO.FileIO.salesReader("src/dataFiles/S2_Sales.csv", CUSTOMER, SUPPLIER2.getProductArray());

    private final static Supplier SUPPLIER3 = new Supplier(FileIO.productReader("src/dataFiles/S3_Products.csv"));
    private final static Sales[] SALES3 = fileIO.FileIO.salesReader("src/dataFiles/S3_Sales.csv", CUSTOMER, SUPPLIER3.getProductArray());
    
    private final static SalesManagement SALES_MANAGEMENT = new SalesManagement(SALES1, SALES2, SALES3);
    
    public static void runApp(){
       mostProfitableSale();
    }

    private static void mostProfitableSale(){
        Sales mostProfitableSales = SALES_MANAGEMENT.getSalesArray()[0][0];
        for(Sales[] arr:SALES_MANAGEMENT.getSalesArray()){
            for(Sales sale:arr){
                if(sale == null){
                    break;
                }
                if(sale.getProfit()>mostProfitableSales.getProfit()){
                    mostProfitableSales = sale;
                }
            }
        }
        System.out.printf("1)" +mostProfitableSales.getProduct().allInfo()+" -> %.2f TL Profit",mostProfitableSales.getProfit());    
    }


    private static void mostExpensiveProduct(){ //in terms of sales price

    }

    private static void customerPurchasesTheMostProduct(){

    }

    private static void totalProfit(){

    }

    private static void theLeastProfitProductOfS1(){

    }
    
}
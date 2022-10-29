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
       mostExpensiveProduct();
       customerPurchasesTheMostProduct();
       totalProfit();
       theLeastProfitProductOfS1();
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
        System.out.printf("1)" +mostProfitableSales.getProduct().allInfo()+" -> %.2f TL Profit\n",mostProfitableSales.getProfit());    
    }


    private static void mostExpensiveProduct(){ //in terms of sales price
        Sales mostExpensiveSale = SALES_MANAGEMENT.getSalesArray()[0][0];
        for(Sales[] arr:SALES_MANAGEMENT.getSalesArray()){
            for(Sales sale:arr){
                if(sale == null){
                    break;
                }
                if(sale.getSalesPrice()>mostExpensiveSale.getSalesPrice()){
                    mostExpensiveSale = sale;
                }
            }}
            System.out.printf("2)" +mostExpensiveSale.getProduct().allInfo()+" -> with sale price %.2f\n",mostExpensiveSale.getSalesPrice());
    }

    private static void customerPurchasesTheMostProduct(){
        int purchaseCount = 0;
        int tempCount = 0;
        Customer mostPurchasingCustomer = CUSTOMER[0];
        
        for(Customer c : CUSTOMER){
            
            if (c == null){
                break;
            }
            
            for(Sales[] arr:SALES_MANAGEMENT.getSalesArray()){
                for(Sales sale:arr){
                    if(sale == null){
                        break;
                    }
                    
                
                    if(c.getId().equals(sale.getCustomer().getId())){
                        tempCount++;
                        
                    }
                    
                }
                
            }
            
            if(tempCount > purchaseCount){
                purchaseCount = tempCount;
                mostPurchasingCustomer = c;
            }
            
                tempCount = 0;
            
        }
        System.out.printf("3)"+mostPurchasingCustomer.getAllInfo()+" -> with %d purchases\n",purchaseCount);
    }

    private static void totalProfit(){
        double totalProfit = 0;
        for(Sales[] arr:SALES_MANAGEMENT.getSalesArray()){
            for(Sales sale:arr){
                if(sale == null){
                    break;
                }
                totalProfit += sale.getProfit();
            }
        }
        System.out.printf("4) Total Profit: %.2f TL\n",totalProfit);
    }

    private static void theLeastProfitProductOfS1(){
        Sales leastProfitableSale = SALES_MANAGEMENT.getSalesArray()[0][0];
        for(Sales sale:SALES_MANAGEMENT.getSalesArray()[0]){
            if(sale == null){
                break;
            }
            if(sale.getProfit()<leastProfitableSale.getProfit()){
                leastProfitableSale = sale;
            }
        }
        System.out.printf("5)" +leastProfitableSale.getProduct().allInfo()+" -> with %.2f TL Profit",leastProfitableSale.getProfit());
    }
    

}
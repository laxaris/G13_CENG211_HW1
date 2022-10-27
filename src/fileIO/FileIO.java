package fileIO;
import domain.*;
import java.io.*;



public class FileIO{
    
//--------------------------------customer file input output-----------------------------------
    public static Customer[] customerReader(String str){
        int arrSize =50;
        Customer[] customerArr = new Customer[arrSize];

    try{
        
        BufferedReader customerFileReader = new BufferedReader(new FileReader(str));
        String id;
        String name ;
        String email;
        String country;
        String adress;
        int index = 0;
        String line = customerFileReader.readLine() ;
        line = customerFileReader.readLine() ;
        while (line != null){  
            String[] lineArray = line.split(",") ;
            id = lineArray[0] ;
            name = lineArray[1] ;
            email = lineArray[2] ;
            country = lineArray[3] ;
            adress = lineArray[4] ;
            if (index == arrSize){   
                customerArr = customerArrMagnifier(customerArr);
                arrSize = customerArr.length;  
            }
            Customer customer = new Customer(id, name, email, country,adress);           
            customerArr[index] = customer;
            index++;
            line = customerFileReader.readLine() ;
        }
        
        customerFileReader.close();
    }catch (FileNotFoundException e){
        System.out.println("File Costumers not found");
        System.exit(0);
    }

    catch (IOException ioe){
        System.out.println("Error reading from file Customers");
        System.exit(0);
    }
    return customerArr;}
    private static Customer[] customerArrMagnifier(Customer[] arr){
        int length = arr.length;
        Customer[] tempArr = arr;
        arr = new Customer[length*2];
        for (int i = 0; i < length;i++){
           arr[i] = tempArr[i];
            
        }
        return arr;
    }

    //----------------------product files input output-------------------------
    public static Product[] productReader(String str){
        int arrSize =50;
        Product[] productArr = new Product[arrSize];
    
    try{
        
        BufferedReader productFileReader = new BufferedReader(new FileReader(str));
        String id;
        String title ;
        float rate;
        int numberOfReviews;
        float price;
        int index = 0;
        String line = productFileReader.readLine() ;
        line = productFileReader.readLine() ;
        while (line != null){  
            String[] lineArray = line.split(",") ;
            id = lineArray[0] ;
            title = lineArray[1] ;
            rate =Float.parseFloat(lineArray[2]) ;
            numberOfReviews = Integer.parseInt(lineArray[3]) ;
            price = Float.parseFloat(lineArray[4]) ;
            if (index == arrSize){   
                productArr = productArrMagnifier(productArr);
                arrSize = productArr.length;  
            }
            Product product = new Product(id,title,rate,numberOfReviews,price);           
            productArr[index] = product;
            index++;
            line = productFileReader.readLine() ;
        }
        
        productFileReader.close();
    }catch (FileNotFoundException e){
        System.out.println("File Custumers not found");
        System.exit(0);
    }
    
    catch (IOException ioe){
        System.out.println("Error reading from file products");
        System.exit(0);
    }
    return productArr;}

    private static Product[] productArrMagnifier(Product[] arr){
        int length = arr.length;
        Product[] tempArr = arr;
        arr = new Product[length*2];
        for (int i = 0; i < length;i++){
            arr[i] = tempArr[i];
            
        }
        return arr;
    
    }
    //------------------------------- Sales file input output  -----------------------------------

    public static Sales[] salesReader(String str,Customer[] customerArr, Product[] productArr){
        int arrSize =50;
        Sales[] salesArr = new Sales[arrSize];
    
    try{
        
        BufferedReader salesFileReader = new BufferedReader(new FileReader(str));
        String id;
        Customer customer ;
        Product product ;
        String salesDate ;
        int index = 0;
        String line = salesFileReader.readLine() ;
        line = salesFileReader.readLine() ;
        while (line != null){  
            String[] lineArray = line.split(",") ;
            id = lineArray[0] ;
            customer = searchCustomer(lineArray[1], customerArr) ;
            product = searchProduct(lineArray[2],productArr) ;
            salesDate = lineArray[3] ;
            if (index == arrSize){   
                salesArr = salesArrMagnifier(salesArr);
                arrSize = salesArr.length;  
            }
            Sales sales = new Sales(id, customer, product, salesDate);           
            salesArr[index] = sales;
            index++;
            line = salesFileReader.readLine() ;
        }
        
        salesFileReader.close();
    }catch (FileNotFoundException e){
        System.out.println("File Custumers not found");
        System.exit(0);
    }
    
    catch (IOException ioe){
        System.out.println("Error reading from file saless");
        System.exit(0);
    }
    return salesArr;}

    private static Sales[] salesArrMagnifier(Sales[] arr){
        int length = arr.length;
        Sales[] tempArr = arr;
        arr = new Sales[length*2];
        for (int i = 0; i < length;i++){
            arr[i] = tempArr[i];
            
        }
        return arr;
    
    }
    
    private static Customer searchCustomer(String customerId, Customer[] customerArr){
        Customer customer = null;
        for(int i=0; i<customerArr.length; i++){
            if(customerId.equals(customerArr[i].getId())){
                customer = customerArr[i];
                break;
            }
        }
        return customer;
    }

      private static Product searchProduct(String productId, Product[] productArr){
        Product product = null;
        for(int i=0; i< productArr.length; i++){
            if(productId.equals(productArr[i].getId())){
                product = productArr[i];
                break;
            }
        }
        return product;
    }
}       
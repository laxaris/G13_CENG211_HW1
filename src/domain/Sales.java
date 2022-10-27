package domain;
public class Sales{
    private String id;
    private Customer customer;
    private Product product;
    private String salesDate;
    private double salesPrice;

    public Sales(String id, Customer customer, Product product, String salesDate) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.salesDate = salesDate;
        this.salesPrice = product.getPrice()+((product.getRate()/5)*100)*product.getNumberOfReviews();
    }

    public String getId(){
        return id;
    }

    public Customer getCustomer(){
        return customer;
    }

    public Product getProduct(){
        return product;
    }

    public String getSalesDate(){
        return salesDate;
    }
    public double getSalesPrice(){
        return salesPrice;
    }
    public double getProfit(){
        return salesPrice-product.getPrice();
    }

    
}
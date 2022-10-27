package domain;

public class Product {
    private String id;
    private String title;
    private float rate;
    private int numberOfReviews;
    private float price;

    public Product(String id, String title, float rate, int numberOfReviews, float price) {
        if (rate>5){
            System.out.println("Rate can not be greater than 5");
            System.exit(0);
        }
        else{
            this.id = id;
            this.title = title;
            this.rate = rate;
            this.numberOfReviews = numberOfReviews;
            this.price = price;
        }
    }
    
    public String getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public double getRate(){
        return rate;
    }
    public int getNumberOfReviews(){
        return numberOfReviews;
    }
    public double getPrice(){
        return price;
    }

    public String allInfo(){
        return " "+id+" "+title+" "+rate+" "+numberOfReviews+" "+price;
    }
    
}
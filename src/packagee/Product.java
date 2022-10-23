package packagee;

public class Product {
    private String id;
    private String title;
    private double rate;
    private int numberOfReviews;
    private double price;

    public Product(String id, String title, double rate, int numberOfReviews, double price) {
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
}

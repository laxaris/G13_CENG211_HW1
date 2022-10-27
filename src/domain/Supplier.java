package domain;

public class Supplier {
    
    private Product[] productArray;

    Supplier(Product[] array) {
        this.productArray = array;
    }
//look at this method to avoid privacy leak
    public Product[] getProductArray() {
        return productArray;
    }
}








    

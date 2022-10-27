package domain;

public class SalesManagement {
    private Sales[][] salesArray = new Sales[3][];

    SalesManagement(Sales[] array1, Sales[] array2, Sales[] array3) {
        this.salesArray[0] = array1;  //supplier1
        this.salesArray[1] = array2;  //supplier2
        this.salesArray[2] = array3;  //supplier3
    }
    public Sales[][] getSalesArray() {
        return salesArray;
    }
}

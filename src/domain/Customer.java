package domain;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String country;
    private String adress;

    public Customer(String id, String name, String email, String country, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.adress = adress;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getCountry(){
        return country;
    }
    public String getAdress(){
        return adress;
    }
    public String getAllInfo(){
        return " "+id+" "+name+" "+email+" "+country+" "+adress;
    }
}


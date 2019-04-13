package com.example.placeholder;


//class used to create new customer that will be added to database

public class Customer {
    private String name;
    private String email;
    private String password;

    //constructor
    public Customer(){}
    public Customer(String b, String c, String d){
        this.name = b;
        this.email = c;
        this.password = d;
    }

    public void setName(String a){
        this.name= a;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String a){
        this.email= a;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String a){
        this.password= a;
    }

    public String getPassword(){
        return password;
    }

}

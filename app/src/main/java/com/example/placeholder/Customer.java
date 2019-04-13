package com.example.placeholder;

public class Customer {
    private String name;
    private String email;
    private String password;

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

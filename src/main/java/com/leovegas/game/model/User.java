package com.leovegas.game.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private BigDecimal balance;

    //Getters and Setters
    public String getUserId(){
        return id;
    }

    public void setUserId(String userId){
        this.id = userId;
    }

    public String getUserName(){
        return name;
    }

    public void setUserName(String userName) {
        this.name = userName;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

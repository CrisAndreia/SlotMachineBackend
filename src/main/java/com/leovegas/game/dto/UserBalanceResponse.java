package com.leovegas.game.dto;

import java.math.BigDecimal;

//Consults user's balance
public class UserBalanceResponse {
    private String userId;
    private BigDecimal balance;

    public UserBalanceResponse(String userId, BigDecimal balance){
        this.userId = userId;
        this.balance = balance;
    }

    public String getUserId(){
        return userId;
    }

    public BigDecimal getBalance(){
        return balance;
    }
}

package com.leovegas.game.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

public class SlotPlayRequest {
    @NotBlank(message = "User ID is required")
    private String userId;

    @NotNull(message = "Bet amount is required")
    @DecimalMin(value = "1.0", message = "Minimum bet is 1")
    private BigDecimal betAmount;

    //Getters and Setters
    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

}

package com.leovegas.game.dto;

import java.math.BigDecimal;

public class SlotResultResponse {
    private String[][] reels;
    private BigDecimal winnings;
    private BigDecimal balance;
    private boolean isWinner;

    public SlotResultResponse(String[][] reels, BigDecimal winnings, BigDecimal balance, boolean isWinner){
        this.reels = reels;
        this.winnings = winnings;
        this.balance = balance;
        this.isWinner = isWinner;
    }

    public String[][] getReels() {
        return reels;
    }

    public void setReels(String[][] reels) {
        this.reels = reels;
    }

    public BigDecimal getWinnings() {
        return winnings;
    }

    public void setWinnings(BigDecimal winnings) {
        this.winnings = winnings;
    }

    public boolean getIsWinner(){
        return isWinner;
    }

    public void setIsWinner(boolean isWinner){
        this.isWinner = isWinner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

package com.example.coindesk.model;

import javax.persistence.*;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-11:53 AM
 */
public class Currency {

    private String code;

    private String symbol;

    private String rate;

    private String description;

    private Float rateFloat;

    public Currency() {
    }

    public Currency(String code, String symbol, String rate, String description, Float rateFloat) {
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
        this.description = description;
        this.rateFloat = rateFloat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRateFloat() {
        return rateFloat;
    }

    public void setRateFloat(Float rateFloat) {
        this.rateFloat = rateFloat;
    }

    @Override
    public String toString() {
        return "Currency{" +
                ", code='" + code + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rate='" + rate + '\'' +
                ", description='" + description + '\'' +
                ", rateFloat=" + rateFloat +
                '}';
    }
}

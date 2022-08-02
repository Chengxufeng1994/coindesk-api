package com.example.coindesk.model;

import java.util.HashMap;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-3:44 PM
 */
public class CurrencyPrice {
    private Time time;
    private String disclaimer;
    private String charName;
    private HashMap<String, Currency> bpi;

    public CurrencyPrice() {
    }

    public CurrencyPrice(Time time, String disclaimer, String charName, HashMap<String, Currency> bpi) {
        this.time = time;
        this.disclaimer = disclaimer;
        this.charName = charName;
        this.bpi = bpi;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public HashMap<String, Currency> getBpi() {
        return bpi;
    }

    public void setBpi(HashMap<String, Currency> bpi) {
        this.bpi = bpi;
    }
}

package com.example.coindesk.model;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-4:05 PM
 */
public class Time {
    private String updated;
    private String updatedISO;
    private String updateduk;

    public Time() {
    }

    public Time(String updated, String updatedISO, String updateduk) {
        this.updated = updated;
        this.updatedISO = updatedISO;
        this.updateduk = updateduk;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdatedISO() {
        return updatedISO;
    }

    public void setUpdatedISO(String updatedISO) {
        this.updatedISO = updatedISO;
    }

    public String getUpdateduk() {
        return updateduk;
    }

    public void setUpdateduk(String updateduk) {
        this.updateduk = updateduk;
    }
}

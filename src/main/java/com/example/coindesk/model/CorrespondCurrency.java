package com.example.coindesk.model;

import javax.persistence.*;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-5:55 PM
 */
@Entity
@Table(name = "correspond_currency")
public class CorrespondCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "chinese_code")
    private String chineseCode;

    @Column(name = "rate")
    private String rate;

    public CorrespondCurrency() {
    }

    public CorrespondCurrency(String code, String chineseCode, String rate) {
        this.code = code;
        this.chineseCode = chineseCode;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChineseCode() {
        return chineseCode;
    }

    public void setChineseCode(String chineseCode) {
        this.chineseCode = chineseCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CorrespondCurrency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", chineseCode='" + chineseCode + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}

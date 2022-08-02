package com.example.coindesk.service;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-8:13 PM
 */
public enum CurrencyEnum {
    USD("USD", "美元"),
    GBP("GBP", "英鎊"),
    EUR("EUR", "歐元");

    private String code;
    private String chineseName;

    CurrencyEnum(String code, String chineseName) {
        this.code = code;
        this.chineseName = chineseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public static CurrencyEnum getCurrencyEnumByCode(String code) {
        for (CurrencyEnum value : CurrencyEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }

        return null;
    }
}

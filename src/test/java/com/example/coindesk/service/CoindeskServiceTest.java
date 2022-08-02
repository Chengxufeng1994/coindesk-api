package com.example.coindesk.service;

import com.example.coindesk.CoindeskApplication;
import com.example.coindesk.model.CorrespondCurrency;
import com.example.coindesk.model.CurrencyPrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-10:36 PM
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CoindeskApplication.class)
public class CoindeskServiceTest {
    @Autowired
    private CoindeskService coindeskService;

    @Test
    public void getCurrencyPrice() {
        CurrencyPrice currencyPrice = coindeskService.getCurrencyPrice();
    }

    @Test
    public void transformCurrencyPrice() {
        List<CorrespondCurrency> correspondCurrencies = coindeskService.transformCurrencyPrice();
        assertEquals(correspondCurrencies.size(), 3);
    }
}

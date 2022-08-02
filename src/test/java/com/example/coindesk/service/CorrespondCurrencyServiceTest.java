package com.example.coindesk.service;

import com.example.coindesk.CoindeskApplication;
import com.example.coindesk.model.CorrespondCurrency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-10:51 PM
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CoindeskApplication.class)
public class CorrespondCurrencyServiceTest {
    @Autowired
    private CorrespondCurrencyService correspondCurrencyService;

    @Autowired
    private CoindeskService coindeskService;

    @Before
    public void setup() {
        coindeskService.transformCurrencyPrice();
    }

    @Test
    public void getCorrespondCurrencyByCode() {
        CorrespondCurrency entity = correspondCurrencyService.getCorrespondCurrencyByCode("USD");
        System.out.println(entity);
    }

    @Test
    public void updateCorrespondCurrencyByCode() {
        CorrespondCurrency correspondCurrency = new CorrespondCurrency("USD", "美元", "111111");
        CorrespondCurrency entity = correspondCurrencyService.updateCorrespondCurrencyByCode("USD", correspondCurrency);
        System.out.println(entity);
    }

    @Test
    public void createCorrespondCurrencyByCode() {
        CorrespondCurrency correspondCurrency = new CorrespondCurrency("TEST", "TEST", "111111");
        CorrespondCurrency entity = correspondCurrencyService.createCorrespondCurrency(correspondCurrency);
        System.out.println(entity);
    }

    @Test
    public void deleteCorrespondCurrencyByCode() {
        CorrespondCurrency correspondCurrency = new CorrespondCurrency("TEST", "TEST", "111111");
        CorrespondCurrency entity = correspondCurrencyService.createCorrespondCurrency(correspondCurrency);

        correspondCurrencyService.deleteCorrespondCurrencyByCode("TEST");
    }
}

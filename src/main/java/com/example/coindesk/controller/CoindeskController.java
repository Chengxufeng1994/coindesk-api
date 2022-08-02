package com.example.coindesk.controller;

import com.example.coindesk.model.CorrespondCurrency;
import com.example.coindesk.model.CurrencyPrice;
import com.example.coindesk.service.CoindeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-12:05 PM
 */
@RestController
@RequestMapping("/api/coindesk")
public class CoindeskController {

    @Autowired
    private CoindeskService coindeskService;

    @RequestMapping("/get")
    public ResponseEntity<?> getCoindesk() {
        CurrencyPrice currencyPrice = coindeskService.getCurrencyPrice();

        return new ResponseEntity<>(currencyPrice, HttpStatus.OK);
    }

    @RequestMapping("/transform")
    public ResponseEntity<List<CorrespondCurrency>> transformCoinDesk() {
        List<CorrespondCurrency> correspondCurrencies = coindeskService.transformCurrencyPrice();

        return new ResponseEntity<>(correspondCurrencies, HttpStatus.OK);
    }
}

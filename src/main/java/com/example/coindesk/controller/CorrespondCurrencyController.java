package com.example.coindesk.controller;

import com.example.coindesk.model.CorrespondCurrency;
import com.example.coindesk.service.CorrespondCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-12:21 PM
 */

@RestController
@RequestMapping("/api/correspondcurrency")
public class CorrespondCurrencyController {

    @Autowired
    private CorrespondCurrencyService correspondCurrencyService;

    @GetMapping("/updatedtime")
    public ResponseEntity<String> getUpdatedTime() {
        String updateTime = correspondCurrencyService.getUpdateTime();
        return new ResponseEntity<>(updateTime, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createCorrespondCurrency(@RequestBody CorrespondCurrency correspondCurrency) {
        try {
            correspondCurrencyService.createCorrespondCurrency(correspondCurrency);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<CorrespondCurrency> getCorrespondCurrencyByCode(@PathVariable("code") String code) {
        try {
            CorrespondCurrency correspondCurrency = correspondCurrencyService.getCorrespondCurrencyByCode(code);
            return new ResponseEntity<CorrespondCurrency>(correspondCurrency, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{code}")
    public ResponseEntity<CorrespondCurrency> updateCorrespondCurrencyByCode(@PathVariable("code") String code, @RequestBody CorrespondCurrency correspondCurrency) {
        try {
            CorrespondCurrency _correspondCurrency = correspondCurrencyService.updateCorrespondCurrencyByCode(code, correspondCurrency);
            return new ResponseEntity<CorrespondCurrency>(_correspondCurrency, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCorrespondCurrencyByCode(@PathVariable("code") String code) {
        try {
            correspondCurrencyService.deleteCorrespondCurrencyByCode(code);
            return new ResponseEntity<CorrespondCurrency>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

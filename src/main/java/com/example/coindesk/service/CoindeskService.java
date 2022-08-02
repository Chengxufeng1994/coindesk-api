package com.example.coindesk.service;

import com.example.coindesk.model.CorrespondCurrency;
import com.example.coindesk.model.Currency;
import com.example.coindesk.model.CurrencyPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-3:28 PM
 */

@Service
public class CoindeskService {

    private final String COINDESK_URI = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CorrespondCurrencyService correspondCurrencyService;

    @Autowired
    private UpdateTimeRecordService updateTimeRecordService;

    public CurrencyPrice getCurrencyPrice() {

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        restTemplate.setMessageConverters(messageConverters);

        return restTemplate.getForObject(COINDESK_URI, CurrencyPrice.class);
    }

    public List<CorrespondCurrency> transformCurrencyPrice() {

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);

        restTemplate.setMessageConverters(messageConverters);
        CurrencyPrice currencyPrice = restTemplate.getForObject(COINDESK_URI, CurrencyPrice.class);

        List<CorrespondCurrency> correspondCurrencies = this.convert2CorrespondCurrency(currencyPrice);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        String updated = currencyPrice.getTime().getUpdatedISO();
        Date date = null;
        try {
            date = sdf.parse(updated);
            if (updateTimeRecordService.getRecordByType("correspondCurrency") != null) {
                updateTimeRecordService.updateByType("correspondCurrency", date.getTime());
            }
        } catch (Exception e) {
            updateTimeRecordService.saveByType("correspondCurrency", date.getTime());
        }

        return correspondCurrencies;
    }

    private List<CorrespondCurrency> convert2CorrespondCurrency(CurrencyPrice currencyPrice) {
        List<CorrespondCurrency> list = new ArrayList<>();

        HashMap<String, Currency> bpi = currencyPrice.getBpi();
        for (String key : bpi.keySet()) {
            Currency currency = bpi.get(key);
            CorrespondCurrency correspondCurrency = new CorrespondCurrency();
            String code = currency.getCode();
            CurrencyEnum currencyEnum = CurrencyEnum.getCurrencyEnumByCode(currency.getCode());
            String chineseName = currencyEnum.getChineseName();
            correspondCurrency.setCode(code);
            correspondCurrency.setChineseCode(chineseName);
            correspondCurrency.setRate(currency.getRate());

            try {
                if (correspondCurrencyService.getCorrespondCurrencyByCode(code) != null) {
                    list.add(correspondCurrencyService.updateCorrespondCurrencyByCode(code, correspondCurrency));
                }
            } catch (Exception e) {
                list.add(correspondCurrencyService.createCorrespondCurrency(correspondCurrency));
            }

        }

        return list;
    }
}

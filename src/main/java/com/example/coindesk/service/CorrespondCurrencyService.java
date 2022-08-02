package com.example.coindesk.service;

import com.example.coindesk.model.CorrespondCurrency;
import com.example.coindesk.model.UpdatedTimeRecord;
import com.example.coindesk.repository.CorrespondCurrencyRepository;
import com.example.coindesk.repository.UpdatedTimeRecordRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-6:04 PM
 */
@Service
public class CorrespondCurrencyService {

    @Autowired
    private CorrespondCurrencyRepository correspondCurrencyRepository;

    @Autowired
    private UpdatedTimeRecordRepository updatedTimeRecordRepository;

    public CorrespondCurrency createCorrespondCurrency(CorrespondCurrency correspondCurrency) {
        CorrespondCurrency existingEntity = correspondCurrencyRepository.findByCode(correspondCurrency.getCode());
        if (existingEntity != null) {
            throw new ServiceException("Correspond Currency duplicate");
        }
        CorrespondCurrency newEntity = new CorrespondCurrency(correspondCurrency.getCode(), correspondCurrency.getChineseCode(), correspondCurrency.getRate());
        return correspondCurrencyRepository.save(newEntity);
    }

    public CorrespondCurrency getCorrespondCurrencyByCode(String code) {
        CorrespondCurrency correspondCurrency = correspondCurrencyRepository.findByCode(code);

        CorrespondCurrency existingEntity = correspondCurrencyRepository.findByCode(correspondCurrency.getCode());
        if (existingEntity == null) {
            throw new ServiceException("Correspond Currency not found");
        }

        return correspondCurrency;
    }

    public CorrespondCurrency updateCorrespondCurrencyByCode(String code, CorrespondCurrency correspondCurrency) {
        CorrespondCurrency existingEntity = correspondCurrencyRepository.findByCode(code);
        if (existingEntity == null) {
            throw new ServiceException("Correspond Currency not found");
        }
        CorrespondCurrency existingCorrespondCurrency = correspondCurrencyRepository.findByCode(code);
        existingCorrespondCurrency.setChineseCode(correspondCurrency.getChineseCode());
        existingCorrespondCurrency.setRate(correspondCurrency.getRate());

        return correspondCurrencyRepository.save(existingCorrespondCurrency);
    }

    public void deleteCorrespondCurrencyByCode(String code) {
        CorrespondCurrency existingEntity = correspondCurrencyRepository.findByCode(code);
        if (existingEntity == null) {
            throw new ServiceException("Correspond Currency not found");
        }

        correspondCurrencyRepository.deleteByCode(code);
    }

    public String getUpdateTime() {
        UpdatedTimeRecord updatedTimeRecord = updatedTimeRecordRepository.findByType("correspondCurrency");
        Long updatedTime = updatedTimeRecord.getUpdatedTime();
        Timestamp ts = new Timestamp(updatedTime);
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = sdf.format(ts);
        return format;
    }
}

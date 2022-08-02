package com.example.coindesk.service;

import com.example.coindesk.model.UpdatedTimeRecord;
import com.example.coindesk.repository.UpdatedTimeRecordRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-9:35 PM
 */
@Service
public class UpdateTimeRecordService {

    @Autowired
    private UpdatedTimeRecordRepository updatedTimeRecordRepository;

    public UpdatedTimeRecord getRecordByType(String type) {
        UpdatedTimeRecord entity = updatedTimeRecordRepository.findByType(type);
        if (entity == null) {
            throw new ServiceException("UpdatedTimeRecord not found");
        }

        return entity;
    }

    public UpdatedTimeRecord saveByType(String type, Long timestamp) {
        UpdatedTimeRecord existingEntity = updatedTimeRecordRepository.findByType(type);
        if (existingEntity != null) {
            throw new ServiceException("UpdatedTimeRecord Duplicate");
        }

        UpdatedTimeRecord entity = new UpdatedTimeRecord(type, timestamp);
        UpdatedTimeRecord result = updatedTimeRecordRepository.save(entity);

        return result;
    }

    public UpdatedTimeRecord updateByType(String type, Long timestamp) {
        UpdatedTimeRecord existingEntity = updatedTimeRecordRepository.findByType(type);
        if (existingEntity == null) {
            throw new ServiceException("UpdatedTimeRecord not found");
        }
        existingEntity.setUpdatedTime(timestamp);
        UpdatedTimeRecord result = updatedTimeRecordRepository.save(existingEntity);

        return result;
    }
}

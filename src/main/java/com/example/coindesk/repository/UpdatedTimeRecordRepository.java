package com.example.coindesk.repository;

import com.example.coindesk.model.UpdatedTimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-9:27 PM
 */
public interface UpdatedTimeRecordRepository extends JpaRepository<UpdatedTimeRecord, Long> {
    UpdatedTimeRecord findByType(String type);
}

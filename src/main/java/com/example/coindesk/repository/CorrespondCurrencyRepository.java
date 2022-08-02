package com.example.coindesk.repository;

import com.example.coindesk.model.CorrespondCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-11:59 AM
 */
public interface CorrespondCurrencyRepository extends JpaRepository<CorrespondCurrency, Long> {
    CorrespondCurrency findByCode(String code);

    @Modifying
    @Transactional
    Long deleteByCode(String code);
}

package com.example.coindesk.model;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author xufeng
 * @Description
 * @Date 2022-08-02-9:20 PM
 */
@Entity
@Table(name = "updated_time_record")
public class UpdatedTimeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "updated_time")
    private Long updatedTime;

    public UpdatedTimeRecord() {
    }

    public UpdatedTimeRecord(String type, Long updatedTime) {
        this.type = type;
        this.updatedTime = updatedTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }
}

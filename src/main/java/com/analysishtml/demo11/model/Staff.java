package com.analysishtml.demo11.model;

import lombok.Data;

import java.util.Date;

@Data
public class Staff {
    private Integer id;
    private Integer contentId;
    private String auCompany;
    private String auditor;
    private Date creatTime;
    private Date updateTime;
    private Integer isDel;
}

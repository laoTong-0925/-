package com.analysishtml.demo11.model;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private Integer id;
    private String title;
    private Integer staffGroupId;
    private Integer infoId;
    private Date creatTime;
    private Date updateTime;
    private Integer isDel;
}

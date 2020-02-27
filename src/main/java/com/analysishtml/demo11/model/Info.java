package com.analysishtml.demo11.model;

import lombok.Data;

import java.util.Date;

@Data
public class Info {
    private Integer id;
    private String inde;
    private String promulgator;
    private String analogy;
    private String promTime;
    private String designation;
    private String symbol;
    private String heading;
    private Integer contentId;
    private Date creatTime;
    private Date updateTime;
    private Integer isDel;

}

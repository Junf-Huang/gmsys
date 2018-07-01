package com.exercise.gmsys.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Asset implements Serializable {
    private Integer BID;

    private String BNAME;

    private Double BCOUNT;

    private BigDecimal PRICE;

    private Date BDATE;

    private Integer CID;

    private Integer DEPARTID;

    private String categoryName;

    private static final long serialVersionUID = 1L;


}
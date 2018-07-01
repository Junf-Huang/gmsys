package com.exercise.gmsys.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Buy implements Serializable {
    private Integer BUYID;

    private Double BUYCOUNT;

    private Date BUYTIME;

    private Integer PROVID;

    private Integer DEPARTID;

    private Integer productID;

    private static final long serialVersionUID = 1L;


}
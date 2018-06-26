package com.exercise.gmsys.model;

import java.io.Serializable;
import java.util.Date;

public class UserAccount implements Serializable {
    private Integer USERID;

    private String USERNAME;

    private String ACCOUNTS;

    private String PASSWORD;

    private String SEX;

    private Date AGE;

    private String PHONE;

    private Date RAGEDATE;

    private Integer RID;

    private Integer DEPARTID;

    private static final long serialVersionUID = 1L;

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME == null ? null : USERNAME.trim();
    }

    public String getACCOUNTS() {
        return ACCOUNTS;
    }

    public void setACCOUNTS(String ACCOUNTS) {
        this.ACCOUNTS = ACCOUNTS == null ? null : ACCOUNTS.trim();
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD == null ? null : PASSWORD.trim();
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX == null ? null : SEX.trim();
    }

    public Date getAGE() {
        return AGE;
    }

    public void setAGE(Date AGE) {
        this.AGE = AGE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE == null ? null : PHONE.trim();
    }

    public Date getRAGEDATE() {
        return RAGEDATE;
    }

    public void setRAGEDATE(Date RAGEDATE) {
        this.RAGEDATE = RAGEDATE;
    }

    public Integer getRID() {
        return RID;
    }

    public void setRID(Integer RID) {
        this.RID = RID;
    }

    public Integer getDEPARTID() {
        return DEPARTID;
    }

    public void setDEPARTID(Integer DEPARTID) {
        this.DEPARTID = DEPARTID;
    }
}
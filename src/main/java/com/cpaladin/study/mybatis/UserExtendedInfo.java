package com.cpaladin.study.mybatis;

import java.io.Serializable;
import java.util.Date;

public class UserExtendedInfo implements Serializable {

    private static final long serialVersionUID = -7986975215507115156L;

    private String gameinternalno;
    private String mobile;
    private String mobile1;
    private String mobile2;
    private String mobile3;
    private String mobileExt;
    private int mobileCurr;
    private String email;
    private String emailExt;
    private Date mobileTime;
    private Date emailTime;
    private String ext;

    public String getGameinternalno() {
        return gameinternalno;
    }

    public void setGameinternalno(String gameinternalno) {
        this.gameinternalno = gameinternalno;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getMobile3() {
        return mobile3;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getMobileExt() {
        return mobileExt;
    }

    public void setMobileExt(String mobileExt) {
        this.mobileExt = mobileExt;
    }

    public int getMobileCurr() {
        return mobileCurr;
    }

    public void setMobileCurr(int mobileCurr) {
        this.mobileCurr = mobileCurr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailExt() {
        return emailExt;
    }

    public void setEmailExt(String emailExt) {
        this.emailExt = emailExt;
    }

    public Date getMobileTime() {
        return mobileTime;
    }

    public void setMobileTime(Date mobileTime) {
        this.mobileTime = mobileTime;
    }

    public Date getEmailTime() {
        return emailTime;
    }

    public void setEmailTime(Date emailTime) {
        this.emailTime = emailTime;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("gameinternalno=").append(gameinternalno).append(" ");
        sb.append("mobile=").append(mobile).append(" ");
        sb.append("mobile1=").append(mobile1).append(" ");
        sb.append("mobile2=").append(mobile2).append(" ");
        sb.append("mobile3=").append(mobile3).append(" ");
        sb.append("mobileExt=").append(mobileExt).append(" ");
        sb.append("mobileCurr=").append(mobileCurr).append(" ");
        sb.append("email=").append(email).append(" ");
        sb.append("emailExt=").append(emailExt).append(" ");
        sb.append("mobileTime=").append(mobileTime).append(" ");
        sb.append("emailTime=").append(emailTime).append(" ");
        sb.append("ext=").append(ext).append(" ");
        return sb.toString();
    }
    
            
}

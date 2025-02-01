package com.gymmembership.system.model;

import java.sql.Date;

public class Payment {
    private int paymentId; 
    private int paymentAmount;
    private Date paymentPaymentDate; 
    private String paymentMode;
    private int paymentPackageId; 
    private int paymentUserId; 

    public Payment(int paymentId, int paymentAmount, Date paymentPaymentDate, String paymentMode, int paymentPackageId, int paymentUserId) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentPaymentDate = paymentPaymentDate;
        this.paymentMode = paymentMode;
        this.paymentPackageId = paymentPackageId;
        this.paymentUserId = paymentUserId;
    }

    
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentPaymentDate() {
        return paymentPaymentDate;
    }

    public void setPaymentPaymentDate(Date paymentPaymentDate) {
        this.paymentPaymentDate = paymentPaymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getPaymentPackageId() {
        return paymentPackageId;
    }

    public void setPaymentPackageId(int paymentPackageId) {
        this.paymentPackageId = paymentPackageId;
    }

    public int getPaymentUserId() {
        return paymentUserId;
    }

    public void setPaymentUserId(int paymentUserId) {
        this.paymentUserId = paymentUserId;
    }
    
    
}

package com.plugify.model;

import java.util.Date;

public class Alert {
    private int idAlert;
    private String alertType;
    private String message;
    private Date alertDate;

    // Construtores
    public Alert(int idAlert, String alertType, String message, Date alertDate) {
        this.idAlert = idAlert;
        this.alertType = alertType;
        this.message = message;
        this.alertDate = alertDate;
    }

    // Getters e Setters
    public int getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(int idAlert) {
        this.idAlert = idAlert;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }
}

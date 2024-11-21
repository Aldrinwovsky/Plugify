package br.com.plugify.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Alert {
    private int idAlert;
    private String alertType;
    private String message;
    private Timestamp alertDate;

    // Construtores
    public Alert(int idAlert, String alertType, String message, Timestamp alertDate) {
        this.idAlert = idAlert;
        this.alertType = alertType;
        this.message = message;
        this.alertDate = alertDate;
    }
    public Alert(String alertType, String message, Timestamp alertDate) {
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

    public Timestamp getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Timestamp alertDate) {
        this.alertDate = alertDate;
    }
}

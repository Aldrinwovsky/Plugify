package com.plugify.model;

import java.util.Date;

public class Consumption {
    private int idConsumption;
    private Date consumptionDate;
    private double amount;
    private Outlet outlet;

    // Construtores
    public Consumption(int idConsumption, Date consumptionDate, double amount, Outlet outlet) {
        this.idConsumption = idConsumption;
        this.consumptionDate = consumptionDate;
        this.amount = amount;
        this.outlet = outlet;
    }

    // Getters e Setters
    public int getIdConsumption() {
        return idConsumption;
    }

    public void setIdConsumption(int idConsumption) {
        this.idConsumption = idConsumption;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }
}

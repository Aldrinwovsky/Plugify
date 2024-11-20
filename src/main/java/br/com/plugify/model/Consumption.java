package br.com.plugify.model;

import br.com.plugify.model.Outlet;

import java.sql.Date;
import java.sql.Timestamp;

public class Consumption {
    private int idConsumption;
    private Timestamp consumptionDate;
    private double amount;
    private Outlet outlet;

    // Construtores
    public Consumption(int idConsumption, Timestamp consumptionDate, double amount, Outlet outlet) {
        this.idConsumption = idConsumption;
        this.consumptionDate = consumptionDate;
        this.amount = amount;
        this.outlet = outlet;
    }
    public Consumption(Timestamp consumptionDate, double amount, Outlet outlet) {
        this.idConsumption = idConsumption;
        this.consumptionDate = consumptionDate;
        this.amount = amount;
        this.outlet = outlet;
    }

    public Consumption(Timestamp consumptionDate, double amount, int codigoTomada) {
        this.idConsumption = idConsumption;
        this.consumptionDate = consumptionDate;
        this.amount = amount;
        this.outlet = outlet;
    }

    public Consumption(int a){
        this.outlet.setIdOutlet(a);
    }





    // Getters e Setters
    public int getIdConsumption() {
        return idConsumption;
    }

    public void setIdConsumption(int idConsumption) {
        this.idConsumption = idConsumption;
    }

    public Timestamp getConsumptionTimestamp() {
        return consumptionDate;
    }

    public void setConsumptionDate(Timestamp consumptionDate) {
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

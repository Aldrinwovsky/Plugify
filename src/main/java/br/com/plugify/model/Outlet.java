package com.plugify.model;

public class Outlet {
    private int idOutlet;
    private String name;
    private String macAddress;
    private int status;
    private Room room;

    // Construtores
    public Outlet(int idOutlet, String name, String macAddress, int status, Room room) {
        this.idOutlet = idOutlet;
        this.name = name;
        this.macAddress = macAddress;
        this.status = status;
        this.room = room;
    }

    // Getters e Setters
    public int getIdOutlet() {
        return idOutlet;
    }

    public void setIdOutlet(int idOutlet) {
        this.idOutlet = idOutlet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

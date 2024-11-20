package br.com.plugify.model;

public class Outlet {
    private int idOutlet;
    private String name;
    private String macAddress;
    private boolean status;
    private Room room;
    private int idRoom;

    // Construtores
    public Outlet(int idOutlet, String name, String macAddress, boolean status, Room room) {
        this.idOutlet = idOutlet;
        this.name = name;
        this.macAddress = macAddress;
        this.status = status;
        this.room = room;
    }
    public Outlet(int idOutlet, String name, String macAddress, boolean status, int idroom) {
        this.idOutlet = idOutlet;
        this.name = name;
        this.macAddress = macAddress;
        this.status = status;
        this.idRoom = idroom;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

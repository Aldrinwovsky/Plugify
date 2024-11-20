package br.com.plugify.model;

public class Room {
    private int idRoom;
    private String name;
    private String description;

    // Construtor completo (com ID)
    public Room(int idRoom, String name, String description) {
        this.idRoom = idRoom;
        this.name = name;
        this.description = description;
    }

    // Construtor sem ID (usado ao cadastrar)
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Room(int roomsIdRoom) {
        this.idRoom = roomsIdRoom;
    }

    // Getters e Setters
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

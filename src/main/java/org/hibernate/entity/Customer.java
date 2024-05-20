package org.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int contact;
    private String email;
    private int roomAllotted;
    private int checkIn;
    private int checkOut;

    public Customer(){

    }
    public Customer(int id, String name, int contact, String email, int roomAllotted, int checkIn, int checkOut) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.roomAllotted = roomAllotted;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomAllotted() {
        return roomAllotted;
    }

    public void setRoomAllotted(int roomAllotted) {
        this.roomAllotted = roomAllotted;
    }

    public int getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int checkIn) {
        this.checkIn = checkIn;
    }

    public int getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(int checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", roomAllotted=" + roomAllotted +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}


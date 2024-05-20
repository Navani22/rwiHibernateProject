package org.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNo;

    private int noOfBeds;

    private String roomType;


    public Room(int id){

        this.id = id;
    }

    public Room(int id, int roomNo, int noOfBeds, String roomType) {
        this.id = id;
        this.roomNo = roomNo;
        this.noOfBeds = noOfBeds;
        this.roomType = roomType;
    }



    public Room() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", noOfBeds=" + noOfBeds +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}

package org.hibernate.dao;

import org.hibernate.entity.Room;
import org.hibernate.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import java.util.List;

public class RoomDao {

    public void saveRoom(int roomNo, int noOfBeds, String roomType) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Room room = new Room();
            room.setRoomNo(roomNo);
            room.setNoOfBeds(noOfBeds);
            room.setRoomType(roomType);
            session.save(room);
            transaction.commit();
            System.out.println("Room added successfully");
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Room> getRooms() {
        Session session = HibernateUtil.getSession();
        Query<Room> query = session.createQuery("from Room", Room.class);
        List<Room> rooms = query.list();
        session.close();
        return rooms;
    }

    public int updateRoom(Room room) {
        if (room.getRoomNo() <= 0) return 0;
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Room set noOfBeds = :noOfBeds, roomType = :roomType where roomNo = :roomNo";
        Query query = session.createQuery(hql);
        query.setParameter("roomNo", room.getRoomNo());
        query.setParameter("noOfBeds", room.getNoOfBeds());
        query.setParameter("roomType", room.getRoomType());
        int rowCount = query.executeUpdate();
        tx.commit();
        session.close();
        return rowCount;
    }

    public int deleteRoom(int roomNo) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Room where roomNo = :roomNo";
        Query query = session.createQuery(hql);
        query.setParameter("roomNo", roomNo);
        int rowCount = query.executeUpdate();
        tx.commit();
        session.close();
        return rowCount;
    }
}

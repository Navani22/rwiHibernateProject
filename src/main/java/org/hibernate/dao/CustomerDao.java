package org.hibernate.dao;

import org.hibernate.entity.Customer;
import org.hibernate.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao {

    //1. Saving Customer
    public void saveCustomer(String name, int contact, String email, int roomAllotted, int checkIn, int checkOut) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Customer customer = new Customer();
            customer.setName(name);
            customer.setContact(contact);
            customer.setEmail(email);
            customer.setRoomAllotted(roomAllotted);
            customer.setCheckIn(checkIn);
            customer.setCheckOut(checkOut);
            session.save(customer);
            transaction.commit();
            System.out.println("Customer added successfully");
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //2. Getting Customer
    public List<Customer> getCustomers() {
        Session session = HibernateUtil.getSession();
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.list();
        session.close();
        return customers;
    }


//3. Updating Details
    public int updateCustomer(Customer customer) {
        if (customer.getId() <= 0) return 0;
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Customer set name = :name, contact = :contact, email = :email, roomAllotted = :roomAllotted, checkIn = :checkIn, checkOut = :checkOut where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", customer.getId());
        query.setParameter("name", customer.getName());
        query.setParameter("contact", customer.getContact());
        query.setParameter("email", customer.getEmail());
        query.setParameter("roomAllotted", customer.getRoomAllotted());
        query.setParameter("checkIn", customer.getCheckIn());
        query.setParameter("checkOut", customer.getCheckOut());
        int rowCount = query.executeUpdate();
        tx.commit();
        session.close();
        return rowCount;
    }
//4. Deleting Customer
    public int deleteCustomer(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Customer where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        int rowCount = query.executeUpdate();
        tx.commit();
        session.close();
        return rowCount;
    }
}

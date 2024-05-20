package org.hibernate;

import java.util.List;
import java.util.Scanner;
import org.hibernate.dao.CustomerDao;
import org.hibernate.dao.RoomDao;
import org.hibernate.entity.Customer;
import org.hibernate.entity.Room;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerDao customerDao = new CustomerDao();
        RoomDao roomDao = new RoomDao();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a Customer");
            System.out.println("2. View all Customers");
            System.out.println("3. Update a Customer");
            System.out.println("4. Delete a Customer");
            System.out.println("5. Add a Room");
            System.out.println("6. View all Rooms");
            System.out.println("7. Update a Room");
            System.out.println("8. Delete a Room");
            System.out.println("9. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //CRUD Operations for CUSTOMER's

                case 1://Adding Customer
                    System.out.println("Enter Customer Name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter Customer Contact:");
                    int customerContact = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Customer Email:");
                    String customerEmail = scanner.nextLine();
                    System.out.println("Enter Room Allotted:");
                    int roomAllotted = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Check-In Date (DDMMYYYY):");
                    int checkIn = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Check-Out Date (DDMMYYYY):");
                    int checkOut = scanner.nextInt();
                    scanner.nextLine();

                    customerDao.saveCustomer(customerName, customerContact, customerEmail, roomAllotted, checkIn, checkOut);
                    System.out.println("Customer added successfully!");
                    break;

                case 2:// getting Customer details
                    List<Customer> customers = customerDao.getCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;

                case 3:// Updating Customer
                    System.out.println("Enter Customer ID to update:");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer customerToUpdate = new Customer();
                    customerToUpdate.setId(customerId);
                    System.out.println("Enter new Customer Name:");
                    customerToUpdate.setName(scanner.nextLine());
                    System.out.println("Enter new Customer Contact:");
                    customerToUpdate.setContact(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new Customer Email:");
                    customerToUpdate.setEmail(scanner.nextLine());
                    System.out.println("Enter new Room Allotted:");
                    customerToUpdate.setRoomAllotted(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new Check-In Date (DDMMYYYY):");
                    customerToUpdate.setCheckIn(scanner.nextInt());
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new Check-Out Date (DDMMYYYY):");
                    customerToUpdate.setCheckOut(scanner.nextInt());
                    scanner.nextLine(); // Consume newline

                    int updatedRows = customerDao.updateCustomer(customerToUpdate);
                    System.out.println("Updated Customer :)");
                    break;

                case 4:// Deleting Customer
                    System.out.println("Enter Customer ID to delete:");
                    int customerIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    int deletedRows = customerDao.deleteCustomer(customerIdToDelete);
                    System.out.println("Deleted Customer :(");
                    break;

             //CRUD Operations for ROOM's
                case 5:// adding room
                    System.out.println("Enter Room Number:");
                    int roomNo = scanner.nextInt();
                    System.out.println("Enter Number of Beds:");
                    int noOfBeds = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter Room Type:");
                    String roomType = scanner.nextLine();

                    roomDao.saveRoom(roomNo, noOfBeds, roomType);
                    System.out.println("Room added successfully!");
                    break;

                case 6: //viewing all room details
                    List<Room> rooms = roomDao.getRooms();
                    for (Room room : rooms) {
                        System.out.println(room);
                    }
                    break;

                case 7:// updating details
                    System.out.println("Enter Room Number to update:");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();
                    Room roomToUpdate = new Room();
                    roomToUpdate.setRoomNo(roomNumber);
                    System.out.println("Enter new Number of Beds:");
                    roomToUpdate.setNoOfBeds(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter new Room Type:");
                    roomToUpdate.setRoomType(scanner.nextLine());

                    int updatedRoomRows = roomDao.updateRoom(roomToUpdate);
                    System.out.println("Updated Successfully!!!");
                    break;

                case 8:// deleting room
                    System.out.println("Enter Room Number to delete:");
                    int roomNumberToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    int deletedRoomRows = roomDao.deleteRoom(roomNumberToDelete);
                    System.out.println("Deleted Successfully!!!");
                    break;

                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

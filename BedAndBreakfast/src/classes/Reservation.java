/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Kevin
 */
public class Reservation {
    //variables
    private String street;
    private String city;
    private String state;
    private String zip;
    private String guestNumber; //guest_no
    private String checkIn; //in_date
    private String checkOut; //out_date
    private String resNo; //res_no which is unique reservation number
    private String roomNumber; //rm_no
    private String price; //price is double in DB
    private String status; // status is number in DB
    
    //constructors
    public Reservation() {
        //empty
    }
    //reservation for database insert //brand new reservations
    public Reservation(String roomNumber, String guestNumber, 
            String checkIn, String checkOut) {
        this.resNo = null;
        this.roomNumber  = roomNumber;
        this.guestNumber = guestNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = "85.00";
        this.status = "0"; 
    }
    public Reservation(String roomNumber, String guestNumber, String checkIn,
            String checkOut, String price, String status) {
        this.resNo = null;
        this.roomNumber  = roomNumber;
        this.guestNumber = guestNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.status = status; 
    }
    //constructor used to build Reservation for Reservation Management Module
    public Reservation(String resNo, String room, String checkIn, 
            String checkOut, String guestNo) {
        this.resNo = resNo;
        this.roomNumber = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestNumber = guestNo;
    }
    //end constructors

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the guestNumber
     */
    public String getGuestNumber() {
        return guestNumber;
    }

    /**
     * @param guestNumber the guestNumber to set
     */
    public void setGuestNumber(String guestNumber) {
        this.guestNumber = guestNumber;
    }

    /**
     * @return the checkIn
     */
    public String getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public String getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the resNo
     */
    public String getResNo() {
        return resNo;
    }

    /**
     * @param resNo the resNo to set
     */
    public void setResNo(String resNo) {
        this.resNo = resNo;
    }

    /**
     * @return the roomNumber
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

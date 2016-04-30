/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author prasanna
 */
public class Hotel {
    private String hotelID;
    private String hotelName;
    
    public Hotel(String hotelID, String hotelName){
        this.hotelID = hotelID;
        this.hotelName = hotelName;
    }
    public String getHotelID(){
        return hotelID;
    }
    public String getHotelName(){
        return hotelName;
    }
    
    public void setHotelID(String hotelID){
        this.hotelID = hotelID;
    }
    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
}

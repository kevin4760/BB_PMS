/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.ErrorHandling;
import classes.Guest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Aaron
 */
public class GuestDAO {
    
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    
    //connection
    DBConnection gc = new DBConnection();

    /**
     * Inserts new employee into database
     * @param guest     
     */
    public void insertGuest(Guest guest){
        //Gets Database Connection
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        //Inserts Into Database to Create Guest Try Catch Block
        try{
            //Inserts Information into guests data table
            PreparedStatement insertGuest=gc.getConn()
                    .prepareStatement("INSERT INTO guests VALUES(?,?,?,?)");
            insertGuest.setString(1, guest.getGuestNumber());
            insertGuest.setString(2, guest.getLastName());
            insertGuest.setString(3, guest.getFirstName());
            insertGuest.setString(4, guest.getTitle());  
            
            //Inserts Information into addresses table
            PreparedStatement insertAddress=gc.getConn()
                    .prepareStatement("INSERT INTO addresses VALUES(?,?,?,?,?)");
            insertAddress.setString(1, guest.getGuestNumber());
            insertAddress.setString(2, guest.getStreet());
            insertAddress.setString(3, guest.getCity());
            insertAddress.setString(4, guest.getState());
            insertAddress.setString(5, guest.getZipCode());
            insertGuest.executeQuery();
            insertAddress.executeQuery();
            //Conformation Message
            showMessageDialog(null, "Guest Created");
            //Close DB Connection
            gc.getConn().close();
        }
        catch(SQLException ex){
            ErrorHandling.displayException(ex);
        }
    }

    //Searchs for Guest By guestNumber, first and last name, or street and zip code
    public ArrayList<Guest> searchGuest(String firstName,String lastName,
            String guestNumber,String street, String zipCode){
        
        //Creates the Guest List
        ArrayList<Guest> guestList=new ArrayList<>();
        
        //Creates the Database Connection
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return guestList;
        }
        
        //Database Search Statement
        String sql="SELECT * FROM GUESTS, ADDRESSES WHERE (GUESTS.GUEST_NO = ADDRESSES.GUEST_NO)"+
                    "AND (guests.guest_no = '"+guestNumber+"')"+ 
                    "OR (GUESTS.FIRST_NAME='"+firstName+"') AND (GUESTS.LAST_NAME='"+lastName+"')"+
                    "OR (ADDRESSES.STREET ='"+street+"') AND (ADDRESSES.ZIP='"+zipCode+"')";
        
        //Adds the Information to the Search ComboBox
        try{
            stmt=gc.getConn().createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                guestList.add(new Guest(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        }
        catch(SQLException ex){
            System.out.println("whoops"); //replace with a real exception
            ErrorHandling.displayException(ex);
        }
        //Returns the List
        return guestList;       
    }//end guestSearch()   
    
    //method guestUpdate()
    public void updateGuest(Guest guest) {
        //Gets Database Connection
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        //Inserts Into Database to Create Guest Try Catch Block
        try{
            //Updates information into guests data table
            ps=gc.getConn()
                    .prepareStatement("UPDATE guests SET last_name=?, "
                            + "first_name=?, title=? WHERE guest_no=?");
            ps.setString(1, guest.getLastName());
            ps.setString(2, guest.getFirstName());
            ps.setString(3, guest.getTitle());
            ps.setString(4, guest.getGuestNumber());
            ps.executeQuery();
            
            //Updates information into addresses table
            ps=gc.getConn()
                    .prepareStatement("UPDATE addresses SET street=?, city=?,"
                            + " state=?, zip=? WHERE guest_no=?");
            ps.setString(1, guest.getStreet());
            ps.setString(2, guest.getCity());
            ps.setString(3, guest.getState());
            ps.setString(4, guest.getZipCode());
            ps.setString(5, guest.getGuestNumber());
            ps.executeQuery();

            //Conformation Message
            showMessageDialog(null, "Guest " + guest.getLastName()+ " " 
                    + guest.getFirstName() + "has been updated");
            //Close DB Connection
            gc.getConn().close();
        }
        catch(SQLException ex){
            ErrorHandling.displayException(ex);
        }
    }
    
}//end class

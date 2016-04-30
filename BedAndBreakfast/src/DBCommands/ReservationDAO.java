/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.ErrorHandling;
import classes.Guest;
import classes.Reservation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *is used to facilitate between reservation form and database
 * @author Kevin
 */
/*
status can be the following
0 - reserved
1 - check in
2 - check out
3 - cancel
4 - no show
*/
public class ReservationDAO {
    //variables
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;

    //connection
    DBConnection gc = new DBConnection();
    
    //insert reservation -> ReservationPage.book
    public void insertReservation(Reservation r) {
        //connects to database
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        //need method to get guest and room number
        try{
            //creates unique reservation number sets to current reservation
            r.setResNo(gc.uniqueID("reservations", "1"));
            //insert record
            ps=gc.getConn().prepareStatement
                ("INSERT INTO reservations VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, r.getResNo());
            ps.setString(2, r.getRoomNumber());
            ps.setString(3, r.getGuestNumber());
            ps.setString(4, r.getCheckIn());
            ps.setString(5, r.getCheckOut());
            ps.setString(6, r.getPrice());
            ps.setString(7, r.getStatus());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Created: " + r.getResNo(), "Record Added", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            //catch unique guest_no constraint and offers to create guest
            if(ex.getSQLState().startsWith("23")) {
                int dialogResults = JOptionPane.showConfirmDialog(null, "Guest not found.  Create Guest?", "Invalid Guest No", JOptionPane.YES_NO_OPTION);
                //create guest if yes
                if(dialogResults == 0) {
                    new views.GuestSearchModule().setVisible(true);
                }
            }
        }
    }//end insertReservation()
    
    //check in reservaton
    public void checkInReservation(Reservation r) {
        //connects to database
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setString(1, "1");
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Checked In", "Checked In", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end checkinReservation()
    
    //check out reservaton
    public void checkOutReservation(Reservation r) {
        //connects to database
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setString(1, "2");
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Checked Out", "Checked Out", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end checkOutReservation()
    
    //cancel reservaton
    public void cancelReservation(Reservation r) {
        //connects to database
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setString(1, "3");
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation Cancelled", "Cancel Reservation", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end cancelReservation()
    //no show reservaton
    public void noShowReservation(Reservation r) {
        //connects to database
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        try{
            ps=gc.getConn().prepareStatement
                ("UPDATE reservations SET status=? where res_no=?");
            ps.setString(1, "4");
            ps.setString(2, r.getResNo());
            ps.executeQuery();
            //user message
            showMessageDialog(null, "Reservation No Show", "No Show", JOptionPane.INFORMATION_MESSAGE);
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end noShowReservation()
    //Search reservaton
    public ArrayList<ArrayList<String>> searchReservationByResNo(ArrayList<String> searchCriteria) {
        
        ArrayList <ArrayList<String>> records = new ArrayList<>();
        
        //connects to database
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return records;
        }
        
        ArrayList <String> record = new ArrayList();
        //need method to get guest and room number
        try{
            ps=gc.getConn().prepareStatement
                ("SELECT last_name, first_name, in_date, out_date, status, rm_no " +
                    " FROM reservations r, guests g WHERE (r.guest_no= g.guest_no) " +
                    " AND (r.res_no = ?)" +
                    " OR (r.rm_no = ?)" +
                    " OR (r.in_date >= ? AND r.out_date <=?)" +
                    " OR (g.guest_no = ?)" +
                    " OR (r.status = ?)" +
                    " OR (g.first_name=?)" +
                    " OR (g.last_name=?)");
            ps.setString(1, searchCriteria.get(0));
            rs = ps.executeQuery();
            while (rs.next()){
                for (int i = 1; i <= 6; i++ ){
                record.add(rs.getString(i));
                }
                records.add(record);
                record = new ArrayList();
            }
            rs.close();
            //close connection
            gc.getConn().close();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return records;
    }//end searchReservation()
    
    
    /**
     * Author Kevin, searches reservation from database
     * @param r Reservation
     * @param g Guest
     * @return 2D String Array
     */
    public String[][] searchReservation(Reservation r, Guest g) {
       
        int totalRows = 0; //initiliazes totalRows for the try-catch
        
        //create array
        String[][] rowInfo = new String[totalRows][0]; //initializes rowInfo for the try-catch
                    
        //open db connection
        try{
            gc.getDBConnection();
        }catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return rowInfo;
        }
        
        try{
            //create search statement used in oracle
            ps = gc.getConn().prepareStatement(
                "SELECT res_no, last_name, first_name, in_date, out_date, status, rm_no " +
                " FROM reservations r, guests g WHERE (r.guest_no= g.guest_no) " +
                " AND (r.status = ?) "+ //reservation status must be set
                " AND (r.res_no = ?)" +
                " OR (r.rm_no = ?)" +
                " OR (r.in_date >= ? AND r.out_date <=?)" +
                " OR (g.guest_no = ?)" +
                " OR (g.first_name=?)" +
                " OR (g.last_name=?)"
            );//end ps
            //set values (8-?)
            ps.setString(1, r.getStatus());
//            ps.setString(1, 4);//test value
            ps.setString(2, r.getResNo());
            ps.setString(3, r.getRoomNumber());
            ps.setString(4, r.getCheckIn());
            ps.setString(5, r.getCheckOut());
            ps.setString(6, r.getGuestNumber());
//            ps.setString(6, "1001");//test item
            ps.setString(7, g.getFirstName());
            ps.setString(8, g.getLastName());
            //execute command to the database
            rs = ps.executeQuery();
            //use while to get to the last row, do this way to avoid errors
            while(rs.next()){
                totalRows = rs.getRow();
            }//end while
        } catch(SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        rowInfo = new String[totalRows][7];//rows must be calulated first
        
        //add info to array by running query again
        try{
            //create search statement used in oracle
            ps = gc.getConn().prepareStatement(
                "SELECT res_no, last_name, first_name, in_date, out_date, status, rm_no " +
                " FROM reservations r, guests g WHERE (r.guest_no= g.guest_no) " +
                " AND (r.status = ?) "+ //reservation status must be set
                " AND (r.res_no = ?)" +
                " OR (r.rm_no = ?)" +
                " OR (r.in_date >= ? AND r.out_date <=?)" +
                " OR (g.guest_no = ?)" +
                " OR (g.first_name=?)" +
                " OR (g.last_name=?)"
            );//end ps
            //set values (8-?)
            ps.setString(1, r.getStatus());
//            ps.setString(1, 4);//test value
            ps.setString(2, r.getResNo());
            ps.setString(3, r.getRoomNumber());
            ps.setString(4, r.getCheckIn());
            ps.setString(5, r.getCheckOut());
            ps.setString(6, r.getGuestNumber());
//            ps.setString(6, "1001");//test value
            ps.setString(7, g.getFirstName());
            ps.setString(8, g.getLastName());
            //execute command to the database
            rs = ps.executeQuery(); 
            //add to array
            int i = 0; //count for rows
            while(rs.next()){
                rowInfo[i][0] = rs.getString(1);
                rowInfo[i][1] = rs.getString(2);
                rowInfo[i][2] = rs.getString(3);
                rowInfo[i][3] = rs.getString(4).split(" ")[0];
                rowInfo[i][4] = rs.getString(5).split(" ")[0];
                rowInfo[i][5] = rs.getString(6);
                rowInfo[i][6] = rs.getString(7);
                i++;
            }//end while
            //close DB connection
            gc.getConn().close();
        } catch(Exception ex) {
            System.out.println(ex);
            Logger.getLogger(ReservationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }//end try
        //BEGIN TEST ITEM
//        for(int i=0; i < totalRows; i++){
//            for(int column=0; column < 7; column++){
//                System.out.print(rowInfo[i][column]+" ");
//            }
//            System.out.println();
//        }
        //END TEST ITEM
        return rowInfo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Kevin
 */
public class RoomDAO {
//    Room room = new Room();
    Room[] rooms;
    int totalRooms;
    DBConnection gc;
//    private String[] rooms;
    private ArrayList<ArrayList<String>> results;   
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public RoomDAO(){
        gc = new DBConnection();
        try {
            gc.getDBConnection();
        } catch (SQLException ex) {
            ErrorHandling.displayException(ex);
        }
        getRooms();
    }
    
    //when you hit this button it adds 1 to the weight of all checked in rooms
    //this is why it should be run at 3am when most rooms will be checked in
    public void updateUse() {
        try {
            gc.getDBConnection();
        } catch (SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        ArrayList<Room> rList = new ArrayList<>();
        //reservation status 1 means checked in
        //sql string breakdown, select all rooms from reservations and rooms where reservations are checked in
        String sql = "SELECT * FROM reservations, rooms WHERE "
                + "reservations.rm_no = rooms.rm_no AND reservations.status = 1";
        try {
            //connect DB
            stmt = gc.getConn().createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                rList.add(new Room(rs.getString(2), rs.getDouble(8)));
            }//end while-> all checked in rooms are now in the ArrayList
        
            //updates room
            ps = gc.getConn().prepareCall("UPDATE rooms SET "
                    + "use_count = use_count + 1 WHERE rm_no=?");
            for (Room rList1 : rList) {
                //insert and run ps
                ps.setString(1, rList1.getRmNO());
                System.out.print(rList1.getRmNO());
                ps.executeQuery();
            }
            gc.getConn().close();
        }catch(SQLException ex) {
            ErrorHandling.displayException(ex);
        }
    }
    
    public Room[] getRooms(){
//                conn = new DBConnection();
//        try {
//            conn.getDBConnection();
//        } catch (SQLException ex){
//            ErrorHandling.displayException(ex);
//            return;
//        }
        results = gc.getresults("select * from rooms order by rm_no");
        totalRooms = results.size();
        rooms = new Room[totalRooms];
        for (int i = 0; i < totalRooms; i++){
            rooms[i] = new Room (results.get(i).get(0), 
                    Double.parseDouble(results.get(i).get(1)),
                    Integer.parseInt(results.get(i).get(2)),results.get(i).get(3), 
                    Integer.parseInt(results.get(i).get(4)));
        }
        return rooms;
    }
    
    public void changeToDirty(Room rm){
        gc.runquery("update rooms set clean = 1 where rm_no = '"
            + rm.getRmNO() + "'");
    }
    
    public void changeToClean(Room rm){
        gc.runquery("update rooms set clean = 0 where rm_no = '"
        + rm.getRmNO() + "'");
    }
    
    public int removeRoom (Room rm){
        return gc.runquery("delete from rooms where rm_no='" +
                rm.getRmNO() +"'");
    }
    
    public int addRoom (Room rm){
        int value = gc.runquery("insert into rooms "
                + "(rm_no, hotel_id, use_count, beds, clean) VALUES "
                + "('" + rm.getRmNO() + "', '001', 0, 2, 1)");
        rooms = Arrays.copyOf(rooms, totalRooms + 1);
        rooms[totalRooms] = rm;
        return value;
    }
    public Room searchRoom(String rmNo){
        for (Room room1 : rooms) {
            if (room1.getRmNO().equals(rmNo)) {
                return room1;
            }
        }
        return null;
    }
}

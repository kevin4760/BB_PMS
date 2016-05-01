/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.ErrorHandling;
import java.util.*;
import java.sql.*;


/**
 * DBConnection.java
 * @author Kevin
 * @modification Prasanna
 * creates a DB Connection for the specific database in the String 
 * URL.  This connection string must be manually changed as of right now
 */
public class DBConnection{
    private Connection conn;
//    private Properties connectionProps;
    private String username;
    private String password;
    private String schema;
    private String server;
    private int port;
    private String URL;
    private Statement stmt;
    private ResultSet rs;
   
    
    //constructors
    public DBConnection(String username, String password, String schema, String server, int port) {
        this.username = username;
        this.password = password;
        this.schema = schema;
        this.server = server;
        this.port = port;
//        connectionProps = new Properties();
//        connectionProps.put("user", username);
//        connectionProps.put("password", password);
    }
    //constructor to call kevins db connection
    //constructors
    public DBConnection() {
        this.username = "bbpms";
        this.password = "bbpms";
        this.schema = "orcl";
        this.server = "bbpms.ddns.net";
        this.port = 1521;
    }
    public DBConnection(int x){
        if(x == 5) {
            this.username = "system";
            this.password = "ANK22dec2010!!";
            this.schema = "xe";
            this.server = "localhost";
            this.port = 1521;
        }
        //you can add an if interger statement for yours
    }
    //end constructors
    
    public void closeConnection(){
        try{
            stmt.close();
            rs.close();
            conn.close();
        }catch (SQLException ex){
            ErrorHandling.displayException(ex);
        }
    }
    //getters
    public Connection getConn() {
        return this.conn;
    }
    
    public ResultSet getRS() {
        return this.rs;
    }
    
    public Statement getStmt() {
        return this.stmt;
    }
    //end getters
    
    //setters
    public void setRS(ResultSet rs) {
        this.rs = rs;
    }
    
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
    //end setters
    
    
    //method getDBConnection(), 
    public void getDBConnection() throws SQLException{
        //this string is broke into these "jdbc:oracle:thin:username:passowrd@location:port:databasename
        //jdbc:oracle:thin:@server:port:schema        
        URL = "jdbc:oracle:thin:" + "@" + server + ":" + port +
                ":" + schema;
        
        try {
            this.conn = DriverManager.getConnection(URL, username, password);           
        } 
        catch(SQLException ex) {
            ErrorHandling.displayException(ex);
         
        }     
    }

    //method returns one value from database
    public int getRoomStatus(String query) {
        int roomStatus = 3; //3 will be invalid input
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.next();
            roomStatus = Integer.parseInt(rs.getString(1));
        } catch(SQLException ex) {
            ErrorHandling.displayException(ex);
        }
        return roomStatus;
    }
    
    //method getResults(), Prasana returning DB info to ArrayList
    public ArrayList <String> getresults(String query, int column_size){
        ArrayList<String> records = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                for (int i = 1; i <= column_size; i++){
                    records.add(rs.getString(i));
                }                
            }
            rs.close();
            stmt.close();
           
        } catch (SQLException ex) {
            ErrorHandling.displayException(ex);
        }
        return records;
    }//getResults()
    
    public ArrayList <ArrayList<String>> getresults(String query){
        ArrayList <ArrayList<String>> records = new ArrayList<>();
        ArrayList <String>record = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int column_size = rsmd.getColumnCount();

            while (rs.next()){
                for (int i = 1; i <= column_size; i++){
                    record.add(rs.getString(i));
                }
                records.add(record);
                record = new ArrayList<>();
            }
            rs.close();
            stmt.close();            
        } catch (SQLException ex) {
            ErrorHandling.displayException(ex);
        } 
        return records;
    }//getResults()
    
    public int runquery(String query){
        try {
            stmt = conn.createStatement();
            if (stmt.execute(query) == true){
                rs = stmt.getResultSet();
            } else {
                return stmt.getUpdateCount();
            }   
            rs.close();
            stmt.close();            
        } catch (SQLException ex){
            return -1;
        }
        return -1;
    }
    
    /**
     * Creates a uniqueID used for DB id creation
     * @param table the DB Table that you will insert 
     * @param column Must be the ID column usually "1"
     * @return
     * @throws SQLException 
     */
    public String uniqueID(String table, String column) throws SQLException{
        Random random = new Random();
        Integer newID = random.nextInt(10000000);
        
        String sql = "SELECT "+ column +" FROM "+ table +" WHERE "+ column +" = '"+ newID.toString() +"'";
        try {
            //if rs!=new id; return newID;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                uniqueID(table, column);
            } 
        } catch(SQLException ex) {
            ErrorHandling.displayException(ex);
        }
        return newID.toString();
    }//end uniqueID
    
}

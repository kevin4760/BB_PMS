/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCommands;

import classes.Employee;
import classes.ErrorHandling;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Kevin
 */
public class EmployeeDAO {
    
    //variables
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    
    //connection
    DBConnection gc = new DBConnection();
    
    /**
     * 
     * @param firstName
     * @param lastName
     * @param employeeID
     * @param userName
     * @param password
     * @return 
     */

    //insert employee
    /**
     * Inserts new employee into database
     * @param employee 
     */
    public void insertEmployee(Employee employee) {
        try {
            gc.getDBConnection();
        } catch (SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        try {
            ps = gc.getConn().prepareStatement
                ("INSERT INTO employees VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, employee.getEmployeeID());
            ps.setString(2, employee.getHotelID());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getFirstName());
            ps.setString(5, employee.getUserName());
            ps.setString(6, employee.getPassword());
            ps.executeQuery();
            
            showMessageDialog(null, "Employee added: "+employee.getLastName()+
                    ", "+employee.getFirstName(),"Record Added", 
                    JOptionPane.INFORMATION_MESSAGE);
            gc.getConn().close();            
        } 
        catch(SQLException ex) {
            ErrorHandling.displayException(ex,"Unable to Add Employee");
        }
    }
   
    //search function -> used to add list to jlist
    /**
     * 
     * @param firstName
     * @param lastName
     * @param employeeID
     * @param userName
     * @param hotelID
     * @return arraylist of Employees
     */
    public ArrayList<Employee> searchEmp(String firstName, String lastName, 
            String employeeID, String userName, String hotelID) {
        
        //create the arraylist
        ArrayList<Employee> empList = new ArrayList<>();
        
        //connect to db
        try {
            gc.getDBConnection();
        } 
        catch (SQLException ex){
            ErrorHandling.displayException(ex);
            return empList;
        }
        
        //search string that uses all possible fields other than password
        String sql = "SELECT * FROM EMPLOYEES WHERE (emp_id = '"+ employeeID +"') OR "
                + "(last_name = '" + lastName + "' AND first_name = '"+ firstName+"') OR "
                + "(user_name ='"+userName+"') OR "
                + "(hotel_id ='"+hotelID+"')";
        
        //get info from DB
        try {
            stmt = gc.getConn().createStatement();
            rs = stmt.executeQuery(sql);
            
            //begin while
            while(rs.next()) {
                //adds a new employee to the ArrayList empList
                empList.add(new Employee(rs.getString(4),rs.getString(3),
                        rs.getString(1),rs.getString(5),rs.getString(6)));
            }//end while
            
        } 
        catch(SQLException ex) {
            //System.out.println("whoops"); //replace with a real exception
            ErrorHandling.displayException(ex);
        }
        
        //Returns the List of Employees
        return empList;
    }
    
    //Update Employee
    public void updateEmployee (Employee employee) {
        //Get db Connection
        try {
            gc.getDBConnection();
        }
        catch (SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        //Update Employee Info
        try {
            ps = gc.getConn().prepareStatement("UPDATE employees SET hotel_id=?, "
                    + "last_name=?, first_name=?, user_name=?, "
                    + "password=? WHERE emp_id=?" );
            ps.setString(1, employee.getHotelID());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getFirstName());
            ps.setString(4, employee.getUserName());
            ps.setString(5, employee.getPassword());
            ps.setString(6, employee.getEmployeeID());

            ps.executeQuery();
            gc.getConn().close();
            showMessageDialog(null, "Employee Updated: "+employee.getLastName()+", "+employee.getFirstName(),"Record Update", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException ex) {
            ErrorHandling.displayException(ex);
        }
    }//end updateEmployee()
    
    //delete employee
    public void deleteEmployee(String empID) {
        //Get db Connection
        try{
            gc.getDBConnection();
        } 
        catch (SQLException ex){
            ErrorHandling.displayException(ex);
            return;
        }
        
        //Delete Employee
        try{
            ps = gc.getConn().prepareStatement("DELETE FROM employees WHERE emp_id=?" );
            ps.setString(1, empID);
            ps.executeQuery();
            gc.getConn().close();
            showMessageDialog(null, "Employee Record Deleted: "+ empID, "Record Deleted", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException ex){
            ErrorHandling.displayException(ex); 
        }
    }
    
    //vaidate user for login   
    //method validateUser()
    public Boolean validateUser(Employee emp) {
        //Get db Connection
        try {
            gc.getDBConnection();
        } 
        catch(SQLException ex){
            ErrorHandling.displayException(ex);
            return false;
        }
        String user = emp.getUserName();
        String pass = emp.getPassword();
        Boolean access = false;
        
        //Validate the Users Password and User Name
        try {
            String sql = "SELECT * FROM employees WHERE user_name='" + user + 
                "' and password='" + pass +"'";
            stmt = gc.getConn().createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                emp.setEmployeeID(rs.getString(1));
                emp.setHotelID(rs.getString(2));
                emp.setLastName(rs.getString(3));
                emp.setFirstName(rs.getString(4));
                emp.setUserName(rs.getString(5));
                emp.setPassword(rs.getString(6));
                access = true;
            } 
            else{ 
                access = false;
            }
            gc.getConn().close();
        } 
        catch(SQLException ex) {
            ErrorHandling.displayException(ex);
        }
        return access;        
    }
}

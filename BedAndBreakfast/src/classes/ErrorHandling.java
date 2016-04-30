/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * ErrorHandling.java
 * @author Greg
 * class that SQL exceptions, other exceptions, and other errors
 * and handles it gracefully spitting out an appropriate error message
 */
public class ErrorHandling extends Exception{
    
    //constructor
    public ErrorHandling(){
        
    }
    
    //WORK IN PROGRESS- method that takes the SQL exception being thrown and gives an error for it.
    public static void displayException(SQLException ex, String messageString){        
        showMessageDialog(null, messageString, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    //WORK IN PROGRESS- method that takes the SQL exception being thrown and just gives the generic SQL exception message for it.
    public static void displayException(SQLException ex){
        switch (ex.getErrorCode()){
            case 00001:
                showMessageDialog(null, "Duplicate entry", "Duplicate", JOptionPane.ERROR_MESSAGE);
                break;
            case 12154:
                showMessageDialog(null, "Could not the find the server or network issues", "Server not found", JOptionPane.ERROR_MESSAGE);
                break;
            case 00600:
                showMessageDialog(null, "Something is really bad with your server", "Database issues", JOptionPane.ERROR_MESSAGE);
                break;
            case 01722:
                showMessageDialog(null, "Are you sure you are sober", "User error", JOptionPane.ERROR_MESSAGE);
                break;
            case 03113:
                showMessageDialog(null, "Somebody forgot pay their bills and connection died", "Disconnected", JOptionPane.ERROR_MESSAGE);
                break;
            case 01000:
                showMessageDialog(null, "Max number of connections/workers reached", "You are working too hard", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);                
        }
                
    }
    
    //WORK IN PROGRESS- method that takes the exception being thrown and gives an error for it.
    public static void displayException(Exception ex, String messageString){        
        showMessageDialog(null, messageString, "Error", JOptionPane.ERROR_MESSAGE);        
    }
    
    //WORK IN PROGRESS- method that takes the exception being thrown and just gives the generic exception message for it.
    public static void displayException(Exception ex){
        showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       
    }
}

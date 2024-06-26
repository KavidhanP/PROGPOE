
import poe.Login;
import javax.swing.JOptionPane;
import poe.Task;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class Register {
    
    public static void main(String[] args){
        
     
     Task w = new Task();
      w.AddTask();             
      
    
    
     
     String username = "";
     String password = "";
    
     Login lObj = new Login();
    
    lObj.checkUserName(username);
    lObj.checkPasswordComplexity(password);
    lObj.RegisterUser();
    lObj.userDetails();
    lObj.returnLoginStatus(lObj.getName(),lObj.getSurname());
   
    
    
    
    }
    
    
    
}


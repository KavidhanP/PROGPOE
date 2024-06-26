/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poe;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class LoginTest {
        
        
   @Test   
       public void TestingUsernametrue(){
   Login login = new Login();
   assertEquals(true,(login.checkUserName("Kyl_1")));
 
   }
       
   @Test   
       public void TestingUsernameatrue(){
   Login login = new Login();
   assertTrue(login.checkUserName("Kyl_1"));
 
   }

       
       
    @Test   
        public void TestingUsernameFalse(){
   Login login = new Login();
   assertEquals(false,(login.checkUserName("kyle!!!!!!!")));
 
   }
        
    @Test   
       public void TestingUsernameafalse(){
   Login login = new Login();
   assertFalse(login.checkUserName("kyle!!!!!!!"));
 
   }
        
   @Test   
        public void TestingPasswordtrue(){
   Login login = new Login();
   assertEquals(true,(login.checkPasswordComplexity("Ch&&sec@ke99!")));
   
        }
        
        
     @Test   
        public void TestingPasswordatrue(){
   Login login = new Login();
   assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
   
        }
   
   
     @Test   
     public void TestingPasswordFalse(){
   Login login = new Login();
   assertEquals(false,(login.checkPasswordComplexity("password")));
 
     }
   
    @Test   
     public void TestingPasswordaFalse(){
   Login login = new Login();
   assertFalse(login.checkPasswordComplexity("password"));
 
     }
   
     
     @Test
     public void TestLoginTrue(){
     Login login = new Login();
     String username1 = "Kyl_1";
     String password1 = "Ch&&sec@ke99!";
     
     login.username = username1;
     login.password = password1;
     
     boolean loginResult = login.loginUser(username1, password1);
     
     assertTrue(loginResult);
     }
     
     
     
     @Test
     public void TestLoginFalse(){
     Login login = new Login();
     String username1 = "Kyl_1";
     String password1 = "Ch&&sec@ke99!";
     
     login.username = username1;
     login.password = password1;
     
     String username2 = "Kyle!!!!!!!";
     String password2 = "password";
     
     boolean loginResult = login.loginUser(username2, password2);
     
     assertFalse(loginResult);
     }
 
   

    }
    


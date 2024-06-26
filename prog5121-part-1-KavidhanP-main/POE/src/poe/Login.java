
package poe;

import javax.swing.JOptionPane;

/**
 *
 * @author Kavidhan Kanada Pakkiri
 * st10444513
 */
public class Login {

    String username;
    String password;
    String name;
    String surname;
    String InputUsername;
    String InputPassword;
    
    
    public Login()
    {
    }
   // requirements for username
    public boolean checkUserName(String user)
    {
        if((user.length()<= 5) && (user.contains("_")))
        {
         return true;
        }
        else 
        {
                return false;
        }
    }
        
        //requirements  for passowrd
        public boolean checkPasswordComplexity(String pass)
          {
           boolean check =false;
           
           //regex to ensure complexity
           String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$"; //AI tools(chat gpt) were used to create this regax
                   if(pass.length() >= 8 && pass.matches(regex))
                   {
                    check = true;
                   }
                   return check;
          }
        //input users name and surname 
        public void userDetails()
        {
          name = JOptionPane.showInputDialog("Please enter your first name: ");
          surname = JOptionPane.showInputDialog("Please enter your surname: ");
          returnLoginStatus(name, surname);
        }
        
        //user enters their username 
        public void RegisterUser()
        {
        while(true)
        {
        username = JOptionPane.showInputDialog("Please enter your username: ");
        if(!(checkUserName(username)))
        { //checking username
         JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that the username entered: has an underscore and is no more than 5 characters in length");
        }
        else{
        JOptionPane.showMessageDialog(null, "Username successfully captured");
        break;
        }
        }
        // 
        while (true)
        {//entering passwordand saving password
            password = JOptionPane.showInputDialog("Please eneter password: ");
            if(!(checkPasswordComplexity(password)))
            {
             JOptionPane.showMessageDialog(null, "Password is not in the correct format, please ensure your password has a special character, capital letter and is longer than 7 characters");
            }
            else{
            JOptionPane.showMessageDialog(null, "Password has been captured");
            break;
            }
           
            
        }
        
       
        }
        
        //check if username and individual's name is registered for login
        public boolean loginUser(String inputUserName, String inputPassword)
        {
         boolean check = false;
         if(username.equals(InputUsername) && password.equals(InputPassword))
         {
           check = true;
         }
           return check;  
        }
        
        //comparing previous data to ensure authentication
        public void returnLoginStatus(String name, String surname)
        {
         
           
         while(true)
         {
          int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Login for the application?", "Thank you: ", JOptionPane.YES_NO_OPTION);
          if(confirm == JOptionPane.YES_OPTION)
          {
           
                 InputUsername = JOptionPane.showInputDialog("Please enter your username ");
                 InputPassword = JOptionPane.showInputDialog("Please enter your password ");
              
               if(loginUser(username , password))
               {
                    //succesful login
                   JOptionPane.showMessageDialog(null, "Thank you for logging in " + name + " " + surname);
                   JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan ");
                   
     Task w = new Task();
                   w.AddTask();
                   
                   
                  

               }
               else {
                   
                    JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
               }
           //leaving the login screen
          }
          else if(confirm == JOptionPane.CANCEL_OPTION)
          {
           System.exit(0);
          }
          else if(confirm == JOptionPane.NO_OPTION)
          {
           System.exit(0);
          }
         }
        }
        
        //get method for name
        public String getName()
        {
         return name;
        }
        
        //get method for surname
        public String getSurname()
        {
         return surname;
        }
    }


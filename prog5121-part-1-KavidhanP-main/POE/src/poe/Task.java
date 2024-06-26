
package poe;

import javax.swing.JOptionPane;

/**
 *
 * @author kanda
 */
public class Task {
    public int max = 4;
    public int sum = 0;
    public String[] TaskName = new String[max];
    public int[] TaskDuration = new int [max];
     public int TaskNumber;
    private String[] TaskDescription  = new String[max];
    public String[] DeveloperDetails = new String[max];
    public String[] TaskID = new String[max];
    public String[] TaskStatus = new String[max];
    public int con; // short for confirm
    public int statuscon;
    public int NumberTask; // counting how many tasks have been added
    public int TaskNumbersum;
     public int TaskNumbersum1;
    public int confirmmenu;
    public String con2;
   public int x;
    public int y;
    
    
    public void populatearrays (){
    DeveloperDetails[0] = "Mike Smith";
    DeveloperDetails[1] = "Edward Harrison";
    DeveloperDetails[2] = "Samantha Paulson";
    DeveloperDetails[3] = "Glenda Oberholzer";
    
    
    TaskDuration[0] = 5;
    TaskDuration[1] = 8;
    TaskDuration[2] = 2;
    TaskDuration[3] = 11;
    
    
    TaskName[0] = "Create Login";
    TaskName[1] = "Create Add features";
    TaskName[2] = "Create Reports";
    TaskName[3] = "Add Arrays"; 
    
    
    TaskStatus[0] = "To Do";
    TaskStatus[1] = "Doing";
    TaskStatus[2] = "Done";
    TaskStatus[3] = "To Do";
    
    
    
    
    
    }
    
    public boolean CheckDescription(String Descrip){
    if(Descrip.length()<50){
        TaskDescription[TaskNumber] = Descrip;
    return true;
    }
    else{
    return false;
    }

    }
    
    
    public void AddTask(){
     populatearrays ();
    //when not equal to quit
    while(!( con == 3))
    {
    con = Integer.parseInt(JOptionPane.showInputDialog(null, "Please choose between the 3 options\n 1. Add Tasks\n 2.Show Report\n 3. Quit"));
     
    
    //Giving Task Number a value
    if(con == 1){
     NumberTask = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the number of Tasks"));
     
     TaskNumber = 0;
     //when the Task Number value given is valid
     while(NumberTask > 0){ 
         
         TaskName[TaskNumber] = JOptionPane.showInputDialog(null, "Enter the name of task");
         
      //Setting a condition for task description 
      //Making the loop for as many times as the user enters for number of tasks
     for(; TaskNumber < NumberTask; ) {
         
     TaskDescription[TaskNumber] = JOptionPane.showInputDialog(null, "Please Give the task a description");
        if(CheckDescription(TaskDescription[TaskNumber])){
            JOptionPane.showMessageDialog(null, "Task Description captured");
         
           }
        
        else if(!(CheckDescription(TaskDescription[TaskNumber]))){
            JOptionPane.showMessageDialog(null, "Please enter a Description less than 50 chracters");
           continue;
           }
        
        
     //Inputting values for Developer Details & Task Duration
     
     TaskDuration[TaskNumber] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the duration of the task(Hours)"));
     
     
     DeveloperDetails[TaskNumber] = JOptionPane.showInputDialog(null, "Enter the name and surname of the developer");
     break;
        
     }
     
     
     //Calling Task ID method
     CreateTaskID(TaskID[TaskNumber]);
     
     
     
     JOptionPane.showMessageDialog(null, "Task sucessfully captured");
     
     
   

     //Calling Task Status method
     Status(TaskStatus[TaskNumber]);
     
     TaskNumberSum(TaskNumbersum);
     
     DisplayTask();
    
     returnTotalHours();
     
     TaskNumber++;// Incrementing TaskNumber
     
     
     
     // The loop has repeated for all tasks
     if(TaskNumber == NumberTask){
         y = NumberTask;
         NumberTask = 0;
     break;
     }
     
     
     }
      
     JOptionPane.showMessageDialog(null, "Total Hours of All Tasks: " + sum); //displays total hours
     
    }
    
     
   
     
     
     if(con == 2){
      
       showreport();
     }
     
    }
    if(con == 3){
    System.exit(0);
    }
    
                  
    }
    
    public void showreport(){
        TaskNumbersum1 = 0;
        confirmmenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Please choose between the 5 options\n 1. Display developer with status done\n 2. Display longest duration\n 3. Search for Task by developer\n 4. Search for Task by name\n 5. Delete Task\n 6. Show all tasks\n 7. Back"));
       while(confirmmenu != 7){
           
           
           
           
           if(confirmmenu == 1){
               y = 0;
           while (y < (TaskStatus.length - 1)){
               if("Done".equals(TaskStatus[y])){
            JOptionPane.showMessageDialog(null, "Status : " + TaskStatus[y] + "\nDeveloper Name: " + DeveloperDetails[y] + "\nTask Name : " + TaskName[y] + "\nTask Duration: " + TaskDuration[y]  );
            break;
               }
               else{
               y++;
               }
               }
           break;
           }
           
           
           
           if(confirmmenu == 2){
               int largest = 3;
           while(y < TaskStatus.length - 1){
             
            if(TaskDuration[y] < TaskDuration[y+1]){
                largest = (y + 1);
               y++;
            
            }
            else{
                  largest = y ;
                 y++;
            }
          
           }
             JOptionPane.showMessageDialog(null,  "\nDeveloper Name: " + DeveloperDetails[largest] + "\nTask Duration: " + TaskDuration[largest]  );
           
           break;
           
           
           }
           
          if(confirmmenu == 3){
              TaskNumber = 0;
              con2 = JOptionPane.showInputDialog(null, "Please enter the Developer of the Task ");
                  y = 0;
                    boolean found = false;
                    while ( y < DeveloperDetails.length) {
                        if (DeveloperDetails[y].equalsIgnoreCase(con2)) {//Checks for a match
                         
                           JOptionPane.showMessageDialog(null, "Status : " + TaskStatus[y] + "\nDeveloper Name: " + DeveloperDetails[y] + "\nTask Name : " + TaskName[y] + "\nTask Duration: " + TaskDuration[y]  );
                            found = true;
                            break;
                        }
                        else{
                         y++; 
                         continue;
                        }
                        
               
                      
                    }
                    
                    
    
                    
                    break;
                   
                    
            
              
       
       
             }
          
          
          
          
          
          
          if(confirmmenu == 4){

              TaskNumber = 0;
              con2 = JOptionPane.showInputDialog(null, "Please enter the name of the Task ");
                      boolean found = false;
                    for (y = 0; y < TaskName.length;) {
                        if (TaskName[y].equalsIgnoreCase(con2)) {//Checks for a match
                         
                           JOptionPane.showMessageDialog(null, "Status : " + TaskStatus[y] + "\nDeveloper Name: " + DeveloperDetails[y] + "\nTask Name : " + TaskName[y] + "\nTask Duration: " + TaskDuration[y]  );
                            found = true;
                            break;
                        }
                       
                        else if (!TaskName[y].equalsIgnoreCase(con2)){
                         y++;
                         continue;
                        }
                        
                       
                 
                        
                    }
                    break;
                   
                    
 
          
       
       
             
          
          }
          
         
         if(confirmmenu == 5){
          String deleteTask = JOptionPane.showInputDialog(null, "Please enter the name of the task you want to delete");
    int indexToDelete = -1;
    for (y = 0; y < 5;) { // You should loop through the array entirely
        if (TaskName[y].equalsIgnoreCase(deleteTask)) {
            indexToDelete = y;
            break;
        }
        
        else{
        y++;
        }
    }
    if (indexToDelete != -1) { // Check if a task was found for deletion
        JOptionPane.showMessageDialog(null, "The Task " + deleteTask + " has been deleted");
        // Remove elements from all arrays
        TaskName = removeElement(TaskName, indexToDelete);
        TaskStatus = removeElement(TaskStatus, indexToDelete);
        DeveloperDetails = removeElement(DeveloperDetails, indexToDelete);
        break;
        // Display updated task list or any other necessary actions
             }
            else {
        JOptionPane.showMessageDialog(null, "Task not found");
                 }
    // You need to handle the loop control here
    // Here, the code will exit the loop after performing the deletion or showing the "Task not found" message.
    break;
          
         }
       
         
         
         if(confirmmenu == 6){
          for(y = 0; y < TaskName.length;){
             JOptionPane.showMessageDialog(null, "Status : " + TaskStatus[y] + "\nDeveloper Name: " + DeveloperDetails[y] + "\nTask Name : " + TaskName[y] + "\nTask Duration: " + TaskDuration[y]  );
          y++;
          
          }
         break;
         
         }
       
       
       }
    }
    
    public static String[] removeElement(String[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return array;
        }
        String[] newArray = new String[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = array[i];
        }
        return newArray;
    }

    // Method to remove an element from an int array
    public static int[] removeElement(int[] array, int index) {
        if (array == null || index < 0 || index >= array.length) {
            return array;
        }
        int[] newArray = new int[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = array[i];
        }
        return newArray;
    }
    
        
    
    
    public void Status(String TaskStat){
        //Different options for taskstatus
        
        statuscon = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the status of the task: \n1. To Do\n2. Done\n3. Doing"));//status confirm
       
    while(true){
        switch (statuscon) {
            case 1:
                TaskStatus[TaskNumber] = "To Do";
                break;
            case 2:
                TaskStatus[TaskNumber] = "Done";
                break;
            case 3:
                TaskStatus[TaskNumber] = "Doing";
                break;
            default:
                JOptionPane.showMessageDialog(null,"Value is not correct please enter another value");
                statuscon = Integer.parseInt(JOptionPane.showInputDialog(null,  "Please enter the status of the task: \n1. To Do\n2. Done\n3. Doing"));
                continue;
        }
        break;
        
       }
    }
    
    public String CreateTaskID(String TaskID){
    while(true){
    String out;
    if(DeveloperDetails[TaskNumber].contains(" ")&& DeveloperDetails[TaskNumber].length()>3){ //setting a condition for taskid
    int space = DeveloperDetails[TaskNumber].indexOf(" ");
    String devID = DeveloperDetails[TaskNumber].substring(space-3,space);
    out = TaskName[TaskNumber].substring(0, 2).toUpperCase() + ":" + TaskNumber + ":" + devID.toUpperCase();
    this.TaskID[TaskNumber] = out;
    return out;
    
   
    }
    else
    {
     JOptionPane.showMessageDialog(null, "Developer name does not include a space and is less than 3 characters");//ensures the needed information for the task id
     DeveloperDetails[TaskNumber] = JOptionPane.showInputDialog("Please enter developer's name and surname");
     continue;
    }
    
    }
   
    }
    
    public int returnTotalHours(){

      
        sum = sum + TaskDuration[TaskNumber];
    
    
     return sum;
    }
    
    public int TaskNumberSum(int tsum)//creating sum for tasknumber 
    {
    tsum = TaskNumber;
        TaskNumbersum = TaskNumber + 1;
        return TaskNumbersum;
    
    }
    
    public int TaskNumberS(int tsu)//creating sum for tasknumber 
    {
    tsu = TaskNumber;
        TaskNumbersum1 = TaskNumber - 1;
        return TaskNumbersum1;
    
    }
    
    
    public void DisplayTask()
    {
      JOptionPane.showMessageDialog(null, "Status : " + TaskStatus[TaskNumber] + "\nDeveloper Name: " + DeveloperDetails[TaskNumber] +  "\nTask Number: " + TaskNumbersum + "\nTask Name : " + TaskName[TaskNumber] + "\nTask Description: " + TaskDescription[TaskNumber] + "\nTaskID: " + TaskID[TaskNumber] + "\nTask Duration: " + TaskDuration[TaskNumber]  );
     
    }

    
    
    
   
    
}



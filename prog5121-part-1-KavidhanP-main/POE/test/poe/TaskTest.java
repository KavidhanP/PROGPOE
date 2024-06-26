/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;

import javax.swing.JOptionPane;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kanda
 */
public class TaskTest {
 private Task task;

        @Before
    public void setUp() {
        task = new Task();
        task.populatearrays();
    }


    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        Assert.assertArrayEquals(expectedDevelopers, task.DeveloperDetails);
    }

    @Test
    public void testDisplayDeveloperAndDurationForLongestTask() {
        String expectedDeveloper = "Glenda Oberholzer";
        int expectedDuration = 11;
        int maxDurationIndex = 0;
        for (int i = 1; i < task.TaskDuration.length; i++) {
            if (task.TaskDuration[i] > task.TaskDuration[maxDurationIndex]) {
                maxDurationIndex = i;
            }
        }
        assertEquals(expectedDeveloper, task.DeveloperDetails[maxDurationIndex]);
        assertEquals(expectedDuration, task.TaskDuration[maxDurationIndex]);
    }

    @Test
    public void testSearchForTasks() {
        String taskNameToSearch = "Create Login";
        int taskIndex = -1;
        for (int i = 0; i < task.TaskName.length; i++) {
            if (task.TaskName[i].equals(taskNameToSearch)) {
                taskIndex = i;
                break;
            }
        }
        assertNotEquals(-1, taskIndex);
        assertEquals("Mike Smith", task.DeveloperDetails[taskIndex]);
    }

    @Test
    public void testSearchAllTasksAssignedToDeveloper() {
        String developerToSearch = "Samantha Paulson";
        int taskIndex = -1;
        for (int i = 0; i < task.DeveloperDetails.length; i++) {
            if (task.DeveloperDetails[i].equals(developerToSearch)) {
                taskIndex = i;
                break;
            }
        }
        assertNotEquals(-1, taskIndex);
        assertEquals("Create Reports", task.TaskName[taskIndex]);
    }

    @Test
    public void testDeleteTaskFromArray() {
        String taskToDelete = "Create Reports";
        int taskIndex = -1;
        for (int i = 0; i < task.TaskName.length; i++) {
            if (task.TaskName[i].equals(taskToDelete)) {
                taskIndex = i;
                break;
            }
        }
        assertNotEquals(-1, taskIndex);
        
        // Perform deletion
        task.TaskName = Task.removeElement(task.TaskName, taskIndex);
        task.TaskStatus = Task.removeElement(task.TaskStatus, taskIndex);
        task.DeveloperDetails = Task.removeElement(task.DeveloperDetails, taskIndex);

        // Verify deletion
        for (String taskName : task.TaskName) {
            assertNotEquals(taskToDelete, taskName);
            JOptionPane.showMessageDialog(null, " Entry 'Create Reports' successfully deleted ");
            break;
        }
    }

}
    
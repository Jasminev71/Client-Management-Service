package org.snhu.cs320.task;

import org.junit.jupiter.api.Test;
import org.snhu.cs320.task.Task;
import org.snhu.cs320.task.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class TaskServiceTest {
	 @Test
	    void addTask_enforcesUniqueId_andStoresTask() {
	        TaskService svc = new TaskService();
	        Task t1 = new Task("ID1", "Name", "Desc");
	        svc.addTask(t1);
	        assertEquals(1, svc.getTaskCount());

	        // duplicate ID should fail
	        Task t2 = new Task("ID1", "Other", "Other desc");
	        assertThrows(IllegalArgumentException.class, () -> svc.addTask(t2));
	    }

	    @Test
	    void deleteTask_removesById_andThrowsIfMissing() {
	        TaskService svc = new TaskService();
	        svc.addTask(new Task("ID1", "Name", "Desc"));
	        svc.deleteTask("ID1");
	        assertEquals(0, svc.getTaskCount());

	        // deleting non-existent id
	        assertThrows(NoSuchElementException.class, () -> svc.deleteTask("ID1"));
	    }

	    @Test
	    void updateTaskName_and_updateTaskDescription_byId() {
	        TaskService svc = new TaskService();
	        svc.addTask(new Task("ID1", "Name", "Desc"));

	        // happy path updates
	        svc.updateTaskName("ID1", "New Name");
	        svc.updateTaskDescription("ID1", "New Description");

	        // grab task via a private map isn’t exposed, so just call updates again to ensure no exceptions
	        // also verify Task validation triggers on bad inputs
	        assertThrows(IllegalArgumentException.class, () -> svc.updateTaskName("ID1", ""/* invalid */));
	        assertThrows(IllegalArgumentException.class, () -> svc.updateTaskDescription("ID1",
	                "123456789012345678901234567890123456789012345678901" /* 51 chars */));

	        // updating a missing id should throw
	        assertThrows(NoSuchElementException.class, () -> svc.updateTaskName("MISSING", "X"));
	        assertThrows(NoSuchElementException.class, () -> svc.updateTaskDescription("MISSING", "X"));
	    }
	}



package org.snhu.cs320.task;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.snhu.cs320.task.Task;

public class TaskTest {

    @Test
    void constructorValidation() {
        // too long
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Task("1234567890A", "Name", "Desc")); // id > 10
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Task("1234567890", "ThisNameIsWayTooLongToBeValid", "Desc")); // name > 20
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Task("1234567890", "Name",
                        "This description is far too long to be valid because it exceeds fifty characters.")); // desc > 50

        // valid
        Task t = new Task("1234567890", "Name", "Desc");
        assertTrue(t.getTaskId().equals("1234567890"));
        assertTrue(t.getTaskName().equals("Name"));
        assertTrue(t.getTaskDescription().equals("Desc"));
    }

    @Test
    void setterValidation() {
        Task t = new Task("1234567890", "Name", "Desc");
        // invalid
        Assertions.assertThrows(IllegalArgumentException.class, () -> t.setTaskName(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> t.setTaskName("ThisNameIsWayTooLongToBeValid"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> t.setTaskDescription(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> t.setTaskDescription(
                "This description is far too long to be valid because it exceeds fifty characters."));
        // valid
        t.setTaskName("New Name");
        t.setTaskDescription("New Description");
        assertTrue(t.getTaskName().equals("New Name"));
        assertTrue(t.getTaskDescription().equals("New Description"));
    }
}

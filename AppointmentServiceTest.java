package org.snhu.cs320.appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

    private Date future() {
        return new Date(System.currentTimeMillis() + 600_000L); // +10 minutes
    }

    @Test
    void testAndDelete() {
        AppointmentService svc = new AppointmentService();
        Appointment a1 = new Appointment("ID1", future(), "Dentist");
        Appointment a2 = new Appointment("ID2", future(), "Haircut");

        // 1. CONFIRM ADDITION
        svc.addAppointment(a1);
        svc.addAppointment(a2);

        // Uses convenience methods in your AppointmentService.java
        assertEquals(2, svc.size()); 
        assertNotNull(svc.getAppointment("ID1"));

        // 2. CONFIRM DELETION
        svc.deleteAppointment("ID1");
        
        assertEquals(1, svc.size());
        assertNull(svc.getAppointment("ID1"));
    }

}
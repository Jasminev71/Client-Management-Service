package org.snhu.cs320.contact;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactService {

    private static ContactService INSTANCE;

    private final Map<String, Contact> database = new ConcurrentHashMap<>();

    public void clearAll() {
    database.clear();
}

    private ContactService() {}

    public static synchronized ContactService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ContactService();
        }
        return INSTANCE;
    }

    // Add
    public boolean add(Contact contact) {
        if (contact == null) return false;
        String id = contact.getContactId(); 
        if (id == null) return false;
        return database.putIfAbsent(id, contact) == null;
    }

    // Delete
    public boolean delete(String contactId) {
        if (contactId == null) return false;
        return database.remove(contactId) != null;
    }

    // Update
    public boolean update(String contactId, String firstName, String lastName,
                          String number, String address) throws Exception {
        Contact c = database.get(contactId);
        if (c == null) return false;

        if (firstName != null) c.setFirstName(firstName);
        if (lastName  != null) c.setLastName(lastName);
        if (number    != null) c.setPhone(number);  
        if (address   != null) c.setAddress(address);

        return true;
    }
}

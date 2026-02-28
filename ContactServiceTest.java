package org.snhu.cs320.contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ContactServiceTest {
    private ContactService svc;

    @BeforeEach
    void setup() {
        svc = ContactService.getInstance();
        svc.clearAll();
    }

    @Test
    void testAddUniqueAndDuplicate() throws Exception {
        ContactService svc = ContactService.getInstance();

        Contact c1 = new Contact("1", "first", "last", "1234455677", "123 Lehi Lane");

        // first add succeeds
        assertThat(svc.add(c1)).isTrue();

        // duplicate ID is rejected
        Contact dup = new Contact("1", "other", "name", "1234455677", "124 Lehi Lane");
        assertThat(svc.add(dup)).isFalse();
        
    }

    @Test
    void testDeleteById() throws Exception {
        ContactService svc = ContactService.getInstance();

        Contact c = new Contact("2", "Jane", "Smith", "0987654321", "222 Lehi Lane");
        svc.add(c);

        assertThat(svc.delete("2")).isTrue();   
        assertThat(svc.delete("2")).isFalse(); 
        
    }

    @Test
    void testUpdateFields() throws Exception {
        ContactService svc = ContactService.getInstance();

        Contact c = new Contact("3", "Bob", "Ray", "1112223333", "333 Lehi Lane");
        svc.add(c);
        

        boolean updated = svc.update("3",
                "Bobby",          // firstName
                "Raymond",        // lastName
                "4445556666",     // phone
                "334 Lehi Lane"   // address
        );

        assertThat(updated).isTrue();
        assertThat(c.getFirstName()).isEqualTo("Bobby");
        assertThat(c.getLastName()).isEqualTo("Raymond");
        assertThat(c.getPhone()).isEqualTo("4445556666");
        assertThat(c.getAddress()).isEqualTo("334 Lehi Lane");
      
    }
}

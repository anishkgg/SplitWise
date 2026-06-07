package service;

import model.User;
import org.example.splitwise.SplitWiseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SplitWiseApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        String name = "AppMapTestUser";
        User user = userService.createUser(name);
        
        assertNotNull(user);
        assertEquals(name, user.getName());
        assertTrue(user.getId() > 0);
    }
}

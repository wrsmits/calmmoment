package wesley.calmmoment.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    static AppUser appUser;

    @BeforeAll
    public static void setUp() throws Exception {
        appUser = new AppUser();
        appUser.setUserId((long) 1);

    }

    @Test
    void getUserId() {
        assertEquals(appUser.getUserId(), (long) 1);
    }

    @Test
    void setUserName() {
        appUser.setUserName("Sergio");
        assertEquals(appUser.getUserName(), "Sergio");
    }
}

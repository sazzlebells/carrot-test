import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Show user list")
    void send() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Eva", 0, 500));
        users.add(new User("Sarah", 1, 500));
        users.add(new User("Rahma", 2, 500));
        users.add(new User("Winnona", 3, 500));

        String success = "Transaction succeed!";
        String fail = "Transaction failed.";

        assertEquals(success, Main.sendPoints(users.get(0), users.get(1),500));
        assertEquals(success, Main.sendPoints(users.get(1), users.get(2),700));
        assertEquals(fail, Main.sendPoints(users.get(0), users.get(2),100));
    }
}
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Send points test")
    void send() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Eva", 0, 500));
        users.add(new User("Sarah", 1, 500));
        users.add(new User("Rahma", 2, 500));
        users.add(new User("Winnona", 3, 500));

        String success = "Transaction succeed!";
        String fail = "Transaction failed.";

        assertEquals(success, Main.sendPoints(users.get(0), users.get(1),500));
        assertEquals(0, users.get(0).getPoints()); //Eva: 0
        assertEquals(1000, users.get(1).getPoints()); //Sarah: 1000

        assertEquals(success, Main.sendPoints(users.get(1), users.get(2),700));
        assertEquals(300, users.get(1).getPoints()); //Sarah: 300
        assertEquals(1200, users.get(2).getPoints()); // Rahma: 1200

        assertEquals(fail, Main.sendPoints(users.get(0), users.get(2),100));
        assertEquals(0, users.get(0).getPoints()); //Eva: 0 karna send fail
        assertEquals(1200, users.get(2).getPoints()); // Rahma: 1200 ga nambah
    }
}
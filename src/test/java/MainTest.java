import model.History;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

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

    @Test
    @DisplayName("Test the show user function")
    void testShowUser() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("Eva", 0, 500));
        users.add(new User("Sarah", 1, 500));
        users.add(new User("Rahma", 2, 500));
        users.add(new User("Winnona", 3, 500));

        assertEquals(4, users.size());
        Main.showUsers(users);
    }

    @Test
    @DisplayName("Test the get history function")
    void testGetHistory(){
        Date now = new Date();
        ArrayList<History> historyList = new ArrayList<>();
        historyList.add(new History("Eva", "Sarah", 0, 100, now));
        historyList.add(new History("Winnona", "Sarah", 0, 100, now));

        assertEquals(2, historyList.size());
        Main.getHistory(historyList);
    }
}
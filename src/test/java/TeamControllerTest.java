import controller.TeamController;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeamControllerTest {

    @Test
    public void calculateRankingTable() {

        String[] array = new String[] {
                "Lions 3, Snakes 3",
                "Tarantulas 1, FC Awesome 0",
                "Lions 1, FC Awesome 1",
                "Tarantulas 3, Snakes 1",
                "Lions 4, Grouches 0"};

        List<String> expectedList = Arrays.asList(
            "1. Tarantulas, 6 pts",
            "2. Lions, 5 pts",
            "3. FC Awesome, 1 pt",
            "3. Snakes, 1 pt",
            "5. Grouches, 0 pts");

        TeamController teamController = new TeamController();
        List<String> newList = teamController.calculateRankingTable(array);
        assertEquals(expectedList, newList);
    }

    @Test
    public void calculateRankingTableThrowsException() {

        String[] array = new String[] {
                "Lions 3 Snakes 3",
                "Tarantulas 1, FC Awesome 0",
                "Lions 1, FC Awesome 1",
                "Tarantulas , Snakes 1",
                "Lions 4, Grouches 0"};

        Throwable exception = assertThrows(
                ArrayIndexOutOfBoundsException.class, () -> {
                    TeamController teamController = new TeamController();
                    teamController.calculateRankingTable(array);
                }
        );

        assertEquals("Index 1 out of bounds for length 1", exception.getMessage());
    }
}

import controller.TeamController;
import view.RankingTableView;

public class Main {

    public static void main(String[] args) {

        //Create view object
        RankingTableView view = new RankingTableView();

        //Create controller object
        TeamController teamController = new TeamController(view);

        view.run();

    }
}



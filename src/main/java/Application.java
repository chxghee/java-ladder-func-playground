import controller.LadderGameController;
import model.RandomLinkGenerator;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new RandomLinkGenerator());
        ladderGameController.run();
    }
}

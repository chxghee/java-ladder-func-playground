package controller;

import model.Ladder;
import model.LinkGenerator;
import view.OutputView;

public class LadderGameController {

    private final LinkGenerator linkGenerator;

    public LadderGameController(LinkGenerator linkGenerator) {
        this.linkGenerator = linkGenerator;
    }

    public void run() {
        int height = 4;
        int width = 4;

        Ladder ladder = Ladder.of(height, width, linkGenerator);
        OutputView.printLadder(ladder);
    }
}

package controller;

import model.Ladder;
import model.LinkGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final LinkGenerator linkGenerator;

    public LadderGameController(LinkGenerator linkGenerator) {
        this.linkGenerator = linkGenerator;
    }

    public void run() {

        int width = getWidth();
        int height = getHeight();

        Ladder ladder = Ladder.of(height, width, linkGenerator);
        OutputView.printLadder(ladder);
    }

    private static int getHeight() {
        OutputView.printHeightMessage();
        return InputView.getInt();
    }

    private static int getWidth() {
        OutputView.printWidthMessage();
        return InputView.getInt();
    }

}

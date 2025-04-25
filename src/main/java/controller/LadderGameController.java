package controller;

import model.Ladder;
import model.LinkGenerator;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LadderGameController {

    private final LinkGenerator linkGenerator;

    public LadderGameController(LinkGenerator linkGenerator) {
        this.linkGenerator = linkGenerator;
    }

    public void run() {

        int width = getWidth();
        int height = getHeight();

        Ladder ladder = Ladder.of(height, width, linkGenerator);
        Map<Integer, Integer> results = getLadderGameResult(width, ladder);

        OutputView.printLadder(ladder);
        OutputView.printResults(results);
    }

    private static Map<Integer, Integer> getLadderGameResult(int width, Ladder ladder) {
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < width; i++) {
            results.put(i, ladder.ride(i));
        }
        return results;
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

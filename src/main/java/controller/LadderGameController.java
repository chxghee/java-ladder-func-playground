package controller;

import model.*;
import utils.StringSplitter;
import view.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Optional;

import static utils.Constants.FINAL_QUERY_KEYWORD;

public class LadderGameController {

    private final LinkGenerator linkGenerator;

    public LadderGameController(LinkGenerator linkGenerator) {
        this.linkGenerator = linkGenerator;
    }

    public void run() {
        Users users = getUsers();
        Prizes prizes = getPrizes(users.size());
        int height = getHeight();

        Ladder ladder = Ladder.of(height, users.size(), linkGenerator);
        OutputView.printLadder(ladder, users, prizes);

        LadderGameResult ladderGameResult = LadderGameResult.of(users, prizes, ladder);
        handleUserResultQuery(ladderGameResult, users);
    }

    private static void handleUserResultQuery(LadderGameResult ladderGameResult, Users users) {

        Optional<User> findUser = getFindUsername(users);

        if (findUser.isEmpty()) {
            OutputView.printAllResults(ladderGameResult);
            return;
        }

        OutputView.printPrize(ladderGameResult.findByUser(findUser.get()));
        handleUserResultQuery(ladderGameResult, users);
    }

    private static Optional<User> getFindUsername(Users users) {
        OutputView.printQueryInputMessage();
        String findUsername = InputView.getString();
        if (findUsername.equals(FINAL_QUERY_KEYWORD)) {
            return Optional.empty();
        }
        try {
            return Optional.of(users.findByUsername(findUsername));
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getFindUsername(users);
        }
    }

    private static Users getUsers() {
        OutputView.printUsernameInputMessage();
        try {
            return Users.from(readAndSplitInput());
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUsers();
        }
    }

    private static Prizes getPrizes(int participantCount) {
        OutputView.printPrizeInputMessage();
        try {
            return Prizes.of(readAndSplitInput(), participantCount);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPrizes(participantCount);
        }
    }

    private static List<String> readAndSplitInput() {
        String inputString = InputView.getString();
        InputValidator.validateInputStringPattern(inputString);
        return StringSplitter.splitByComma(inputString);
    }

    private static int getHeight() {
        OutputView.printHeightInputMessage();
        return InputView.getInt();
    }
}

package view;

import model.*;

import java.util.List;
import java.util.function.Function;

public class OutputView {

    public static void printUsernameInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printHeightInputMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printPrizeInputMessage() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static void printQueryInputMessage() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public static void printPrize(Prize prize) {
        System.out.println("실행결과");
        System.out.println(prize.getPrizeName());
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public static void printLadder(Ladder ladder, Users users, Prizes prizes) {
        System.out.println("사다리 결과");
        printAligned(users.getUsers(), User::getName);
        ladder.getLines().forEach(OutputView::printHorizontalLine);
        printAligned(prizes.getPrizes(), Prize::getPrizeName);
        System.out.println();
    }

    public static void printAllResults(LadderGameResult ladderGameResult) {
        System.out.println("실행결과");
        ladderGameResult.getGameResults().forEach((user, prize) ->
            System.out.println(user.getName() + " : " + prize.getPrizeName())
        );
        System.out.println();
    }

    private static <T> void printAligned(List<T> items, Function<T, String> mapper) {
        items.forEach(item ->
                System.out.printf("%-6s", mapper.apply(item)));
        System.out.println();
    }

    private static void printHorizontalLine(HorizontalLine line) {
        System.out.print(" ");
        line.getPoints().forEach(point -> {
            System.out.print("|");
            printCrossing(point);
        });
        System.out.println();
    }

    private static void printCrossing(Link point) {
        if (point == Link.LINKED) {
            System.out.print("-----");
        }
        if (point == Link.UNLINKED) {
            System.out.print("     ");
        }
    }
}

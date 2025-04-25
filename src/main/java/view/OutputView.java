package view;

import model.HorizontalLine;
import model.Ladder;
import model.Link;

import java.util.Map;

public class OutputView {

    public static void printWidthMessage() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
    }

    public static void printHeightMessage() {
        System.out.println("사다리의 높이는 몇 개인가요?");
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        for (HorizontalLine line : ladder.getLines()) {
            printHorizontalLine(line);
        }
        System.out.println();
    }

    public static void printResults(Map<Integer, Integer> results) {
        for (Integer i : results.keySet()) {
            System.out.println(i + " -> " + results.get(i));
        }
    }

    private static void printHorizontalLine(HorizontalLine line) {
        for (Link point : line.getPoints()) {
            System.out.print("|");
            printCrossing(point);
        }
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

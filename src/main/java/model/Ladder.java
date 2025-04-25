package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<HorizontalLine> lines;

    private Ladder(List<HorizontalLine> horizontalLines) {
        this.lines = horizontalLines;
    }

    public static Ladder of(int height, int participantCount, LinkGenerator generator) {
        return new Ladder(getHorizontalRandomLines(height, participantCount, generator));
    }

    public Prize ride(User user, Prizes prizes) {
        int position = user.getPosition();
        for (HorizontalLine line : lines) {
            position = line.move(position);
        }
        return prizes.getPrizeAtPosition(position);
    }

    private static List<HorizontalLine> getHorizontalRandomLines(int height, int width, LinkGenerator generator) {
        List<HorizontalLine> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            HorizontalLine horizontalLine = LineGenerator.generateHorizontalLine(width, generator);
            lines.add(horizontalLine);
        }
        return lines;
    }

    public List<HorizontalLine> getLines() {
        return lines;
    }
}

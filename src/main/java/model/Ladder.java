package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<HorizontalLine> lines;

    private Ladder(List<HorizontalLine> horizontalLines) {
        this.lines = horizontalLines;
    }

    public static Ladder of(int height, int width, LinkGenerator generator) {
        return new Ladder(getHorizontalRandomLines(height, width, generator));
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

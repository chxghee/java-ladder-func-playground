package model;

import java.util.Collections;
import java.util.List;

public class HorizontalLine {
    private final List<Link> points;

    public HorizontalLine(List<Link> points) {
        this.points = points;
    }

    public List<Link> getPoints() {
        return Collections.unmodifiableList(points);
    }
}

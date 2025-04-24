package model;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Link> points;

    public Line(List<Link> points) {
        this.points = points;
    }

    public List<Link> getPoints() {
        return Collections.unmodifiableList(points);
    }
}

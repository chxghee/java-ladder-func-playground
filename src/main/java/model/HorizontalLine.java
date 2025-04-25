package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HorizontalLine {

    private final List<Link> points;

    public HorizontalLine(List<Link> points) {
        this.points = points;
    }

    public int move(int position) {
        return Arrays.stream(MovingDirection.values())
                .filter(movingDirection -> movingDirection.canMove(position, this))
                .findFirst()
                .map(movingDirection -> movingDirection.move(position))
                .orElse(position);
    }

    public int size() {
        return points.size();
    }

    public Link getLink(int index) {
        return points.get(index);
    }

    public List<Link> getPoints() {
        return Collections.unmodifiableList(points);
    }
}

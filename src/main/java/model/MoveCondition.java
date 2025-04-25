package model;

@FunctionalInterface
public interface MoveCondition {
    boolean canMove(int index, HorizontalLine line);
}

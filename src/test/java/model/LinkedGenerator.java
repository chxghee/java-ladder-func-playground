package model;

public class LinkedGenerator implements LinkGenerator {
    @Override
    public Link generate() {
        return Link.from(true);
    }
}

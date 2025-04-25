package model;

public class UnLinkedGenerator implements LinkGenerator{
    @Override
    public Link generate() {
        return Link.from(false);
    }
}

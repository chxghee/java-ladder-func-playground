package model;

import java.util.concurrent.ThreadLocalRandom;

public class LinkGenerator implements BooleanGenerator {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

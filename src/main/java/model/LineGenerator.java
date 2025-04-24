package model;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {        // 가로 기준으로 연결 여부 라인을 생성

    public static HorizontalLine generateHorizontalLine(int width, LinkGenerator generate) {

        Link prev = Link.UNLINKED;
        List<Link> link = new ArrayList<>();
        
        for (int i = 0; i < width - 1; i++) {
            prev = addLink(prev, generate.generate(), link);
        }
        link.add(Link.UNLINKED);
        return new HorizontalLine(link);
    }

    private static Link addLink(Link prev, Link now, List<Link> link) {
        if (prev.isLinked()) {
            now = Link.UNLINKED;
        }
        link.add(now);
        return now;
    }

}

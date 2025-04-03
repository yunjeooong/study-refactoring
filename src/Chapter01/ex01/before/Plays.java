package Chapter01.ex01;

import java.util.Map;

public class Plays {
    private final Map<String, Play> plays;

    public Plays(Map<String, Play> plays) {
        this.plays = plays;
    }

    public Play get(Performance performance) {
        return plays.get(performance.getPlayID());
    }
}
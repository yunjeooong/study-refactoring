package Chapter01.ex01.after;

public abstract class PerformanceCalculator {
    protected Performance performance;
    protected Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public abstract int amountFor() throws Exception;

    public int volumeCreditFor() {
        return Math.max(performance.getAudience() - 30, 0);
    }
} 
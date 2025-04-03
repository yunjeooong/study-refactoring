package Chapter01.ex01.after;

import java.util.List;
import java.util.stream.Collectors;

public class StatementData {
    private final String customer;
    private final List<EnrichedPerformance> performances;
    private final Plays plays;

    public StatementData(Invoice invoice, Plays plays) {
        this.customer = invoice.getCustomer();
        this.plays = plays;
        
        // Enrich performances with play data
        this.performances = invoice.getPerformances().stream()
                .map(perf -> new EnrichedPerformance(perf, playFor(perf)))
                .collect(Collectors.toList());
    }

    public String getCustomer() {
        return customer;
    }

    public List<EnrichedPerformance> getPerformances() {
        return performances;
    }

    public Play playFor(Performance performance) {
        return plays.get(performance);
    }

    public int totalAmount() throws Exception {
        int result = 0;
        for (EnrichedPerformance performance : performances) {
            result += performance.getAmount();
        }
        return result;
    }

    public int totalVolumeCredits() throws Exception {
        int result = 0;
        for (EnrichedPerformance performance : performances) {
            result += performance.getVolumeCredit();
        }
        return result;
    }

    // Inner class to hold enriched performance data
    public class EnrichedPerformance {
        private final Performance performance;
        private final Play play;
        private final PerformanceCalculator calculator;

        public EnrichedPerformance(Performance performance, Play play) {
            this.performance = performance;
            this.play = play;
            this.calculator = createPerformanceCalculator();
        }

        private PerformanceCalculator createPerformanceCalculator() {
            PerformanceCalculatorFactory factory = new PerformanceCalculatorFactory();
            try {
                return factory.createPerformanceCalculator(performance, play);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public String getPlayName() {
            return play.getName();
        }

        public int getAudience() {
            return performance.getAudience();
        }

        public int getAmount() throws Exception {
            return calculator.amountFor();
        }

        public int getVolumeCredit() throws Exception {
            return calculator.volumeCreditFor();
        }
    }
} 
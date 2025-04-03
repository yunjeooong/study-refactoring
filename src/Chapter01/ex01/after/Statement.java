package Chapter01.ex01.after;

public class Statement {
    public String statement(Invoice invoice, Plays plays) throws Exception {
        StatementData statementData = new StatementData(invoice, plays);
        return renderPlainText(statementData);
    }

    public String htmlStatement(Invoice invoice, Plays plays) throws Exception {
        StatementData statementData = new StatementData(invoice, plays);
        return renderHtml(statementData);
    }

    private String renderPlainText(StatementData statementData) throws Exception {
        StringBuilder result = new StringBuilder(String.format("청구내역 (고객명: %s)\n", statementData.getCustomer()));

        for (StatementData.EnrichedPerformance performance : statementData.getPerformances()) {
            result.append(String.format("%s: $%d %d석\n", 
                performance.getPlayName(), 
                performance.getAmount() / 100, 
                performance.getAudience()));
        }

        result.append(String.format("총액: $%d\n", statementData.totalAmount() / 100));
        result.append(String.format("적립 포인트: %d점", statementData.totalVolumeCredits()));
        
        return result.toString();
    }

    private String renderHtml(StatementData statementData) throws Exception {
        StringBuilder result = new StringBuilder("<h1>청구내역 (고객명: " + statementData.getCustomer() + ")</h1>\n");
        result.append("<table>\n");
        result.append("<tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>\n");

        for (StatementData.EnrichedPerformance performance : statementData.getPerformances()) {
            result.append(String.format("<tr><td>%s</td><td>%d석</td><td>$%d</td></tr>\n", 
                performance.getPlayName(), 
                performance.getAudience(), 
                performance.getAmount() / 100));
        }

        result.append("</table>\n");
        result.append(String.format("<p>총액: <em>$%d</em></p>\n", statementData.totalAmount() / 100));
        result.append(String.format("<p>적립 포인트: <em>%d</em>점</p>", statementData.totalVolumeCredits()));
        
        return result.toString();
    }
} 
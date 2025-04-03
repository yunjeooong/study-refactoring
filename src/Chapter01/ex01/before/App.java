package Chapter01.ex01;

import java.util.Map;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Play 등록
        Play hamlet = new Play("hamlet", PlayType.TRAGEDY);
        Play asYouLikeIt = new Play("As You Like It", PlayType.COMEDY);
        Play othello = new Play("Othello", PlayType.TRAGEDY);

        // Plays 맵 구성
        Map<String, Play> playsMap = Map.of(
                "hamlet", hamlet,
                "as-like", asYouLikeIt,
                "othello", othello
        );
        Plays plays = new Plays(playsMap);

        // 공연 요청 (Invoice)
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)
        ));

        // Statement 로직 실행
        Statement statement = new Statement();
        String result = statement.statement(invoice, plays);
        System.out.println(result);
    }
}
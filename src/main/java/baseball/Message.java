package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Message {

    public void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void ballCountMessage(Integer ball, Integer strike) {
        StringBuilder countMessage = new StringBuilder();

        if (ball == 0 && strike == 0) {
            countMessage.append("낫싱");
        }
        if (ball != 0) {
            countMessage.append(ball);
            countMessage.append("볼 ");
        }
        if (strike != 0) {
            countMessage.append(strike);
            countMessage.append("스트라이크");
        }
        System.out.println(countMessage);
    }

    public void endGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

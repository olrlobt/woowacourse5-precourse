package bridge.view;

import bridge.util.Utils;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return Utils.inputToNumber(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movePlace = Console.readLine();
        if (!movePlace.equals("U") && !movePlace.equals("D")) {
            ExceptionView.movingCommandError();
            throw new IllegalArgumentException();
        }
        return movePlace;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        String command = Console.readLine();

        if (command.equals("R")) {
            return true;
        } else if (command.equals("Q")) {
            return false;
        }
        ExceptionView.gameCommandError();
        throw new IllegalArgumentException();
    }
}

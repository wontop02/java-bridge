package bridge.view;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String BRIDGE_PREFIX = "[ ";
    private static final String BRIDGE_POSTFIX = " ]";
    private static final String BRIDGE_SEPARATOR = " | ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private static final String PRINT_START = "다리 건너기 게임을 시작합니다.";
    private static final String PRINT_RESULT = "최종 게임 결과";
    private static final String PRINT_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String PRINT_TRY_COUNT = "총 시도한 횟수: ";

    public void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
        System.out.println();
    }

    public void printStart() {
        System.out.println(PRINT_START);
        System.out.println();
    }

    public void printMap(List<String> upBridge, List<String> downBridge) {
        String up = String.join(BRIDGE_SEPARATOR, upBridge);
        System.out.println(BRIDGE_PREFIX + up + BRIDGE_POSTFIX);
        String down = String.join(BRIDGE_SEPARATOR, downBridge);
        System.out.println(BRIDGE_PREFIX + down + BRIDGE_POSTFIX);
        System.out.println();
    }

    public void printResult(List<String> upBridge, List<String> downBridge, boolean isSuccess, int tryCount) {
        System.out.println(PRINT_RESULT);
        printMap(upBridge, downBridge);
        String gameResult = SUCCESS;
        if (!isSuccess) {
            gameResult = FAIL;
        }
        System.out.println(PRINT_SUCCESS_OR_FAIL + gameResult);
        System.out.println(PRINT_TRY_COUNT + tryCount);
    }
}

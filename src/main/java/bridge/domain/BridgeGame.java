package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private static final String BLANK = " ";
    private static final String EQUAL = "O";
    private static final String DIFFERENT = "X";

    private final List<String> bridge;
    private final List<String> moveState = new ArrayList<>();
    private boolean isFail = false;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public void move(String moving) {
        moveState.add(moving);
    }

    public List<String> upBridge() {
        List<String> upBridge = new ArrayList<>();
        for (int i = 0; i < moveState.size(); i++) {
            if (!moveState.get(i).equals(Direction.UP.getDirection())) {
                upBridge.add(BLANK);
                continue;
            }
            if (bridge.get(i).equals(moveState.get(i))) {
                upBridge.add(EQUAL);
                continue;
            }
            upBridge.add(DIFFERENT);
            isFail = true;
        }
        return upBridge;
    }

    public List<String> downBridge() {
        List<String> downBridge = new ArrayList<>();
        for (int i = 0; i < moveState.size(); i++) {
            if (!moveState.get(i).equals(Direction.DOWN.getDirection())) {
                downBridge.add(BLANK);
                continue;
            }
            if (bridge.get(i).equals(moveState.get(i))) {
                downBridge.add(EQUAL);
                continue;
            }
            downBridge.add(DIFFERENT);
            isFail = true;
        }
        return downBridge;
    }

    public boolean isFail() {
        return isFail;
    }

    public boolean isSuccess() {
        return !isFail && bridge.size() == moveState.size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}

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
    private int tryCount = 1;

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

    public void retry() {
        moveState.clear();
        tryCount++;
        isFail = false;
    }

    public int getTryCount() {
        return tryCount;
    }
}

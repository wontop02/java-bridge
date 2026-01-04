package bridge.domain;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int number;

    Direction(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public static Direction valueOfNumber(int number) {
        if (number == 1) {
            return UP;
        }
        return DOWN;
    }

    public String getDirection() {
        return direction;
    }
}

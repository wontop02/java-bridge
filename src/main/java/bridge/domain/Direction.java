package bridge.domain;

import java.util.Arrays;

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
        return Arrays.stream(Direction.values())
                .filter(d -> d.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

    public String getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }
}

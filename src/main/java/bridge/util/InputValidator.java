package bridge.util;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int MIN = 3;
    private static final int MAX = 20;
    private static final Set<String> MOVING_INPUT =
            new HashSet<>(Arrays.asList("U", "D"));
    private static final Set<String> COMMAND_INPUT =
            new HashSet<>(Arrays.asList("R", "Q"));

    private static final String BLANK_INPUT = "빈 문자열이 입력되었습니다.";
    private static final String NOT_ONLY_DIGIT = "숫자를 제외한 문자가 포함되어 있습니다.";
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";
    private static final String INVALID_RANGE =
            String.format(
                    "%d 이상, %d 이하의 숫자만 입력할 수 있습니다.",
                    MIN, MAX
            );
    private static final String INVALID_MOVING_INPUT = "칸을 정확히 선택해 주세요.";
    private static final String INVALID_COMMAND_INPUT = "기능을 정확히 선택해 주세요.";

    public static void validateBridgeSize(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
        validateWithinIntRange(input);
        validateRange(Integer.parseInt(input));
    }

    public static void validateMoving(String input) {
        validateNotBlank(input);
        validateMovingInput(input);
    }

    public static void validateCommand(String input) {
        validateNotBlank(input);
        validateCommandInput(input);
    }

    private static void validateCommandInput(String input) {
        if (!COMMAND_INPUT.contains(input)) {
            throw new IllegalArgumentException(INVALID_COMMAND_INPUT);
        }
    }

    private static void validateMovingInput(String input) {
        if (!MOVING_INPUT.contains(input)) {
            throw new IllegalArgumentException(INVALID_MOVING_INPUT);
        }
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }

    private static void validateOnlyDigit(String input) {
        if (!input.matches(ONLY_DIGIT_REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT);
        }
    }

    private static void validateWithinIntRange(String input) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private static void validateRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }
}

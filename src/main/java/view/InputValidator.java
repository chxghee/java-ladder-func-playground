package view;

public class InputValidator {

    private static final String USERNAME_NAMES_PATTERN = "^([a-zA-Z가-힣0-9]+)(,[a-zA-Z가-힣0-9]+)*$";

    public static void validateUsernamePattern(String inputUsernames) {
        if (!inputUsernames.matches(USERNAME_NAMES_PATTERN)) {
            throw new IllegalArgumentException("게임에 참여할 유저 이름은 쉼표로 구분 되어야 합니다!");
        }
    }
}

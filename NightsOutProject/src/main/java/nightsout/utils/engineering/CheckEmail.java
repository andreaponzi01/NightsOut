package nightsout.utils.engineering;

public class CheckEmail {

    private CheckEmail() {
        // ignored
    }
        public static boolean validate(String email) {
            return email != null && !email.isEmpty() &&
                    email.replaceAll("[^@]", "").length() == 1
                    && !email.contains(".@");
        }
}

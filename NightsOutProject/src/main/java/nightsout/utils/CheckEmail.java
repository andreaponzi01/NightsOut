package nightsout.utils;

public class CheckEmail {

    public boolean validate(String email) {
        return email != null && !email.isEmpty() &&
                email.replaceAll("[^@]", "").length() == 1
                && !email.contains(".@");
    }
}

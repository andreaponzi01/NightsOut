package nightsout.utils.engineering;

public class CheckEmailEngineering {

    public boolean validate(String email) {
        return email != null && !email.isEmpty() &&
                email.replaceAll("[^@]", "").length() == 1
                && !email.contains(".@");
    }
}

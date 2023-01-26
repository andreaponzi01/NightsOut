package nightsout.utils.engineering;

import nightsout.utils.bean.EmailBean;

public class CheckEmailEngineering {

    public boolean validate(EmailBean emailBean) {
        String email = emailBean.getEmail();
        return email != null && !email.isEmpty() && email.replaceAll("[^@]", "").length() == 1 && !email.contains(".@");
    }
}

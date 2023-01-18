package nightsout.utils.bean.interface1;

import nightsout.model.UserModel;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.AdultException;
import nightsout.utils.exception.myexception.EmptyInputException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UserBean1 extends UserBean {


    public UserBean1(){
        super();
    }

    public UserBean1(UserBean userBean) {
        super(userBean);
    }

    public UserBean1(UserModel userModel) {
        super(userModel);
    }

    public void setGender(String gender) { this.gender = gender; }

    public void setBirthday(LocalDate birthday) throws AdultException, EmptyInputException {
        if (birthday == null) {
            trigger.throwEmptyInputException("Date");
        } else {
            if (birthday.until(LocalDate.now(), ChronoUnit.YEARS) < 18)
                trigger.throwAdultException();
            this.birthday = birthday;
        }
    }
}

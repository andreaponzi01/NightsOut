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
    }

    public UserBean1(UserModel userModel) {
        this.surname = userModel.getSurname();
        this.name = userModel.getName();
        this.username = userModel.getUsername();
        this.gender = userModel.getGender();
        this.email = userModel.getEmail();
        this.id = userModel.getId();
        this.img = userModel.getProfileImg();
        this.birthday = userModel.getBirthday();
        this.vip = userModel.getVip();
        this.creationDateVIP = userModel.getCreationDateVip();
    }

    public void setGender(String gender) { this.gender = gender; }

    public void setBirthday(LocalDate birthday) throws AdultException, EmptyInputException {
        if (birthday == null) {
            Trigger.throwEmptyInputException("Date");
        } else {
            if (birthday.until(LocalDate.now(), ChronoUnit.YEARS) < 18)
                Trigger.throwAdultException();
            this.birthday = birthday;
        }
    }
}

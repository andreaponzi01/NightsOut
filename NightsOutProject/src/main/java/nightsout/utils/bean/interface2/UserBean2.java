package nightsout.utils.bean.interface2;

import nightsout.model.UserModel;
import nightsout.utils.bean.UserBean;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.AdultException;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.GenderException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class UserBean2 extends UserBean {

    public UserBean2(){
    }

    public UserBean2(UserBean userBean){
        super(userBean);
    }

    public UserBean2(UserModel userModel) {
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

    public void setGender(String gender) throws GenderException {

            if (!(gender.equals("Male")) && !(gender.equals("Female"))) {
                Trigger.throwGenderException();
            } else {
                this.gender = gender;
            }
    }

    public void setBirthday(String birthday) throws AdultException, EmptyInputException, WrongInputTypeException {

        if (birthday.equals("")) {
            Trigger.throwEmptyInputException("Date");
        } else {
            try {
                SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
                Date birthdayDate = formatter1.parse(birthday);
                LocalDate birthdayLocalDate = LocalDate.from(birthdayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                if (birthdayLocalDate.until(LocalDate.now(), ChronoUnit.YEARS) < 18)
                    Trigger.throwAdultException();
                this.birthday = birthdayLocalDate;
            } catch (NumberFormatException e) {
                Trigger.throwWrongInputTypeException(e, "Birthday");
            } catch (DateTimeException e) {
                Trigger.throwWrongInputTypeException(new NumberFormatException(), "Birthday");
            } catch (ParseException e) {
                Trigger.throwWrongInputTypeException(new NumberFormatException(), "Birthday");
            }
        }
    }

}

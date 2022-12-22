package nightsout.utils.bean;

import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;

public class ClubOwnerBean  extends ProfileBean {


    private static final String FIELD_CITY = "City";

    protected String address;
    protected String city;
    protected int discountVIP;

    public String getCity() {return city;}
    public int getDiscountVIP() {
        return discountVIP;
    }
    public String getAddress() {return address;}

    public void setCity(String city) throws EmptyInputException {
        if (city.equals(""))
            Trigger.throwEmptyInputException(FIELD_CITY);
        this.city = city;
    }



}

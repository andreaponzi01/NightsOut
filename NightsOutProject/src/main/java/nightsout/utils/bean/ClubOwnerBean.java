package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputRangeException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

public class ClubOwnerBean extends ProfileBean {

    public ClubOwnerBean() {
    }

    // Attributi ClubManager
    protected String address;
    protected String city;
    protected int discountVIP;

    private static final String FIELD_DISCOUNT = "Discount";
    private static final String FIELD_ADDRESS = "Address";
    private static final String FIELD_CITY = "City";

    public void setDiscountVIP(String discountVIP) throws WrongInputTypeException, EmptyInputException, WrongInputRangeException {
        try {
            if (discountVIP.equals("")) {
                Trigger.throwEmptyInputException(FIELD_DISCOUNT);
            } else if (Integer.parseInt(discountVIP) > 20 || Integer.parseInt(discountVIP) < 0) {
                Trigger.throwExceededRangeException(FIELD_DISCOUNT);
            } else {
                this.discountVIP = Integer.parseInt(discountVIP);
            }
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, FIELD_DISCOUNT);
        }
    }

    public ClubOwnerBean(ClubOwnerModel clubOwnerModel) {
        this.username = clubOwnerModel.getUsername();
        this.name = clubOwnerModel.getClubName();
        this.address = clubOwnerModel.getAddress();
        this.city = clubOwnerModel.getCity();
        this.discountVIP = clubOwnerModel.getDiscountVIP();
        this.email = clubOwnerModel.getEmail();
        this.id = clubOwnerModel.getId();
        this.img = clubOwnerModel.getProfileImg();
    }

    // Getter
    public String getAddress() {return address;}

    public String getCity() {return city;}
    public int getDiscountVIP() {
        return discountVIP;
    }

    // Setter
    public void setAddress(String address) throws EmptyInputException {
        if (address.equals(""))
            Trigger.throwEmptyInputException(FIELD_ADDRESS);
        this.address = address;
    }
    public void setCity(String city) throws EmptyInputException {
        if (city.equals(""))
            Trigger.throwEmptyInputException(FIELD_CITY);
        this.city = city;
    }

}

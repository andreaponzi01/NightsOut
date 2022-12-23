package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;

public class ClubOwnerBean  extends ProfileBean {

    public ClubOwnerBean() {}

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

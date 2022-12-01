package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

import java.net.URL;

public class ClubOwnerBean extends ProfileBean {

    public ClubOwnerBean() {
        this.type = "Club Owner";
    }

    // Attributi ClubManager
    protected String address;
    protected URL website;
    protected String city;

    public int getDiscountVIP() {
        return discountVIP;
    }

    public void setDiscountVIP(String discountVIP) throws WrongInputTypeException, EmptyInputException {
        try {
            if(discountVIP.equals(""))
                Trigger.emptyField("Discount");
            this.discountVIP = Integer.parseInt(discountVIP);
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, "Discount");
        }
    }

    protected int discountVIP;



    public ClubOwnerBean(ClubOwnerModel clubOwnerModel) {
        this.username = clubOwnerModel.getUsername();
        this.name = clubOwnerModel.getClubName();
        this.address = clubOwnerModel.getAddress();
        this.city = clubOwnerModel.getCity();
        this.discountVIP = clubOwnerModel.getDiscountVIP();
        this.email = clubOwnerModel.getEmail();
        this.id = clubOwnerModel.getId();
        this.type = "Club Owner";
    }

    // Getter
    public String getAddress() {return address;}
    public URL getWebsite() {return website;}
    public String getCity() {return city;}

    // Setter
    public void setAddress(String address) throws EmptyInputException {
        if (address.equals(""))
            Trigger.emptyField("Address");
        this.address = address;
    }
    public void setWebsite(URL website) {
        this.website = website;
    }
    public void setCity(String city) throws EmptyInputException {
        if (city.equals(""))
            Trigger.emptyField("City");
        this.city = city;
    }

}

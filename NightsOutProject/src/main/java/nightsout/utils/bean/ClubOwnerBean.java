package nightsout.utils.bean;

import nightsout.model.ClubOwnerModel;

import java.net.URL;

public class ClubOwnerBean extends ProfileBean {

    public ClubOwnerBean() {

    }

    // Attributi ClubManager
    protected String address;
    protected URL website;
    protected String city;

    public int getDiscountVIP() {
        return discountVIP;
    }

    public void setDiscountVIP(int discountVIP) {
        this.discountVIP = discountVIP;
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
        this.type = clubOwnerModel.getType();
    }

    // Getter
    public String getAddress() {return address;}
    public URL getWebsite() {return website;}
    public String getCity() {return city;}

    // Setter
    public void setAddress(String address) {
        this.address = address;
    }
    public void setWebsite(URL website) {
        this.website = website;
    }
    public void setCity(String city) {
        this.city = city;
    }

}

package nightsout.model;

import nightsout.utils.bean.ClubOwnerBean;

public class ClubOwnerModel extends ProfileModel {

    private String clubName;
    private String city;
    private String address;
    private int discountVIP;

    public ClubOwnerModel(String username){ super(username); }

    public ClubOwnerModel(ClubOwnerBean clubOwnerBean, Credentials myCred) {
        super(myCred, clubOwnerBean.getEmail());
        this.clubName = clubOwnerBean.getName();
        this.address = clubOwnerBean.getAddress();
        this.city = clubOwnerBean.getCity();
        this.discountVIP = clubOwnerBean.getDiscountVIP();
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDiscountVIP() {
        return discountVIP;
    }

    public void setDiscountVIP(int discountVIP) {
        this.discountVIP = discountVIP;
    }


}


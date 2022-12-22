package nightsout.model;

import nightsout.utils.bean.ClubOwnerBean;

public class ClubOwnerModel extends ProfileModel {

    private String clubName;
    private String city;
    private String address;
    private int discountVIP;



    public ClubOwnerModel(){
        super();
    }

    public ClubOwnerModel(ClubOwnerBean clubOwnerBean1) {

        super(clubOwnerBean1.getUsername(), clubOwnerBean1.getEmail(), clubOwnerBean1.getId(), clubOwnerBean1.getImg());
        this.clubName = clubOwnerBean1.getName();
        this.address = clubOwnerBean1.getAddress();
        this.city = clubOwnerBean1.getCity();
        this.discountVIP = clubOwnerBean1.getDiscountVIP();
        this.profileImg = clubOwnerBean1.getImg();
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

    public String getType() {
        return "Club Owner";
    }
}


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

    public ClubOwnerModel(ClubOwnerBean clubOwnerBean) {

        super(clubOwnerBean.getUsername(), clubOwnerBean.getEmail(), clubOwnerBean.getId(), clubOwnerBean.getImg());
        this.clubName = clubOwnerBean.getName();
        this.address = clubOwnerBean.getAddress();
        this.city = clubOwnerBean.getCity();
        this.discountVIP = clubOwnerBean.getDiscountVIP();
        this.profileImg = clubOwnerBean.getImg();
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


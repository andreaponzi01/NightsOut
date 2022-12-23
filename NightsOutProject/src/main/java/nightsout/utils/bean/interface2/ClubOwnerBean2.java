package nightsout.utils.bean.interface2;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.Trigger;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

public class ClubOwnerBean2 extends ClubOwnerBean {


    public ClubOwnerBean2() {
    }
    public ClubOwnerBean2(ClubOwnerModel clubOwnerModel) {
        super(clubOwnerModel);
    }
    public ClubOwnerBean2(ClubOwnerBean clubOwnerBean) {
        super(clubOwnerBean);
    }

    private static final String FIELD_DISCOUNT = "Discount";
    private static final String FIELD_ADDRESS = "Address";
    private static final String FIELD_CIVIC = "Civic Number";

    public void setDiscountVIP(int discountVIP) {
        this.discountVIP = discountVIP;
    }



    // Getter
    public String getAddress() {
        return address;
    }


    // Setter
    public void setAddress(String partialAddress, String civicNumber) throws EmptyInputException, WrongInputTypeException {
        try {
            if (partialAddress.equals("")) {
                Trigger.throwEmptyInputException(FIELD_ADDRESS);
            } else if (civicNumber.equals("")) {
                Trigger.throwEmptyInputException(FIELD_CIVIC);
            } else {

                // Controllo che il numero civico sia effettivamente un intero
                Integer.parseInt(civicNumber);
                this.address = partialAddress + ", " + civicNumber;
            }
        } catch (NumberFormatException e) {
            Trigger.throwWrongInputTypeException(e, FIELD_CIVIC);
        }
    }
}

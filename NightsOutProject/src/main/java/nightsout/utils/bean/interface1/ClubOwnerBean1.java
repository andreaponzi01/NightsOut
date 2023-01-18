package nightsout.utils.bean.interface1;

import nightsout.model.ClubOwnerModel;
import nightsout.utils.bean.ClubOwnerBean;
import nightsout.utils.exception.myexception.EmptyInputException;
import nightsout.utils.exception.myexception.WrongInputRangeException;
import nightsout.utils.exception.myexception.WrongInputTypeException;

public class ClubOwnerBean1 extends ClubOwnerBean {

    public ClubOwnerBean1() {
    }

    private static final String FIELD_DISCOUNT = "Discount";
    private static final String FIELD_ADDRESS = "Address";

    public void setDiscountVIP(String discountVIP) throws WrongInputTypeException, EmptyInputException, WrongInputRangeException {
        try {
            if (discountVIP.equals("")) {
                trigger.throwEmptyInputException(FIELD_DISCOUNT);
            } else if (Integer.parseInt(discountVIP) > 20 || Integer.parseInt(discountVIP) < 0) {
                trigger.throwExceededRangeException(FIELD_DISCOUNT);
            } else {
                this.discountVIP = Integer.parseInt(discountVIP);
            }
        } catch (NumberFormatException e) {
            trigger.throwWrongInputTypeException(e, FIELD_DISCOUNT);
        }
    }

    public ClubOwnerBean1(ClubOwnerModel clubOwnerModel) {
        super(clubOwnerModel);
    }

    public ClubOwnerBean1(ClubOwnerBean clubOwnerBean) {
        super(clubOwnerBean);
    }

    // Setter
    public void setAddress(String address) throws EmptyInputException {
        if (address.equals(""))
            trigger.throwEmptyInputException(FIELD_ADDRESS);
        this.address = address;
    }

}

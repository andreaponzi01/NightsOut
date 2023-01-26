package nightsout.control.guicontroller.interface2.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import nightsout.control.appcontroller.ManageReviewAppController;
import nightsout.utils.bean.EventBean;
import nightsout.utils.Session;
import nightsout.utils.bean.IdBean;
import nightsout.utils.bean.ReviewBean;
import nightsout.utils.bean.interface2.UserBean2;
import nightsout.utils.exception.ErrorDialog;
import nightsout.utils.exception.myexception.SystemException;
import nightsout.utils.switchpage.SwitchAndSetPage2;

public class ReviewItemGUIController2 {

    private UserBean2 userBean;
    private SwitchAndSetPage2 switchAndSetPage2 = new SwitchAndSetPage2();
    @FXML
    private Label labelComment;
    @FXML
    private Label labelEventName;
    @FXML
    private Label labelUsername;

    public void setAll(ReviewBean reviewBean) throws SystemException {

        ManageReviewAppController controller = new ManageReviewAppController();
        this.labelComment.setText(reviewBean.getComment());
        try {
            this.userBean = new UserBean2(controller.searchUserbyIdUser(new IdBean(reviewBean.getIdUser())));
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
        EventBean eventBean = controller.searchEventbyIdEvent(new IdBean(reviewBean.getIdEvent()));
        this.labelUsername.setText(userBean.getUsername());
        this.labelEventName.setText(eventBean.getName());
    }


    @FXML
    private void goToUserPage(ActionEvent actionEvent) {

        try {
            String type = Session.getInstance().checkInstanceType();
            if (type.equalsIgnoreCase("FREE")) {
                switchAndSetPage2.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromUser2.fxml",userBean);
            } else {
                switchAndSetPage2.switchAndSetSceneUser(actionEvent,"/ViewUserPageFromCO2.fxml",userBean);
            }
        } catch (SystemException e) {
            ErrorDialog.getInstance().handleException(e);
        }
    }
}

package nightsout.utils.observer;

import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;

public interface Observer {

    void update(Object ob) throws SQLException, SystemException;

    //void updateFrom(Object ob, Object from);

}
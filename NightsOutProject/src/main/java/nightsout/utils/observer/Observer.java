package nightsout.utils.observer;

import java.sql.SQLException;

public interface Observer {

    void update(Object ob) throws SQLException;

    //void updateFrom(Object ob, Object from);

}
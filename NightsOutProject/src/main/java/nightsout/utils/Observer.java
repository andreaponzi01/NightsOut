package nightsout.utils;

import java.sql.SQLException;

public interface Observer {

    void update(Object ob) throws SQLException;

    //void updateFrom(Object ob, Object from);

}
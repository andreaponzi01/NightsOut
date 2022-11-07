package nightsout.utils;

public interface Observer {

    void update(Object ob);

    void updateFrom(Object ob, Object from);

}
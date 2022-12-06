package nightsout.utils.observer;

import nightsout.utils.exception.myexception.SystemException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    public Subject() {

    }
    protected Subject(Observer observer) {
        this(new ArrayList<>()); //inizializzo la lista di observer con un ArrayList vuoto
        this.attach(observer);
    }

    protected Subject(List<Observer> list) {
        this.observers = list;
    }



    public void attach(Observer obs) {
        this.observers.add(obs);
    }


    public void remove(Observer obs) {
        this.observers.remove(obs);
    }

    public void notify(Object object) throws SQLException, SystemException {
        for (Observer observer : observers) {
            observer.update(object);
        }
    }

/*
    public void notifyObservers(Object ob, Object from) {
        for (Observer o : observers) {
            o.update(ob);
            o.updateFrom(ob, from);
        }
    }
 */

}
package nightsout.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    protected Subject(Observer observer) {
        this(new ArrayList<>());
        this.attach(observer);
    }
   /*
    protected Subject() {
        this(new ArrayList<>());
    }
    */

    protected Subject(List<Observer> list) {
        this.observers = list;
    }

    public void attach(Observer obs) {
        this.observers.add(obs);
    }


    public void remove(Observer obs) {
        this.observers.remove(obs);
    }

    public void notify(Object object) {
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
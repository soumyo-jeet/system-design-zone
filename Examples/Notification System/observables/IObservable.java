package observables;

import observers.IObserver;

public interface IObservable {
    void addObserver (IObserver o);
    void removeObserver (IObserver o);
    void notifyObserver ();
}

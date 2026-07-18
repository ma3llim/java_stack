package org.example.subject;

import org.example.observer.Oberserver;

public interface Subject {
    public void subscribe (Oberserver oberserver);
    public void unsubscribe (Oberserver oberserver);
    public void notifyObservers  ();
}

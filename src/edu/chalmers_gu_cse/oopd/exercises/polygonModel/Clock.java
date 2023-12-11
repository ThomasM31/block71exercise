package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

import java.util.ArrayList;

public class Clock {
    private ArrayList<ModelUpdateListener> listeners = new ArrayList<>();

    // TODO 1: Observer Pattern: Put the clock in a separate class, and let
    //  PolygonModel have, and start, such a clock. Make the clock observable,
    //  and let this animator be an observer so that update is called on
    //  each tick.

    public void animate(){
        boolean running = true;
        while (running) {
            try {
                Thread.sleep(500);
                notifyObservers();
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    void addListener(ModelUpdateListener listener) {
        listeners.add(listener);
    }

    void removeListener(ModelUpdateListener listener) {
        listeners.remove(listener);
    }

    void notifyObservers() {
        for (ModelUpdateListener l : listeners) {
            l.actOnModelUpdate();
        }
    }
}

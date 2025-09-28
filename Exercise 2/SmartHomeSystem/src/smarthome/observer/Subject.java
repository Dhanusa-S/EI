package smarthome.observer;

import smarthome.devices.SmartDevice;

public interface Subject {
    void registerObserver(SmartDevice device);
    void removeObserver(SmartDevice device);
    void notifyObservers();
}

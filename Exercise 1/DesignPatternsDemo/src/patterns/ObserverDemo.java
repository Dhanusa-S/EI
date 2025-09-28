package patterns;

import java.util.*;

// Subject
interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}

// Observer
interface Observer {
    void update(int temperature);
}

// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void register(Observer o) { observers.add(o); }
    public void unregister(Observer o) { observers.remove(o); }
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}

// Concrete Observers
class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone Display: Current temperature is " + temperature + "°C");
    }
}

class TVDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("TV Display: Weather is now " + temperature + "°C");
    }
}

// Client
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer phone = new PhoneDisplay();
        Observer tv = new TVDisplay();

        station.register(phone);
        station.register(tv);

        station.setTemperature(30);
        station.setTemperature(25);
    }
}

package smarthome;

import smarthome.devices.SmartDevice;
import smarthome.observer.Subject;
import java.util.*;

public class SmartHomeSystem implements Subject {
    private List<SmartDevice> devices = new ArrayList<>();

    @Override
    public void registerObserver(SmartDevice device) { devices.add(device); }

    @Override
    public void removeObserver(SmartDevice device) { devices.remove(device); }

    @Override
    public void notifyObservers() {
        for (SmartDevice d : devices) d.update();
    }

    public void executeCommand(String command) {
        try {
            String[] parts = command.replace(")", "").split("\\(");
            String action = parts[0];
            int id = Integer.parseInt(parts[1]);

            for (SmartDevice d : devices) {
                if (d.getId() == id) {
                    switch(action) {
                        case "turnOn": d.turnOn(); break;
                        case "turnOff": d.turnOff(); break;
                    }
                }
            }
            notifyObservers();
        } catch(Exception e) {
            System.out.println("Invalid command. Format: turnOn(id) or turnOff(id)");
        }
    }

    public void showStatus() {
        System.out.println("\n=== Smart Home Status ===");
        for (SmartDevice d : devices) System.out.println(d.getStatus());
        System.out.println("========================\n");
    }
}

package smarthome.triggers;

import smarthome.devices.SmartDevice;
import java.util.*;

public class TriggerManager {
    private List<String> triggers = new ArrayList<>();

    public void addTrigger(String condition, String action) {
        triggers.add("If " + condition + " then " + action);
        System.out.println("Trigger added: If " + condition + " then " + action);
    }

    public void evaluateTriggers(int temperature, SmartDevice light) {
        for(String t : triggers) {
            if(t.contains("temperature > " + temperature)) {
                System.out.println("Trigger activated: " + t);
                light.turnOff();
            }
        }
    }
}

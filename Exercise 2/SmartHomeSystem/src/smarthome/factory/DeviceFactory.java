package smarthome.factory;

import smarthome.devices.*;

public class DeviceFactory {
    public static SmartDevice createDevice(String type, int id) {
        switch(type.toLowerCase()) {
            case "light": return new Light(id);
            case "thermostat": return new Thermostat(id);
            case "door": return new DoorLock(id);
            default: throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}

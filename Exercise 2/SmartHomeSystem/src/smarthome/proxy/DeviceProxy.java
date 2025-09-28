package smarthome.proxy;

import smarthome.devices.SmartDevice;

public class DeviceProxy extends SmartDevice {
    private SmartDevice realDevice;

    public DeviceProxy(SmartDevice device) {
        super(device.getId());
        this.realDevice = device;
    }

    @Override
    public void turnOn() {
        System.out.println("Proxy: Access granted to turn on device " + id);
        realDevice.turnOn();
    }

    @Override
    public void turnOff() { realDevice.turnOff(); }
    @Override public void update() { realDevice.update(); }
    @Override public String getStatus() { return realDevice.getStatus(); }
}

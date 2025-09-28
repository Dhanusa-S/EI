package smarthome.devices;

public abstract class SmartDevice {
    protected int id;
    protected String status;

    public SmartDevice(int id) {
        this.id = id;
    }

    public int getId() { return id; }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void update();
    public abstract String getStatus();
}

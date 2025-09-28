package smarthome.devices;

public class Light extends SmartDevice {
    public Light(int id) { super(id); this.status = "off"; }

    @Override
    public void turnOn() { status = "on"; System.out.println("Light " + id + " is ON"); }
    @Override
    public void turnOff() { status = "off"; System.out.println("Light " + id + " is OFF"); }
    @Override
    public void update() {}
    @Override
    public String getStatus() { return "Light " + id + " is " + status; }
}

package smarthome.devices;

public class DoorLock extends SmartDevice {
    public DoorLock(int id) { super(id); this.status = "locked"; }

    @Override public void turnOn() { status = "unlocked"; System.out.println("Door " + id + " UNLOCKED"); }
    @Override public void turnOff() { status = "locked"; System.out.println("Door " + id + " LOCKED"); }
    @Override public void update() {}
    @Override public String getStatus() { return "Door " + id + " is " + status; }
}

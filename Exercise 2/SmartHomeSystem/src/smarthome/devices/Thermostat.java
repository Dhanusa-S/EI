package smarthome.devices;

public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id) { super(id); temperature = 70; }

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Thermostat " + id + " set to " + temperature + "°F");
    }

    public int getTemperature() { return temperature; }

    @Override public void turnOn() { System.out.println("Thermostat " + id + " ON"); }
    @Override public void turnOff() { System.out.println("Thermostat " + id + " OFF"); }
    @Override public void update() {}
    @Override public String getStatus() { return "Thermostat " + id + " is " + temperature + "°F"; }
}

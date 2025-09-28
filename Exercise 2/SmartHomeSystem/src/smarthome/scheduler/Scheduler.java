package smarthome.scheduler;

import smarthome.devices.SmartDevice;
import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
    private Timer timer = new Timer();

    public void schedule(SmartDevice device, long delayMillis, String action) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(action.equalsIgnoreCase("turnOn")) device.turnOn();
                else if(action.equalsIgnoreCase("turnOff")) device.turnOff();
                System.out.println("Scheduled action executed: " + device.getStatus());
            }
        }, delayMillis);
    }
}

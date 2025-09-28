package smarthome;

import smarthome.devices.*;
import smarthome.factory.DeviceFactory;
import smarthome.proxy.DeviceProxy;
import smarthome.scheduler.Scheduler;
import smarthome.triggers.TriggerManager;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartHomeSystem system = new SmartHomeSystem();
        Scheduler scheduler = new Scheduler();
        TriggerManager triggerManager = new TriggerManager();
        Map<Integer, SmartDevice> deviceMap = new HashMap<>();

        System.out.println("=== Initialize Devices ===");
        System.out.print("Enter number of devices: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            System.out.print("Enter device type (light/thermostat/door) and id: ");
            String[] input = sc.nextLine().split(" ");
            String type = input[0];
            int id = Integer.parseInt(input[1]);

            SmartDevice device = DeviceFactory.createDevice(type, id);
            device = new DeviceProxy(device); // wrap in proxy
            deviceMap.put(id, device);
            system.registerObserver(device);
        }

        while(true){
            System.out.println("\n--- Smart Home Menu ---");
            System.out.println("1. Turn On Device");
            System.out.println("2. Turn Off Device");
            System.out.println("3. Set Temperature (Thermostat)");
            System.out.println("4. Schedule Device");
            System.out.println("5. Add Trigger");
            System.out.println("6. Show Status");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter device id to turn ON: ");
                    int onId = sc.nextInt(); sc.nextLine();
                    system.executeCommand("turnOn(" + onId + ")");
                    break;
                case 2:
                    System.out.print("Enter device id to turn OFF: ");
                    int offId = sc.nextInt(); sc.nextLine();
                    system.executeCommand("turnOff(" + offId + ")");
                    break;
                case 3:
                    System.out.print("Enter thermostat id: ");
                    int tId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter temperature: ");
                    int temp = sc.nextInt(); sc.nextLine();
                    SmartDevice t = deviceMap.get(tId);
                    if(t instanceof Thermostat){
                        ((Thermostat)t).setTemperature(temp);
                        triggerManager.evaluateTriggers(temp, deviceMap.get(1)); // light1 for example
                    } else System.out.println("Invalid thermostat id");
                    break;
                case 4:
                    System.out.print("Enter device id to schedule: ");
                    int sId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter delay in seconds: ");
                    long delay = sc.nextInt() * 1000; sc.nextLine();
                    System.out.print("Enter action (turnOn/turnOff): ");
                    String action = sc.nextLine();
                    scheduler.schedule(deviceMap.get(sId), delay, action);
                    break;
                case 5:
                    System.out.print("Enter trigger condition (example: temperature > 75): ");
                    String cond = sc.nextLine();
                    System.out.print("Enter trigger action (example: turnOff(1)): ");
                    String act = sc.nextLine();
                    triggerManager.addTrigger(cond, act);
                    break;
                case 6:
                    system.showStatus();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
            }
        }
    }
}

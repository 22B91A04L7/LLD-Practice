import java.util.*;

// separate interface for switchable devices --> follows ISP
interface Switchable {
    void turnOn();

    void turnOff();
}
// separate interface for music capable devices --> follows ISP

interface MusicCapable extends Switchable {
    void playMusic();
}
// separate interface for recordable devices --> follows ISP

interface Recordable extends Switchable {
    void recordVideo();
}

// can be substitue for Switchable -- follows LSP
class SmartBulb implements Switchable {
    public void turnOn() {
        System.out.println("Bulb turned ON !!!");
    }

    public void turnOff() {
        System.out.println("Bulb turned OFF !!!");
    }
}

// can be substitue for MusicCapable -- follows LSP

class SmartSpeaker implements MusicCapable {
    public void turnOn() {
        System.out.println("Speaker turned ON !!!");
    }

    public void turnOff() {
        System.out.println("Speaker turned OFF !!!");
    }

    public void playMusic() {
        System.out.println("Playing Music ..!!!!");
    }
}

// can be substitue for Recordable -- follows LSP

class SecurityCamera implements Recordable {
    public void turnOn() {
        System.out.println("Camera turned ON !!!");
    }

    public void turnOff() {
        System.out.println("Camera turned OFF !!!");
    }

    public void recordVideo() {
        System.out.println("Recording Video !!!!");
    }

}

class HomeController {
    private Switchable device;

    // here Switchable is the abstaction layer
    public HomeController(Switchable device) {
        this.device = device;
    }

    public void turnDeviceOn() {
        device.turnOn();
    }

    public void turnDeviceOff() {
        device.turnOff();
    }

}

public class Smart_Home {
    public static void main(String args[]) {
        HomeController controller1 = new HomeController(new SmartBulb());
        HomeController controller2 = new HomeController(new SmartSpeaker());
        HomeController controller3 = new HomeController(new SecurityCamera());
        controller1.turnDeviceOn();
        controller1.turnDeviceOff();

        controller2.turnDeviceOn();
        controller2.turnDeviceOff();

        controller3.turnDeviceOn();
        controller3.turnDeviceOff();
    }
}

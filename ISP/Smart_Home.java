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

class Client {
    public void processSwitchable(List<Switchable> list) {
        for (Switchable device : list) {
            device.turnOn();
            device.turnOff();
        }
    }

    public void processMusicCapable(List<MusicCapable> list) {
        for (MusicCapable device : list) {
            device.turnOn();
            device.playMusic();
            device.turnOff();

        }
    }

    public void processRecordable(List<Recordable> list) {
        for (Recordable device : list) {
            device.turnOn();
            device.recordVideo();
            device.turnOff();

        }
    }
}

public class Smart_Home {
    public static void main(String args[]) {
        Switchable bulb = new SmartBulb();
        MusicCapable player = new SmartSpeaker();
        Recordable camera = new SecurityCamera();

        List<Switchable> switchableDevices = new ArrayList<>();
        switchableDevices.add(bulb);
        switchableDevices.add(camera);
        switchableDevices.add(player);

        List<MusicCapable> musicCapableDevices = new ArrayList<>();
        musicCapableDevices.add(player);

        List<Recordable> recordableDevices = new ArrayList<>();
        recordableDevices.add(camera);

        Client client = new Client();
        client.processSwitchable(switchableDevices);
        client.processMusicCapable(musicCapableDevices);
        client.processRecordable(recordableDevices);
    }
}

import java.util.*;

class Person {
    private String name;
    private String number;
    private String mailID;

    public Person(String name, String number, String mailID) {
        this.name = name;
        this.number = number;
        this.mailID = mailID;
    }

    public String getNumber() {
        return number;
    }

    public String getMailID() {
        return mailID;
    }
}

interface NotificationSystem {
    void notifyUser(Person person);
}

class SMSNotification implements NotificationSystem {
    public void notifyUser(Person person) {
        String number = person.getNumber();
        System.out.println("SMS Sent to : " + number);
    }
}

class EmailNotification implements NotificationSystem {
    public void notifyUser(Person person) {
        String mailId = person.getMailID();
        System.out.println("Email sent to : " + mailId);
    }
}

public class Notification_System {
    public static void main(String args[]) {

        Person p1 = new Person("Venkat", "9959886566", "thevenkat886@gmail.com");
        Person p2 = new Person("Veera", "9959564326", "veera24@gmail.com");

        NotificationSystem sms = new SMSNotification();
        NotificationSystem email = new EmailNotification();

        sms.notifyUser(p1);
        email.notifyUser(p2);
    }
}

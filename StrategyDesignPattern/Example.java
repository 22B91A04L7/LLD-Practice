//strategy for Talkable
interface Talkable {
    void talk();
}

class NormalTalk implements Talkable {

    public void talk() {
        System.out.println("Talking normally ...!");
    }
}

class NoTalk implements Talkable {
    public void talk() {
        System.out.println("Cannot Talk ..!!");
    }
}

// strategy for walkable robots
interface Walkable {
    void walk();
}

class NormalWalk implements Walkable {

    public void walk() {
        System.out.println("Walking Normally ...!!");
    }
}

class NoWalk implements Walkable {
    public void walk() {
        System.out.println("Cannot Walk ...!!");
    }
}

class SlowWalk implements Walkable {

    public void walk() {
        System.out.println("Walking slowly ...!!");
    }
}

// strategy for flyable
interface Flyable {
    void fly();
}

class WingFly implements Flyable {

    public void fly() {
        System.out.println("Flying with wings ..!!");
    }
}

class JetFly implements Flyable {

    public void fly() {
        System.out.println("Flying as Jet ..!!");
    }
}

abstract class Robot {
    Walkable walkingStrategy;
    Talkable talkingStrategy;
    Flyable flyingStrategy;

    public Robot(Walkable w, Talkable t, Flyable f) {
        walkingStrategy = w;
        talkingStrategy = t;
        flyingStrategy = f;
    }

    public void walk() {
        walkingStrategy.walk();
    }

    public void talk() {
        talkingStrategy.talk();
    }

    public void fly() {
        flyingStrategy.fly();
    }

    public void setRobotWalkingStrategy(Walkable w) {
        walkingStrategy = w;
    }

    public void setTalkStrategy(Talkable talkStrategy) {
        this.talkingStrategy = talkStrategy;
    }

    public void setFlyStrategy(Flyable flyStrategy) {
        this.flyingStrategy = flyStrategy;
    }

    // abstract menthod --> mandatory for every robot --> but different way
    public abstract void projection();

}

class CompanionRobot extends Robot {
    public CompanionRobot(Walkable w, Talkable t, Flyable f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying friendly features..!!!");
    }
}

class WorkerRobot extends Robot {
    public WorkerRobot(Walkable w, Talkable t, Flyable f) {
        super(w, t, f);
    }

    public void projection() {
        System.out.println("Displaying work features..!!!");
    }
}

public class Example {
    public static void main(String args[]) {
        Robot r1 = new CompanionRobot(
                new NormalWalk(),
                new NormalTalk(),
                new WingFly());
        r1.talk();
        r1.walk();
        r1.fly();

        Robot r2 = new WorkerRobot(new NoWalk(),
                new NoTalk(),
                new JetFly());
        r2.talk();
        r2.walk();
        r2.fly();
        r2.setRobotWalkingStrategy(new SlowWalk());
        r2.walk();
    }
}
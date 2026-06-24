import java.util.*;

interface NonWithDrawableAC {
    void deposit(int money);
}

interface WithDrawableAC extends NonWithDrawableAC {
    void withdraw(int money);
}

class SavingsAC implements WithDrawableAC {
    int balance;

    public SavingsAC() {
        balance = 0;
    }

    public void deposit(int money) {
        balance += money;
        System.out.println(money + " successfully deposited to Savings A/c");
    }

    public void withdraw(int money) {
        if (money <= balance) {
            balance -= money;
            System.out.println(money + " debited from Savings A/c");
        } else {
            System.out.println("Insuffient Fund ....");
        }
    }
}

class CurrentAC implements WithDrawableAC {
    int balance;

    public CurrentAC() {
        balance = 0;
    }

    public void deposit(int money) {
        balance += money;
        System.out.println(money + " successfully deposited to Current A/c");
    }

    public void withdraw(int money) {
        if (money <= balance) {
            balance -= money;
            System.out.println(money + " successfully debited from Current A/c");
        } else {
            System.out.println("Insuffient Fund ....");
        }
    }
}

class FixedDeposit implements NonWithDrawableAC {
    int balance;

    public FixedDeposit() {
        int balance = 0;
    }

    public void deposit(int money) {
        balance += money;
        System.out.println(money + " successfully deposited to Fixed Deposit A/c");
    }
}

class Client {
    public void processWithDrawTransaction(List<WithDrawableAC> list) {
        for (WithDrawableAC ac : list) {
            ac.deposit(500);
            ac.withdraw(200);
        }
    }

    public void processNonWithDrawTransaction(List<NonWithDrawableAC> list) {
        for (NonWithDrawableAC ac : list) {
            ac.deposit(500);
        }
    }
}

public class lsp_followed {
    public static void main(String args[]) {
        ArrayList<WithDrawableAC> withDrawList = new ArrayList<>();
        withDrawList.add(new SavingsAC());
        withDrawList.add(new CurrentAC());

        ArrayList<NonWithDrawableAC> nonWithDrawList = new ArrayList<>();
        nonWithDrawList.add(new FixedDeposit());

        Client client = new Client();
        client.processWithDrawTransaction(withDrawList);
        client.processNonWithDrawTransaction(nonWithDrawList);

    }
}

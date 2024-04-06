import java.util.List;
import java.util.Scanner;

public class Worker {

    final private Scanner in;
    private String value = "";

    public Worker(Scanner in) {
        this.in = in;
    }

    void startWork() {
        System.out.println("Enter the command");

        while (!value.equals("exit")) {
            value = in.nextLine().toLowerCase();
            if (Utils.command.containsKey(value)) {
                facade();
            } else {
                System.out.println("Command " + value + " is not correct. Try again or enter \"help\"");
            }
        }
    }

    void facade() {
        switch (value) {
            case "help" : {
                System.out.println(Utils.getCommandInfo());
                break;
            }
            case "get" : {
                System.out.println(Utils.getStudents());
                break;
            }
            case "student" : {
                studentGrate();
                break;
            }
            case "set" : {
                setGrate();
                break;
            }
        }
    }

    public void studentGrate() {
        System.out.println("Enter name");
        value = in.nextLine();
        if (Utils.students.containsKey(value)) {
            System.out.println(Utils.getStudent(value));
        } else {
            System.out.println("Name " + value + " is not exist");
        }
    }

    public void setGrate() {
        System.out.println("Enter name agd grate");

        value = in.nextLine();
        String[] split = value.split(" ");

        if(split.length == 1) {
            System.out.println("Is not correct");
            return;
        }

        String name = split[0];
        Integer grate = Integer.parseInt(split[1]);

        if (Utils.students.containsKey(name)) {
            if (grate > 5 || grate < 1 ) {
                System.out.println("Grate mast be between 1 and 5. Grate has not added");
            } else {
                List<Integer> integers = Utils.students.get(name);
                integers.add(grate);
                System.out.println("Grate has added");
            }
        } else {
            System.out.println("Name " + name + " is not exist. Grate has not added");
        }
    }


}

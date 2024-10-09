package Project_7;

import java.util.Scanner;

public class Streaming extends Subscription implements ICREATE,IUPDATE,ICANCEL,ISTATUS,IREMOVE {
    private String name;
    private int deviceLimit;
    private String plan;

    public Streaming(String startDate, String endDate, String status, String name, int deviceLimit, String plan) {
        super(startDate, endDate, status);
        this.name = name;
        this.deviceLimit = deviceLimit;
        this.plan = plan;
    }

    public Streaming() {

    }

    @Override
    public void create(DataBase database, Scanner read) {
       System.out.println("Creating a new streaming subscription");
        System.out.print("Enter streaming name: ");
        String name = read.nextLine();
        System.out.print("Enter device limit: ");
        int deviceLimit = read.nextInt();
        read.nextLine();
        System.out.print("Enter plan (Solo, Family, etc.): ");
        String plan = read.nextLine();

        String startDate = ErrorHandling.getValidDate(read, "Enter start date (yyyy-MM-dd): ");
        String endDate = ErrorHandling.getValidDate(read, "Enter end date (yyyy-MM-dd): ");

        Streaming streaming = new Streaming(startDate, endDate, "Active", name, deviceLimit, plan);
        database.addStreaming(streaming);
        System.out.println("Added Streaming Site to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    @Override
    public void update(DataBase database, Scanner read) {
        System.out.println("Updating the streaming subscription");
        System.out.print("Enter streaming name: ");
        String name = read.nextLine();
        System.out.print("Enter new device limit: ");
        int deviceLimit = read.nextInt();
        read.nextLine();
        System.out.print("Enter new plan (Solo, Family, etc.): ");
        String plan = read.nextLine();

        String startDate = ErrorHandling.getValidDate(read, "Enter new start date (yyyy-MM-dd): ");
        String endDate = ErrorHandling.getValidDate(read, "Enter new end date (yyyy-MM-dd): ");

        Streaming streaming = new Streaming(startDate, endDate, "Active", name, deviceLimit, plan);
        database.updateStreaming(streaming, 0);
        System.out.println("Updated the Chosen Streaming Site!!");
        System.out.println("==========================================================================================================");
    }

    @Override
    public void cancel(DataBase database, Scanner read) {
        System.out.println("Canceling the streaming subscription");
        System.out.println("Enter streaming site name (Example Netflix):");
        String name = read.nextLine();
        Streaming streaming = new Streaming("Cancelled", "Cancelled", "Cancelled", name, 0, "Cancelled");
        database.updateStreaming(streaming, 0);
        System.out.println("Cancelled the chosen Streaming Site!!");
        System.out.println("==========================================================================================================");

    }


    @Override
    public void status(DataBase database, Scanner scanner) {
        System.out.println("Showing the status of the streaming subscription");
        System.out.println("Enter streaming name (Example Netflix):"); String name = scanner.nextLine();
        for (Streaming streaming : database.getAllStreamings()) {
            if (streaming.getName().equals(name)) {
                System.out.println("The Magazine:  " +streaming.getName() +" is" + " " + streaming.getStatus());
                return;
            }
        }
        System.out.println("Streaming subscription not found.");
    }

    @Override
    public void remove(DataBase database, Scanner read) {
        System.out.println("Removing the streaming subscription");
        System.out.print("Enter streaming name:");
        String name = read.nextLine();
        Streaming streaming = database.searchStreaming(name);
        if (streaming != null) {
            database.removeStreaming(streaming);
            System.out.println("Streaming subscription removed successfully.");
        } else {
            System.out.println("Streaming subscription not found.");
        }
    }

    public String getName() {
        return name;
    }
    public int getDeviceLimit() {
        return deviceLimit;
    }
    public String getPlan() {
        return plan;
    }
}
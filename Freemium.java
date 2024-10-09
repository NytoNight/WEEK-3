package Project_7;

import java.util.Scanner;

public class Freemium extends Subscription implements ICREATE,IUPDATE,ICANCEL,ISTATUS,IREMOVE {
    private String name;
    private int trialPeriod;

    public Freemium(String name, String startDate, String endDate, String status, int trialPeriod) {
        super(startDate, endDate, status);
        this.name = name;
        this.trialPeriod = trialPeriod;
    }

    public Freemium() {

    }


    @Override
    public void create(DataBase database, Scanner read) {
        System.out.println("Creating a new freemium subscription");
        System.out.print("Enter the name of the freemium site: ");
        String name = read.nextLine();
        System.out.print("Enter the amount of trial days (example: 50 Days): ");
        int trialPeriod = read.nextInt();
        read.nextLine();
        String startDate = ErrorHandling.getValidDate(read, "Enter start date (yyyy-MM-dd): ");
        String endDate = ErrorHandling.getValidDate(read, "Enter end date (yyyy-MM-dd): ");
        Freemium freemium = new Freemium(name, startDate, endDate, "Active", trialPeriod);
        database.addFreemium(freemium);
        System.out.println("Added Freemium Site to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    @Override
    public void update(DataBase database, Scanner read) {
        System.out.println("Updating the freemium subscription...");
        System.out.print("Enter the name of the freemium site: ");
        String name = read.nextLine();
        System.out.print("Enter the updated trial days (example: 50 Days): ");
        int trialPeriod = read.nextInt();
        read.nextLine();
        String startDate = ErrorHandling.getValidDate(read, "Enter new start date (yyyy-MM-dd): ");
        String endDate = ErrorHandling.getValidDate(read, "Enter new end date (yyyy-MM-dd): ");
        Freemium freemium = new Freemium(name, startDate, endDate, "Active", trialPeriod);
        database.updateFreemium(freemium, 0);
        System.out.println("Updated the Freemium Account!!");
        System.out.println("==========================================================================================================");
    }

    @Override
    public void cancel(DataBase database, Scanner scanner) {
        System.out.println("Canceling the freemium subscription...");
        System.out.print("Enter the name of the freemium site:");
        String name = scanner.nextLine();
        System.out.println("Enter trial period (in days):");
        int trialPeriod = scanner.nextInt();
        scanner.nextLine();
        Freemium freemium = new Freemium(name, "Cancelled", "Cancelled", "Cancelled", trialPeriod);
        database.updateFreemium(freemium, 0);
        System.out.println("Cancelled the chosen Freemium Account!!");
        System.out.println("==========================================================================================================");
    }



    @Override
    public void status(DataBase database, Scanner read) {
        System.out.println("Showing the status of the freemium subscription...");
        System.out.print("Enter the name of the freemium site:");
        String name = read.nextLine();
        System.out.print("Enter trial period (example: 50):");
        int trialPeriod = read.nextInt();
        read.nextLine();
        for (Freemium freemium : database.getAllFreemiums()) {
            if (freemium.getName().equals(name) && freemium.getTrialPeriod() == trialPeriod) {
                System.out.println(" The Current status for the Freemium Account: " + freemium.getName() + " with " + freemium.getTrialPeriod() + " Days" + " and is " + " " + freemium.getStatus());
                return;
            }
        }
        System.out.println("Freemium subscription not found.");
    }

    @Override
    public void remove(DataBase database, Scanner read) {
        System.out.println("Removing the freemium subscription");
        System.out.print("Enter freemium name:");
        String name = read.nextLine();
        Freemium freemium = database.searchFreemium(name);
        if (freemium != null) {
            database.removeFreemium(freemium);
            System.out.println("Freemium subscription removed successfully.");
        } else {
            System.out.println("Freemium subscription not found.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrialPeriod() {
        return trialPeriod;
    }

    public void setTrialPeriod(int trialPeriod) {
        this.trialPeriod = trialPeriod;
    }
}
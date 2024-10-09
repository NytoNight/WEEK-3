package Project_7;

import java.util.Scanner;

public class Magazine extends Subscription implements ICREATE,IUPDATE,ICANCEL,ISTATUS,IREMOVE {
    private String name;
    private String deliveryType;
    private String startDate;
    private String endDate;
    private String status;

    public Magazine(String startDate, String endDate, String status, String name, String deliveryType) {
        super(startDate, endDate, status);
        this.name = name;
        this.deliveryType = deliveryType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Magazine() {

    }


    @Override
    public void create(DataBase database, Scanner read)
    {
        System.out.println("Creating a new magazine subscription");
        System.out.print("Enter magazine name: ");
        String name = read.nextLine();
        System.out.print("Enter delivery type (Online, Physical): ");
        String deliveryType = read.nextLine();

        String startDate = ErrorHandling.getValidDate(read, "Enter start date (yyyy-MM-dd): ");
        String endDate =   ErrorHandling.getValidDate(read, "Enter end date (yyyy-MM-dd): ");

        Magazine magazine = new Magazine(startDate, endDate, "Active", name, deliveryType);
        database.add_magazine(magazine);
        System.out.println("Added magazine to your subscriptions!!");
        System.out.println("==========================================================================================================");
    }

    @Override
    public void update(DataBase database, Scanner read)
    {
        System.out.println("Updating the magazine subscription");
        System.out.print("Enter magazine name: ");
        String name = read.nextLine();
        System.out.print("Enter new delivery type (Online, Physical): ");
        String deliveryType = read.nextLine();
        String startDate = ErrorHandling.getValidDate(read, "Enter new start date (yyyy-MM-dd): ");
        String endDate =   ErrorHandling.getValidDate(read, "Enter new end date (yyyy-MM-dd): ");
        Magazine magazine = new Magazine(startDate, endDate, "Active", name, deliveryType);
        database.updateMagazine(magazine, 0);
        System.out.println("Updated the Magazine!!");
        System.out.println("==========================================================================================================");
    }

    @Override
    public void cancel(DataBase database, Scanner read)
    {
        System.out.println("Canceling the magazine subscription");
        System.out.print("Enter magazine name:");
        String name = read.nextLine();
        System.out.println("Cancelled the chosen Magazine!!");
        System.out.println("==========================================================================================================");
        Magazine magazine = new Magazine("Cancelled", "Cancelled", "Cancelled", name, "Cancelled");
        database.updateMagazine(magazine, 0);
    }



    @Override
    public void status(DataBase database, Scanner read)
    {
        System.out.println("Showing the status of the magazine subscription");
        System.out.print("Enter magazine name:");
        String name = read.nextLine();
        for (Magazine magazine : database.getAllMagazines()) {
            if (magazine.getName().equals(name)) {
                System.out.println("The Magazine:  " +magazine.getName() +" is" + " " + magazine.getStatus());
                return;
            }
        }
        System.out.println("Magazine subscription not found.");

    }

    @Override
    public void remove(DataBase database, Scanner read) {
        System.out.println("Removing the magazine subscription");
        System.out.print("Enter magazine name:");
        String name = read.nextLine();
        Magazine magazine = database.searchMagazine(name);
        if (magazine != null) {
            database.removeMagazine(magazine);
            System.out.println("Magazine subscription removed successfully.");
        } else {
            System.out.println("Magazine subscription not found.");
        }
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDeliveryType()
    {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType)
    {
        this.deliveryType = deliveryType;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
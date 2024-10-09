package Project_7;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase database = new DataBase();
        Magazine magazine = new Magazine();
        Freemium free = new Freemium();
        Streaming stream = new Streaming();
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("Project 7: Subscription Management System");
            System.out.println("Select the Number corresponding to the option you wish to do today!!");
            System.out.println("[1] Create a new subscription");
            System.out.println("[2] Update an existing subscription");
            System.out.println("[3] Cancel a subscription");
            System.out.println("[4] View all subscriptions");
            System.out.println("[5] View Status of a Subscription");
            System.out.println("[6] Search Subscription");
            System.out.println("[7] Filter Subscription");
            System.out.println("[8] Remove a Subscription");
            System.out.println("[9] End the program");
            System.out.print("Enter your choice:  ");
            try {
                int choice = read.nextInt(); read.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Creating a new subscription!!");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        int Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.create(database, read);
                        } else if (Choice == 2) {
                            stream.create(database, read);
                        } else if (Choice == 3) {
                            free.create(database, read);
                        } else {
                            System.out.println("Invalid subscription type. Please try again.");
                        }
                        break;
                    case 2:
                        System.out.println("Updating a subscription:");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.update(database, read);
                        } else if (Choice == 2) {
                            stream.update(database, read);
                        } else if (Choice == 3) {
                            free.update(database, read);
                        } else {
                            System.out.println("Could not find that Subscription, Please try again.");
                        }
                        break;
                    case 3:
                        System.out.println("Canceling a subscription:");
                        System.out.print("Enter subscription type which you want to cancel ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.cancel(database, read);
                        } else if (Choice == 2) {
                            stream.cancel(database, read);
                        } else if (Choice == 3) {
                            free.cancel(database, read);
                        } else {
                            System.out.println("Invalid subscription type. Please try again.");
                        }
                        break;
                    case 4:
                        System.out.println("View all subscriptions:");
                        database.viewAllSubscriptions();
                        break;
                    case 5:
                        System.out.println("Viewing subscription Status:");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        Choice = read.nextInt(); read.nextLine();
                        if (Choice == 1) {
                            magazine.status(database, read);
                        } else if (Choice == 2) {
                            stream.status(database, read);
                        } else if (Choice == 3) {
                            free.status(database, read);
                        } else {
                            System.out.println("Invalid subscription type. Please try again.");
                        }
                        break;
                    case 6:
                        System.out.println("Searching for a subscription:");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        int option = read.nextInt();  read.nextLine();
                        if (option == 1) {
                            System.out.print("Enter magazine name: ");
                            String name = read.nextLine();
                            Magazine foundMagazine = database.searchMagazine(name);
                            if (foundMagazine != null) {
                                System.out.println("Magazine found: " + foundMagazine.getName());
                            } else {
                                System.out.println("Magazine Subscription not found.");
                            }
                        } else if (option == 2) {
                            System.out.print("Enter streaming name: ");
                            String name = read.nextLine();
                            Streaming foundStreaming = database.searchStreaming(name);
                            if (foundStreaming != null) {
                                System.out.println("Streaming found: " + foundStreaming.getName());
                            } else {
                                System.out.println("Streaming Subscription not found.");
                            }
                        } else if (option == 3) {
                            System.out.print("Enter freemium Subscription name: ");
                            String name = read.nextLine();
                            Freemium foundFreemium = database.searchFreemium(name);
                            if (foundFreemium != null) {
                                System.out.println("Freemium found: " + foundFreemium.getName());
                            } else {
                                System.out.println("Freemium subscription not found");
                            }
                        } else {
                            System.out.println("Invalid Choice, Please Try Again");
                        }
                        break;
                    case 7:
                    System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                    int option2 = read.nextInt();  read.nextLine();
                    System.out.println("Enter Status [active] or  [cancelled]: ");
                    String status = read.nextLine(); 
                    if (option2 == 1) {
                        List<Magazine> filterMagazines = database.filterMagazines(status);
                        if (filterMagazines.isEmpty()){
                            System.out.println("No magazines found with the given status: " + status);
                        } else {
                            System.out.println("Filtered Magazines:");
                            for (Magazine mag : filterMagazines) {
                                System.out.println("Magazine: " + mag.getName());
                        }
                    }
                    } else if (option2 == 2) {
                        List<Streaming> filterStream = database.filterStreaming(status);
                        if (filterStream.isEmpty()){
                            System.out.println("No Streamings found with the given status: " + status);
                        } else {
                            System.out.println("Filtered Streamings:");
                            for (Streaming site : filterStream) {
                                System.out.println("Streaming: " + site.getName());
                        }
                    }
                    } else if (option2 == 3) {
                        List<Freemium> filterFreemiums = database.filterFreemiums(status);
                        if (filterFreemiums.isEmpty()){
                            System.out.println("No Freemium found with the given status: " + status);
                        } else {
                            System.out.println("Filtered Freemium:");
                            for (Freemium freem : filterFreemiums) {
                                System.out.println("Freemium: " + freem.getName());
                        }
                    }
                    } else {
                        System.out.println("Invalid subscription type. Please try again.");
                    }
                    break;
                    case 8:
                        System.out.println("Removing a subscription:");
                        System.out.print("Enter subscription type ( [1]: Magazine, [2]: Streaming, [3]: Freemium): ");
                        int option3 = read.nextInt();  read.nextLine();
                        if (option3 == 1) {
                            magazine.remove(database, read);
                        } else if (option3 == 2) {
                            stream.remove(database, read);
                        } else if (option3 == 3) {
                            free.remove(database, read);
                        } else {
                            System.out.println("Invalid Choice, Please Try Again");
                        }
                        break;
                    case 9:
                        System.out.println("Closing System, Thank you for using our Subscription Management System!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException choice) {
                System.out.println("Invalid Choice, Please select a choice given on the Prompt"); read.next();
            }
        }
    }
}
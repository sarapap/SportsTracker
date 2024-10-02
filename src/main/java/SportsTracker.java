import java.util.ArrayList;
import java.util.Scanner;

public class SportsTracker {
    static class Activity {
        String name;
        int duration;

        Activity(String name, int duration) {
            this.name = name;
            this.duration = duration;
        }
    }

    private ArrayList<Activity> activities = new ArrayList<>();

    private void logActivity(String name, int duration) {
        activities.add(new Activity(name, duration));
        System.out.println("Activity logged: " + name + " for " + duration + " minutes.");
    }

    private void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            System.out.println("Logged Activities:");
            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                System.out.println((i + 1) + ". " + activity.name + " - " + activity.duration + " minutes");
            }
        }
    }

    private void totalTime() {
        int totalMinutes = 0;
        for (Activity activity : activities) {
            totalMinutes += activity.duration;
        }
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        System.out.println("Total time spent this week: " + hours + " hours and " + minutes + " minutes.");
    }

    private void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Sports Logger Menu ---");
            System.out.println("1. Log a sports activity");
            System.out.println("2. View logged activities");
            System.out.println("3. Calculate total time spent on sports this week");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the activity name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the duration in minutes: ");
                    int duration = scanner.nextInt();
                    logActivity(name, duration);
                    break;
                case 2:
                    viewActivities();
                    break;
                case 3:
                    totalTime();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting Sports Logger.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        SportsTracker logger = new SportsTracker();
        logger.displayMenu();
    }
}

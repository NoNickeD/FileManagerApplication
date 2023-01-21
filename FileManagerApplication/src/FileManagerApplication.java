import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileManagerApplication {
    // Application name and developer details
    private static final String APP_NAME = "File Manager Application";
    private static final String DEVELOPER = "Nikos Nikolakakis";

    public static void main(String[] args) {
        // Welcome screen
        System.out.println("Welcome to " + APP_NAME + "!");
        System.out.println("Developed by " + DEVELOPER);
        System.out.println("Select an option:");
        System.out.println("1. List current files in ascending order.");
        System.out.println("2. Manage files (add, delete, search).");
        System.out.println("3. Exit.");
        System.out.println();

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option) {
            case 1:
                listFiles();
                break;
            case 2:
                manageFiles();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Invalid option. Please select again.");
                break;
        }

    }

    public static void listFiles() {
        File root = new File(".");
        ArrayList<String> fileNames = new ArrayList<>();
        for (File f : root.listFiles()) {
            if (f.isFile()) {
                fileNames.add(f.getName());
            }
        }
        Collections.sort(fileNames);
        System.out.println("Current files in ascending order: ");
        for (String name : fileNames) {
            System.out.println(name);
        }
        navigateBack();
    }

    public static void manageFiles() {
        System.out.println("Select an option:");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search for a file");
        System.out.println("4. Navigate back to main menu");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option) {
            case 1:
                addFile();
                break;
            case 2:
                deleteFile();
                break;
            case 3:
                searchFile();
                break;
            case 4:
                navigateBack();
                break;
            default:
                System.out.println("Invalid option. Please select again.");
                break;
        }

    }

    public static void addFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = input.nextLine();
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("Error creating file: " + e);
        }
        navigateBack();
    }

    public static void deleteFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = input.nextLine();
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Error deleting file.");
            }
        } else {
            System.out.println("File not found.");
        }
        navigateBack();
    }

    public static void searchFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = input.nextLine();
        File root = new File(".");
        boolean found = false;
        for (File f : root.listFiles()) {
            if (f.isFile()) {
                if (f.getName().equalsIgnoreCase(fileName)) {
                    System.out.println("File found at: " + f.getAbsolutePath());
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("File not found.");
        }
        navigateBack();
    }

    public static void navigateBack() {
        System.out.println("Select an option:");
        System.out.println("1. List current files in ascending order.");
        System.out.println("2. Manage files (add, delete, search).");
        System.out.println("3. Exit.");
        System.out.println();

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option) {
            case 1:
                listFiles();
                break;
            case 2:
                manageFiles();
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Invalid option. Please select again.");
                break;
        }
    }

    public static void exit() {
        System.out.println("Thank you for using " + APP_NAME + ". Exiting now!");
        System.exit(0);
    }
}
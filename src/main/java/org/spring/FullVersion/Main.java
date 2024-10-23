package org.spring.FullVersion;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FamilyService familyService = new FamilyService(new CollectionFamilyDao());
        handleUserInput(scanner, familyService);

    }

    public static void handleUserInput(Scanner scanner, FamilyService familyService) {
        while (true) {
            displayMenu();
            String command = Main.getInput("Enter your choice: ");

            switch (command) {
                case "1":
                    fillWithTestData(familyService);
                    Logger.info("Filled with test data.");
                    break;
                case "2":
                    familyService.displayAllFamilies();
                    Logger.info("Displayed the entire list of families.");
                    break;
                case "3":
                    int greaterThan = getInputInt("Enter the number of people: ");
                    familyService.getFamiliesBiggerThan(greaterThan);
                    break;
                case "4":
                    int lessThan = getInputInt("Enter the number of people: ");
                    familyService.getFamiliesLessThan(lessThan);
                    break;
                case "5":
                    int countNumber = getInputInt("Enter the number of people: ");
                    System.out.println("Number of families: " + familyService.countFamiliesWithMemberNumber(countNumber));
                    break;
                case "6":
                    createNewFamily(scanner, familyService);
                    Logger.info("Created a new family.");
                    break;
                case "7":
                    int id = getInputInt("Enter the family id: ");
                    familyService.deleteFamilyByIndex(id);
                    Logger.info("Deleted a family by ID.");
                    break;
                case "8":
                    editFamilyMenu(scanner, familyService);
                    Logger.info("Edited a family.");
                    break;
                case "9":
                    int age = getInputInt("Enter the age: ");
                    familyService.deleteAllChildrenOlderThen(age);
                    Logger.info("Removed all children over the specified age.");
                    break;
                case "10":
                    familyService.saveFamilies();
                    Logger.info("Saved families to file.");
                    break;
                case "11":
                    familyService.loadFamilies();
                    Logger.info("Loaded families from file.");
                    break;
                case "exit":
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    public static int getInputInt(String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void displayMenu() {
        System.out.println("Available commands:");
        System.out.println("1. Fill with test data");
        System.out.println("2. Display the entire list of families");
        System.out.println("3. Display families where the number of people is greater than specified");
        System.out.println("4. Display families where the number of people is less than specified");
        System.out.println("5. Calculate families with specified number of members");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by ID");
        System.out.println("8. Edit a family");
        System.out.println("9. Remove all children over the specified age");
        System.out.println("10. Save families to file");
        System.out.println("11. Load families from file");
        System.out.println("Type 'exit' to exit");
    }

    private static void fillWithTestData(FamilyService familyService) {

        LocalDate motherBirthDate = LocalDate.of(1991, 3, 3);
        LocalDate fatherBirthDate = LocalDate.of(1990, 12, 10);

        Human mother = new Human("Kate", "Bibo", String.valueOf(motherBirthDate), 95);
        Human father = new Human("Karl", "Bibo", String.valueOf(fatherBirthDate), 90);

        familyService.createNewFamily(mother, father);
        System.out.println("Test data filled.");
    }

    private static void createNewFamily(Scanner scanner, FamilyService familyService) {
        Human father = createFather();
        Human mother = createMother();
        familyService.createNewFamily(mother, father);
        System.out.println("New family created.");
    }

    public static Human createFather() {
        String fatherName = getInput("Enter father's name: ");
        String fatherSurname = getInput("Enter father's surname: ");
        int fatherYear = getInputInt("Enter father's birth year: ");
        int fatherMonth = getInputInt("Enter father's birth month: ");
        int fatherDay = getInputInt("Enter father's birthday: ");
        int fatherIq = getInputInt("Enter father's IQ: ");

        LocalDate fatherBirthDate = LocalDate.of(fatherYear, fatherMonth, fatherDay);
        return new Human(fatherName, fatherSurname, String.valueOf(fatherBirthDate), fatherIq);
    }

    public static Human createMother() {
        String motherName = getInput("Enter mother's name: ");
        String motherSurname = getInput("Enter mother's surname: ");
        int motherYear = getInputInt("Enter mother's birth year: ");
        int motherMonth = getInputInt("Enter mother's birth month: ");
        int motherDay = getInputInt("Enter mother's birthday: ");
        int motherIq = getInputInt("Enter mother's IQ: ");

        LocalDate motherBirthDate = LocalDate.of(motherYear, motherMonth, motherDay);
        return new Human(motherName, motherSurname, String.valueOf(motherBirthDate), motherIq);
    }

    private static void editFamilyMenu(Scanner scanner, FamilyService familyService) {
        System.out.println("1. Give birth to a baby");
        System.out.println("2. Adopt a child");
        System.out.println("3. Return to main menu");

        String command = scanner.nextLine();
        switch (command) {
            case "1":
                giveBirthToChild(scanner, familyService);
                break;
            case "2":
                adoptChild(scanner, familyService);
                break;
            case "3":
                return;
            default:
                System.out.println("Invalid command. Please try again.");
        }

    }

    private static void giveBirthToChild(Scanner scanner, FamilyService familyService) {
        System.out.println("Enter family ID: ");
        int familyId = Integer.parseInt(scanner.nextLine());
        Family family = familyService.getFamilyById(familyId);
        if (family == null) {
            System.out.println("Family with ID " + familyId + " not found.");
            return;
        }
        System.out.println("Enter boy's name: ");
        String boyName = scanner.nextLine();
        System.out.println("Enter girl's name: ");
        String girlName = scanner.nextLine();
        familyService.bornChild(family, boyName, girlName);
    }

    private static void adoptChild(Scanner scanner, FamilyService familyService) {
        System.out.println("Enter family ID: ");
        int familyId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter child's name: ");
        String childName = scanner.nextLine();
        System.out.println("Enter child's surname: ");
        String childSurname = scanner.nextLine();
        System.out.println("Enter child's birth year: ");
        int childYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter child's IQ: ");
        int childIq = Integer.parseInt(scanner.nextLine());

        Human child = new Human(childName, childSurname, childYear, 0, 0, childIq); // Assuming month/day is not needed
        Family family = familyService.getFamilyById(familyId);
        if (family != null) {
            familyService.adoptChild(family, child);
        } else {
            System.out.println("Family with ID " + familyId + " not found.");
        }
    }

}




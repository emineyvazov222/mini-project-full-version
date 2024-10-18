package org.spring.FullVersion;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FamilyOverflowException {

        Human father = new Human("John", "Doe", 1980);
        Human mother = new Human("Jane", "Doe", 1982);

        Scanner scanner = new Scanner(System.in);
        FamilyService familyService = new FamilyService(new CollectionFamilyDao());

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    fillWithTestData(familyService);
                    break;
                case "2":
                    familyService.displayAllFamilies();
                    break;
                case "3":
                    System.out.println("Enter the number of people: ");
                    int greaterThan = Integer.parseInt(scanner.nextLine());
                    familyService.getFamiliesBiggerThan(greaterThan);
                    break;
                case "4":
                    System.out.println("Enter the number of people: ");
                    int lessThan = Integer.parseInt(scanner.nextLine());
                    familyService.getFamiliesLessThan(lessThan);
                    break;
                case "5":
                    System.out.println("Enter the number of members: ");
                    int countNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Number of families: " + familyService.countFamiliesWithMemberNumber(countNumber));
                    break;
                case "6":
                    createNewFamily(scanner, familyService);
                    break;
                case "7":
                    System.out.println("Enter family index: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    familyService.deleteFamilyByIndex(id);
                    break;
                case "8":
                    editFamilyMenu(scanner, familyService);
                    break;
                case "9":

                    System.out.println("Enter the age to remove children: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    familyService.deleteAllChildrenOlderThen(age);
                    break;
                case "exit":
                    System.out.println("Exiting the application.");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
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
        System.out.println("Type 'exit' to exit");
    }

    private static void fillWithTestData(FamilyService familyService) {

        LocalDate motherBirthDate = LocalDate.of(1991, 3, 3);
        LocalDate fatherBirthDate = LocalDate.of(1990, 12, 10);

        Human mother = new Human("Kate", "Bibo", motherBirthDate, 95);
        Human father = new Human("Karl", "Bibo", fatherBirthDate, 90);

        familyService.createNewFamily(mother, father);
        System.out.println("Test data filled.");
    }

    private static void createNewFamily(Scanner scanner, FamilyService familyService) {

        System.out.println("Enter mother's name: ");
        String motherName = scanner.nextLine();
        System.out.println("Enter mother's surname: ");
        String motherSurname = scanner.nextLine();
        System.out.println("Enter mother's birth year: ");
        int motherYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter mother's birth month: ");
        int motherMonth = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter mother's birthday: ");
        int motherDay = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter mother's IQ: ");
        int motherIq = Integer.parseInt(scanner.nextLine());

        LocalDate motherBirthDate = LocalDate.of(motherYear, motherMonth, motherDay);
        Human mother = new Human(motherName, motherSurname, String.valueOf(motherBirthDate), motherIq);

        System.out.println("Enter father's name: ");
        String fatherName = scanner.nextLine();
        System.out.println("Enter father's surname: ");
        String fatherSurname = scanner.nextLine();
        System.out.println("Enter father's birth year: ");
        int fatherYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter father's birth month: ");
        int fatherMonth = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter father's birthday: ");
        int fatherDay = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter father's IQ: ");
        int fatherIq = Integer.parseInt(scanner.nextLine());

        LocalDate fatherBirthDate = LocalDate.of(fatherYear, fatherMonth, fatherDay);
        Human father = new Human(fatherName, fatherSurname, String.valueOf(fatherBirthDate), fatherIq);

        familyService.createNewFamily(mother, father);
        System.out.println("New family created.");
    }

    private static void editFamilyMenu(Scanner scanner, FamilyService familyService) {
        System.out.println("1. Give birth to a baby");
        System.out.println("2. Adopt a child");
        System.out.println("3. Return to main menu");

        String command = scanner.nextLine();
        switch (command) {
            case "1":
                System.out.println("Enter family ID: ");
                int familyId = Integer.parseInt(scanner.nextLine());
                Family family = familyService.getFamilyById(familyId);
                if (family == null) {
                    System.out.println("Family with ID " + familyId + " not found.");
                    break;
                }
                System.out.println("Enter boy's name: ");
                String boyName = scanner.nextLine();
                System.out.println("Enter girl's name: ");
                String girlName = scanner.nextLine();
                familyService.bornChild(family, boyName, girlName);
                break;
            case "2":

                System.out.println("Enter family ID: ");
                familyId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter child's name: ");
                String childName = scanner.nextLine();
                System.out.println("Enter child's surname: ");
                String childSurname = scanner.nextLine();
                System.out.println("Enter child's birth year: ");
                int childYear = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter child's IQ: ");
                int childIq = Integer.parseInt(scanner.nextLine());
                Human child = new Human(childName, childSurname, childYear, 0, 0, childIq); // Assuming month/day is not needed
                family = familyService.getFamilyById(familyId);
                familyService.adoptChild(family, child);

        }
    }
}

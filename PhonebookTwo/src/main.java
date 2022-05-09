import java.util.Scanner;

/**
 *      ***** PhoneBook Project ******
 * 
 * @class Java Bootcamp
 * @author C. Anderson
 * @date 5/4/2022
 */
public class main {

    /**
     * Access Database in any method
     * thanks Lance
     */
    public static DataBase primary = new DataBase();

    /**
     * 
     * Method to add info line by line or in bulk
     * @param p9 only method that returns a value. Testing different ways to run mainMenu()
     * 
     */
    public static Person runAddPerson(Person p9) {
        //initiate Scanner
        Scanner in = new Scanner(System.in);
    
        // object for dataBase() storage
        DataBase setData = new DataBase();
        setData.printDirectory();
    
        // Create objects
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        setData.printDirectory();
    
        //variables to send to logic statements
        //unable to set as private
        String test = "";
    
        // Choose whether to enter a string or indiviual values
        // create another menu to continue adding people until user quits
        System.out.println("1 = Enter individual values");
        System.out.println("2 = Enter full values in bulk");
        int addChoice = in.nextInt();
    
        /**
         * This is extra needs to be debugged on l:65
         * this is extra and not part of rubric
         * skips over user input
         */
        if (addChoice == 1) {
            System.out.print("Does this Person have a middle name? (1 = yes / 2 = no): ");
            int nameFormat = in.nextInt();
            System.out.println(nameFormat);
            if (nameFormat == 1) {
                System.out.println("Enter first name: ");
                p1.setFirstName(in.next());
                System.out.println("Enter middle name: ");
                p1.setMiddleName(in.next());
                System.out.println("Enter last name: ");
                p1.setLastName(in.next());
                System.out.println("Enter street number: ");
                p1.setStreetNum(in.nextInt());
                System.out.println("Enter street name: "); // skips over this 
                p1.setStreetName(in.nextLine());
                System.out.println("Enter city: ");
                p1.setCity(in.nextLine());
                System.out.println("Enter state (Ex. MO): ");
                p1.setState(in.nextLine());
                System.out.println("Enter zip code: ");
                p1.setZipCode(in.nextLine());
                System.out.println("Enter phone number ex.1234567890: ");
                p1.setPhoneNumber(in.nextLong());
                setData.addPerson(p1);
                setData.printDirectory();
            } else if (nameFormat == 2) {
                System.out.println("Enter first name: ");
                p1.setFirstName(in.next());
                System.out.println("Enter last name: ");
                p1.setLastName(in.next());
                System.out.println("Enter street number: ");
                p1.setStreetNum(in.nextInt());
                System.out.println("Enter street name:");
                p1.setStreetName(in.next());
                System.out.println("Enter city: ");
                p1.setCity(in.next());
                System.out.println("Enter state (Ex. MO): ");
                p1.setState(in.next());
                System.out.println("Enter zip code: ");
                p1.setZipCode(in.next());
                System.out.println("Enter phone number ex.1234567890: ");
                p1.setPhoneNumber(in.nextLong());
                setData.addPerson(p1);
                setData.printDirectory();
            }
       } else if (addChoice == 2) {
            setData.printDirectory();
            // Adding people
            System.out.println("Please enter information to be added seperated by commas");
            in.nextLine();
            System.out.println("FORMAT: Name, Street Address, City(no periods, i.e St Louis not St. Louis"
                + "state, ZipCode, Phone Number");
            test = in.nextLine();

            // seperate info
            String[] tempInfo = test.split(", ");

            // set variables for each index
            String name = tempInfo[0];
            String street = tempInfo[1];
            String city = tempInfo[2];
            String state = tempInfo[3];
            String zipCode = tempInfo[4];
            long phoneNum = Long.parseLong(tempInfo[5]);

            String[] tempName = name.split(" ");

            String firstName = tempName[0]; 

            // last name
            String lastName = tempName[tempName.length - 1];

            // Empty container
            String middleName = "";

            // Method
            for (int i = 1; i < tempName.length - 1; i++) {
                middleName += tempName[i];
                if (i != tempName.length -2) {
                    middleName += " ";
                }
            }

            String[] tempAddress = street.split(" ");
            String streetName = "";

            // iterate adding values
            for (int i = 1; i < tempAddress.length; i++) {
                streetName += tempAddress[i];
                if (i != tempAddress.length -1) {
                    streetName += " ";
                }
            }
            
            int streetNum = Integer.parseInt(tempAddress[0]);
            p3 = new Person(firstName, lastName, middleName, phoneNum);
            p3.addAddress(streetNum, streetName, city, state, zipCode);
            setData.addPerson(p3);
            setData.printDirectory();

            System.out.println(p1.toString());
        } else {
            System.out.println("pray for me!!");
        }
        return p3;
    }

    /**
     * multi-purpose method to search all parameters for assignment
     * @param num menu selection to utilize in method
     * @return
     */
    public static Person runSearchBy(int num) {
        
        // initiate scanner
        Scanner in = new Scanner(System.in);

        // create object
        Person p1 = new Person();

        // variables
        String testValue;

        if (num == 3) {
            System.out.println("Enter first name");
            testValue = in.next();
            primary.searchDirectory(testValue, num);
        } else if (num == 4) {
            System.out.println("Enter last name");
            testValue = in.next();
            primary.searchDirectory(testValue, num);
        } else if (num == 7) {
            System.out.println("Enter state:");
            testValue = in.next();
            primary.searchDirectory(testValue, num);
        } else if (num == 8) {
            System.out.println("Enter city");
            testValue = in.next();
            primary.searchDirectory(testValue, num);
        }
        
        // return statement
        return p1;
    }

    /**
     * prompts user to search number
     * if number is found, user can update it
     * modify to delete value too
     * needs enhancement to iterate through loop again if number is not found
     */
    public static void runUpdatePhone() {
        // initiate Scanner
        Scanner in = new Scanner(System.in);

        // body
        System.out.println("Enter number to change:");
        long initialNum = in.nextLong();
        primary.updateDirectory(initialNum);
    }
    /**
     * Main method
     * Loads created entries into dataBase() prior to user inputs
     * 
     */
    public static void main(String[] args) throws Exception {
        
        // Initiate Scanner
        Scanner in = new Scanner(System.in);


        // Hard code entries
        Person p1 = new Person("Cedric", "Anderson", "Lamont", 3148794171L);
        p1.addAddress(3811, "Shaw Blvd.", "Saint Louis", "MO", "63110");

        Person p2 = new Person("Chesty", "Puller", "", 1234567890L);
        p2.addAddress(123, "Hate my life", "Jacksonville", "NC", "12345");

        Person p3 = new Person("Anthony", "Lamar", "Simmons", 3148794234L);
        p3.addAddress(3870, "Shenandoah Ave", "Saint Louis", "MO", "63118");

        Person p4 = new Person("Terrance", "Scarl", "", 8005555265L);
        p4.addAddress(1818, "County Jail", "Belleville", "IL", "62201");

        // add to directory
        primary.addPerson(p2);
        primary.addPerson(p1);
        primary.addPerson(p3);
        primary.addPerson(p4);

        // Print DataBase
        primary.printDirectory();

        // variable
        int userChoice;
    
        // Greet user
        System.out.println("***** Phonebook *****");
    
        do {
            // initiate Scanner
            //Scanner in = new Scanner(System.in);
    
            //Display menu
            System.out.println("1 = Add new entries");
            System.out.println("2 = Search for an existing entry");
            System.out.println("3 = Search by first name");
            System.out.println("4 = Search by last name");
            System.out.println("5 = Search by full name");
            System.out.println("6 = Search by telephone number");
            System.out.println("7 = Search by state");
            System.out.println("8 = Search by city");
            System.out.println("9 = Delete phone number");
            System.out.println("10 = Update phone number");
            System.out.println("11 = Show all records");
            System.out.println("0 = Exit");
    
            // Get user choice as int
            userChoice = in.nextInt();
            Person p9 = new Person();

            Person tester;
            System.out.println();
    
            // Statements
            if (userChoice == 1) {
                tester = runAddPerson(p9);
                primary.addPerson(tester);
                primary.printDirectory();
            } else if (userChoice == 3 || userChoice == 4 || userChoice == 7 
            || userChoice == 8) {
                runSearchBy(userChoice);
            } else if (userChoice == 9) {
                System.out.println("Please enter number to remove:");
                long removePhone = in.nextLong();
                primary.deletePhoneNum(removePhone);
            } else if (userChoice == 5 || userChoice == 2) {
                primary.findFullName();
            } else if (userChoice == 6) {
                System.out.println("Please enter a number to search (1234567890):");
                long searchPhone = in.nextLong();
                primary.searchPhoneNum(searchPhone);
            } else if (userChoice == 10) {
                runUpdatePhone();
            } else if (userChoice == 11) {
                primary.printDirectory();
            }  else if (userChoice == 0) {
                break;
            } else {
                System.out.println("Please enter a valid number!");
            }
        }
        while (userChoice != 0);
        System.out.println("Thank you for visiting my Phonebook Project!");
    }
}

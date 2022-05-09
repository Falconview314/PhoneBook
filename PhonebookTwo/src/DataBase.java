import java.util.*;


/**
 * DataBase to store information for each entry. 
 * Methods to retrieve data and print
 */
public class DataBase {

    // create an array of people
    Person[] person = new Person[0];

    // addPerson to the array
    public void addPerson(Person newPerson) {
        // ceate temp array + 1
        Person[] temp = new Person[person.length + 1];

        // add people in the original array to temp
        for (int i = 0; i < person.length; i++) {
            temp[i] = person[i];
            System.out.println(temp[i]);
        }
        // add new person to object
        temp[temp.length - 1] = newPerson;

        // reassign person
        person = temp;
    }

    // Getter
    public Person[] getDirectory() {
        return person;
    }

    // print entire director
    public void printDirectory() {
        for (int i = 0; i < person.length; i++) {
            person[i].getPerson();
        }
    }

    /**
     * 
     * multi-purpose method to search for variables throughout phonebook project.
     * Search by state and city will not return a value from getter
     * Search by state and city troubleshot by Lance
     * @param searchValue user selected string to search by
     * @param num number assigned from menu to direct statment
     */
    public void searchDirectory(String searchValue, int num) {
        String test;
        if (num == 3) {
            for (int i = 0; i < person.length; ++i) {
                test = person[i].getFirstName();
                if (test.contains(searchValue)) {
                    person[i].getPerson();
                }
            }
        } else if (num == 4) { // Search last name
            for (int i = 0; i < person.length; i++) {
                test = person[i].getLastName();
                if (test.contains(searchValue)) {
                    person[i].getPerson();
                }
            }
        } else if (num == 7) { // search by state
            for (int i = 0; i < person.length; ++i) {
                test = person[i].getAddress().getState();
                if (test.contains(searchValue)) {
                    person[i].getPerson();
                }
            }
        } else if (num == 8) { // find by city
            for (int i = 0; i < person.length; ++i) {
                test = person[i].getAddress().getCity();
                if (test.contains(searchValue)) {
                    person[i].getPerson();
                }
            }
        }
    }

    /**
     * updates phone number
     * enhance to delete as well
     * @param phoneNum initial search parameter
     */
    public void updateDirectory(long phoneNum) {
        Scanner in = new Scanner(System.in);
        long updatePhone;
        for (int i = 0; i < person.length; ++i) {
            updatePhone = person[i].getPhoneNumber();
            if (updatePhone == phoneNum) {
                System.out.println("Enter new number:");
                long newNum = in.nextLong();
                person[i].setPhoneNumber(newNum);
                person[i].getPerson();
            } else {
                System.out.println("Please enter a valid number");
            }
        }
    }
    /**
     * Method to search by full name
     * Takes a string and splits it into multiple indexes
     * 
     * statement determines who to add
     */
    public void findFullName() {
        //Initiate Scanner
        Scanner in = new Scanner(System.in);

        System.out.println("Enter full name with no commas:");
        String initialInput = in.nextLine();

        // Array to store values
        String[] finder = initialInput.split(" ");

        // Assign firstName and lastName
        String firstName = finder[0];
        String lastName = finder[finder.length - 1];
        String middleName = "";

        // Statement to determine
        for (int i = 1; i < finder.length - 1; ++i) {
            middleName = finder[i];
            if (i != finder.length - 2) {
                middleName += " ";
            }
        }
        for (int i = 0; i < person.length; ++i){
            String firstNameTest = person[i].getFirstName();
            if (firstNameTest.contains(firstName)) {
                String lastNameTest = person[i].getLastName();
                if (lastNameTest.contains(lastName)) {
                    String middleNameTest = person[i].getMiddleName();
                    if (middleNameTest.length() != 0) {
                        if (middleNameTest.contains(middleName)) {
                            person[i].getPerson();
                        }
                    } else {
                        person[i].getPerson();
                    }
                }
            }
        }
    }

    /**
     * 
     * Method to set phone number to empty
     * 
     * @param searchValue user input from main method
     */
    public void deletePhoneNum(long searchValue) {
        // Variables
        long test;

        // Statement
        for (int i = 0; i < person.length; i++) {
            test = person[i].getPhoneNumber();
            if (test == searchValue) {
                person[i].setPhoneNumber(0L);
                person[i].getPerson();
            } 
        }
    }

    /**
     * Method to search for phone number
     * 
     * @param searchValue user input from main method
     */
    public void searchPhoneNum(long searchValue) {
        long searchPhone;
        for (int i = 0; i < person.length; ++i) {
            searchPhone = person[i].getPhoneNumber();
            if (searchPhone == searchValue) {
                person[i].getPerson();
            }
        }
    }
    public Person[] sortArray(Person[] person) {
        Arrays.sort(person);
        return person;
    }
}

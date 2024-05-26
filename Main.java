import java.util.*;

class PhoneBookEntry {
    private String name;
    private List<String> phoneNumbers;

    public PhoneBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
        this.phoneNumbers.add(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }
}

class PhoneBook {
    private HashMap<String, PhoneBookEntry> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addEntry(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).addPhoneNumber(phoneNumber);
        } else {
            phoneBook.put(name, new PhoneBookEntry(name, phoneNumber));
        }
    }

    public void displayPhoneBook() {
        List<Map.Entry<String, PhoneBookEntry>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().getPhoneNumbers().size(), entry1.getValue().getPhoneNumbers().size()));

        for (Map.Entry<String, PhoneBookEntry> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue().getPhoneNumbers();
            System.out.println(name + ": " + phoneNumbers.size() + " phone(s)");
            for (String phoneNumber : phoneNumbers) {
                System.out.println("  " + phoneNumber);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alice", "123456789");
        phoneBook.addEntry("Bob", "987654321");
        phoneBook.addEntry("Alice", "987654321");
        phoneBook.addEntry("Charlie", "123456789");
        phoneBook.addEntry("Bob", "555555555");

        phoneBook.displayPhoneBook();
    }
}
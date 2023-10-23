import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Dima", "0552022222");
        addContact(phoneBook, "Vlad", "0555956874");
        addContact(phoneBook, "Dima", "0700011111");
        addContact(phoneBook, "Sergey", "0772456873");
        addContact(phoneBook, "Sergey", "0772455553");
        addContact(phoneBook, "Sergey", "0773333353");

        List<Map.Entry<String, List<String>>> sortedContacts = sortContactsByPhoneCount(phoneBook);
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + String.join(", ", phones));
        }
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    public static List<Map.Entry<String, List<String>>> sortContactsByPhoneCount(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> contactList = new ArrayList<>(phoneBook.entrySet());

        Collections.sort(contactList, (entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        return contactList;
    }
}

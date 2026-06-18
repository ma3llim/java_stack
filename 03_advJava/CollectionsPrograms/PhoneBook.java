package CollectionsPrograms;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args){
        TreeMap<String, String> contacts = new TreeMap<>();
        contacts.put("Sameer", "1234567890");
        contacts.put("Fahad", "1234567890");
        contacts.put("Khaja", "1234567890");
        contacts.put("Uday", "1234567890");
        contacts.put("Krishna", "1234567890");

        System.out.println(contacts.remove("Uday"));

        for(Map.Entry<String, String> entry :  contacts.entrySet()){
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }
    }
}

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String[] components = data.split("\\s+");
        if(components.length !=4)
        {
            throw new ArrayIndexOutOfBoundsException("Wrong format. Correct format: \n" + "add Василий Петров" +
                    " vasily.petrov@gmail.com +79215637722");
        }
        if(!components[INDEX_PHONE].matches("\\+{1}7{1}\\d{10}"))
        {
            throw new IllegalArgumentException("Wrong format phone number. Correct format: \n" +"+79215637722");
        }
        if(!components[INDEX_EMAIL].matches("[a-z0-9\\-\\_]{1,}[@]{1,1}[a-z0-9\\-\\_]{1,}\\.[a-z]{1,}"))
        {
            throw new IllegalArgumentException("Wrong format email . Correct format: \n" +"vasily.petrov@gmail.com");
        }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}
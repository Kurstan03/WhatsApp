import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();
        List<Passport> passports = new ArrayList<>();
        List<WhatsApp> users = new ArrayList<>();
        WhatsApp whatsApp = new WhatsApp();
        whatsApp.setContacts(contacts);
        CommandsImpl commands = new CommandsImpl();
        while (true) {
            catalog();
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println(commands.createPassport(passports));
                    System.out.println(passports);
                    break;
                case 2:
                    System.out.println(commands.installWhatsApp(users));
                    System.out.println(users);
                    break;
                case 3:
                    System.out.print("Сыр созду жазыныз: ");
                    String  password = strScanner.nextLine();
                    for (WhatsApp user : users) {
                        if (password.trim().equals(user.getPassword().trim())) {
                            whatsAppCommands(user, users, commands);
                        }
                    }
            }
        }
    }
    public static void catalog(){
        System.out.println("""
                1.Паспорт алуу
                2.WhatsApp кочуруу
                3.WhatsApp профилге кируу
                4.""");
    }
    public static void whatsAppCatalog(){
        System.out.println("""
                1.Жеке каттар
                2.Группалар
                3.Контакт кошуу
                4.Группа ачуу
                5.Ырастоолор""");
    }
    public static void whatsAppCommands(WhatsApp user, List<WhatsApp> users, CommandsImpl commands){
        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
//        while (true){
            whatsAppCatalog();
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    user.getContacts().forEach(System.out::println);
                    for (int i = 0; i < user.getContacts().size(); i++) {
                        System.out.println(user.getContacts().get(i));
                        System.out.println("\n  " + user.getContacts().get(i).getMessages());
                    }
                    commands.getMessage(users, user);
                    break;
                case 2:
                    user.getGroups().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println(commands.addContact(users, user));
            }
//        }
    }
}
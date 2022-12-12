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
                    System.out.println(passports.get(passports.size() - 1));
                    break;
                case 2:
                    System.out.println(commands.installWhatsApp(users));
                    System.out.println(users.get(users.size() - 1));
                    break;
                case 3:
                    System.out.print("Сыр созду жазыныз: ");
                    String  password = strScanner.nextLine();
                    for (WhatsApp user : users) {
                        if (password.trim().equals(user.getPassword().trim())) {
                            whatsAppCommands(user, users, commands);
                        }
                    }
                    break;
            }
        }
    }
    public static void catalog(){
        System.out.println("""
                \n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n
                1.Паспорт алуу
                2.WhatsApp кочуруу
                3.WhatsApp тиркемеге кируу
                """);
    }
    public static void whatsAppCatalog(){
        System.out.println("""
                \n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n
                1.Жеке каттар
                2.Группалар
                3.Контакт кошуу
                4.Группа ачуу
                5.Профилге кируу
                6.Ырастоолор
                7.Артка""");
    }
    public static void whatsAppCommands(WhatsApp user, List<WhatsApp> users, CommandsImpl commands) {
        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);

            while (true) {
                whatsAppCatalog();

                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        Scanner scannerL = new Scanner(System.in);
                        if (user.getContacts() != null) {
                            for (int i = 0; i < user.getContacts().size(); i++) {
                                System.out.println(user.getContacts().get(i));

                                user.getContacts().get(i).getMessages().forEach(System.out::println);
                            }
                            System.out.println("Контакттын атын жазыныз: ");
                            String userName = scannerL.nextLine();
                            for (Contact contact : user.getContacts()) {
                                if (userName.trim().equals(contact.getName().trim())) {
                                    System.out.println("        " + contact.getName());
                                    while (true) {
                                        System.out.println("""
                                                \n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n
                                                1.Билдируу жонотуу
                                                2.Контакттын профилин коруу
                                                3.Билдируулордун баарын очуруу
                                                4.Артка""");
                                        int numb = scanner.nextInt();
                                        switch (numb) {
                                            case 1:
                                                commands.getMessage(users, user, contact);
                                                break;
                                            case 2:
                                                for (WhatsApp userr : users) {
                                                    if (userr.getUserName().trim().equals(contact.getName().trim())) {
                                                        System.out.println(userr);
                                                    }
                                                }
                                                break;
                                            case 3:
                                                contact.getMessages().clear();
                                                break;
                                        }
                                        if (numb == 4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        } else {
                            System.out.println("Контакт табылган жок");
                        }
                        break;

                    case 2:
                        Scanner scannerGr = new Scanner(System.in);
                        if (user.getGroups() != null) {
                            for (int i = 0; i < user.getGroups().size(); i++) {
                                System.out.println(user.getGroups().get(i));

                                user.getGroups().get(i).getGroupMessage().forEach(System.out::println);
                            }
                            System.out.println("Группанын атын жазыныз: ");
                            String groupName = scannerGr.nextLine();
                            for (Group group : user.getGroups()) {
                                if (groupName.trim().equals(group.getGroupName())) {
                                    System.out.println("======" + group.getGroupName() + "======");
                                    while (true) {
                                        System.out.println("""
                                                \n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n
                                                1.Билдируу жонотуу
                                                2.Группадагы катышуучуларды коруу
                                                3.Группанын атын озгортуу
                                                4.Группанын описаниясын озгортуу
                                                5.Билдируулордун баарын очуруу
                                                6.Артка""");
                                        int numb = scanner.nextInt();
                                        switch (numb) {
                                            case 1:
                                                System.out.println(commands.getGroupMessage(users, user, group));
                                                break;
                                            case 2:
                                                System.out.println("Бардыгы: " + group.getGroupUsers().size());
                                                group.getGroupUsers().forEach(System.out::println);
                                                break;
                                            case 3:
                                                System.out.println(commands.changeGroupName(users, group));
                                                break;
                                            case 4:
                                                System.out.println(commands.changeGroupDescription(users, group));
                                                break;
                                            case 5:
                                                group.getGroupMessage().clear();
                                                break;
                                        }
                                        if (numb == 6) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }else {
                            System.out.println("Группа табылган жок");
                        }
                        break;
                    case 3:
                        System.out.println(commands.addContact(users, user));
                        break;
                    case 4:
                        System.out.println(commands.createGroup(users, user));
                        break;
                    case 5:
                        System.out.println(user);
                        break;
                    case 6:
                        while (true) {
                            System.out.println("""
                                    \n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n
                                    1.Колдонуучу атын озгортуу
                                    2.Статусту озгортуу
                                    3.Артка""");
                            int number = scanner.nextInt();
                            switch (number) {
                                case 1:
                                    System.out.println(commands.changeUserName(user));
                                    break;
                                case 2:
                                    System.out.println(commands.changeStatus(user));
                                    break;
                            }
                            if (number == 3) {
                                break;
                            }
                        }
                        break;
                }
                if (num == 7) {
                    break;
                }
            }

    }
}
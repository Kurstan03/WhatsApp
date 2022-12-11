import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandsImpl implements Commands{

    @Override
    public String createPassport(List<Passport> passports) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Аты: ");
        String name = scanner1.nextLine();
        System.out.print("Фамилиясы: ");
        String lastName = scanner1.nextLine();
        System.out.print("Туулган куну: ");
        String date = scanner1.nextLine();
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        System.out.print("Туулган жери: ");
        String place = scanner1.nextLine();
        System.out.print("Жынысы: ");
        String gender = scanner1.nextLine();
        passports.add(new Passport(id, name, lastName, LocalDate.of(year, month, day), Place.valueOf(place.toUpperCase()), Gender.valueOf(gender.toUpperCase())));
        return "Passport successfully created!";
    }

    @Override
    public String installWhatsApp(List<WhatsApp> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Телефон номери: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Колдонуучунун аты: ");
        String userName = scanner.nextLine();
        System.out.print("Сыр соз: ");
        String password = scanner.nextLine();
        users.add(new WhatsApp(phoneNumber, userName, password));
        return "WhatsApp successfully installed!";
    }

    @Override
    public String addContact(List<WhatsApp> users, WhatsApp myUser) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Телефон номер жазыныз: ");
        String phoneNumber = scanner.nextLine();
        for (WhatsApp user : users) {
            if (phoneNumber.trim().equals(user.getPhoneNumber())) {
                System.out.println("Контакт табылды: " + user.getUserName());
                System.out.println("Сактоо? (yes/no)");
                String save = scanner.nextLine();
                if (save.trim().toUpperCase().equals("YES")){
                    System.out.println("Контакт ийгиликтуу кошулду!");
                    myUser.addContact(new Contact(user.getPhoneNumber(), user.getUserName()));
                }
            }
        }
        return "";
    }

    @Override
    public String getMessage(List<WhatsApp> users, WhatsApp myUser) {
        Scanner scanner = new Scanner(System.in);
        String message = "";
        System.out.println("Кимге кат жонотосуз? ");
        String userName = scanner.nextLine();
        for (Contact myContact : myUser.getContacts()) {
            if (userName.equals(myContact.getName())){
                System.out.println("Контакт " + myContact.getName() + " табылды");
                while (true){
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);

                    message = myUser.getUserName() + ": " + scanner1.nextLine();
                    System.out.println("Жонотуу (yes/no)?");
                    String yesOrNo = scanner2.nextLine();
                    if (yesOrNo.trim().toLowerCase().equals("yes")){
                        myContact.getMessages().add(message);
                        for (WhatsApp user : users) {
                            if (user.getContacts() != null){
                                for (Contact contact : user.getContacts()) {
                                    if (contact.getPhoneNumber().trim().equals(myUser.getPhoneNumber())){
                                        for (Contact myContacty : myUser.getContacts()) {
                                            if (user.getPhoneNumber().trim().equals(myContacty.getPhoneNumber())){
                                                contact.getMessages().add(message);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        break;
                    }
                }
            }
        }
        return message;
    }
}

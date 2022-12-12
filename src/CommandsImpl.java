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
        return "Каттоодон ийгиликтуу оттунуз!";
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
    public String getMessage(List<WhatsApp> users, WhatsApp myUser, Contact contact) {
        Scanner scanner = new Scanner(System.in);
        String message = "";


            while (true) {
                Scanner scanner1 = new Scanner(System.in);
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Билдируу жазасызбы (yes/no)?");
                String noOrYes = scanner.nextLine();
                if (noOrYes.trim().toLowerCase().equals("yes")) {
                    System.out.println("Билдируу...");
                    message = myUser.getUserName() + ": " + scanner1.nextLine();

                        contact.getMessages().add(message);
                        for (WhatsApp user : users) {
                            if (user.getContacts() != null) {
                                for (Contact contacty : user.getContacts()) {
                                    if (contacty.getPhoneNumber().trim().equals(myUser.getPhoneNumber())) {
                                        for (Contact myContacty : myUser.getContacts()) {
                                            if (user.getPhoneNumber().trim().equals(myContacty.getPhoneNumber()) && user.getPhoneNumber().equals(contact.getPhoneNumber())) {
                                                contacty.getMessages().add(message);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                } else {
                    break;
                }
            }
        return "Билдируу жонотулду";
    }

    @Override
    public String changeUserName(WhatsApp myUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Жаны колдонуучу атты жазыныз:");
        String userName = scanner.nextLine();
        myUser.setUserName(userName);
        return "Колдонуучу ат ийгиликтуу озгортулду!";
    }

    @Override
    public String changeStatus(WhatsApp myUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1.САЛАМ_МЕН_WHATSAPP_КОЛДОНОМ,
                2.БОШ_ЭМЕС,
                3.МЕКТЕПТЕ,
                4.ЖУМУШТА,
                5.СПОРТ_ЗАЛДА
                6.CODING""");
        int num = scanner.nextInt();
        switch (num){
            case 1:
                myUser.setStatus(Status.САЛАМ_МЕН_WHATSAPP_КОЛДОНОМ);
                break;
            case 2:
                myUser.setStatus(Status.БОШ_ЭМЕС);
                break;
            case 3:
                myUser.setStatus(Status.МЕКТЕПТЕ);
                break;
            case 4:
                myUser.setStatus(Status.ЖУМУШТА);
                break;
            case 5:
                myUser.setStatus(Status.СПОРТ_ЗАЛДА);
                break;
            case 6:
                myUser.setStatus(Status.CODING);
                break;
        }
        return "Статус ийгиликтуу озгортулду!";
    }

    @Override
    public String createGroup(List<WhatsApp> users, WhatsApp myUser) {
        Scanner scanner = new Scanner(System.in);
        List<String> userName = new ArrayList<>();
        System.out.println("Группанын аты: ");
        String nameGroup = scanner.nextLine();
        System.out.println("Описание: ");
        String description = scanner.nextLine();
        System.out.println("Группага катышуучуларды кошуу");
        while (true) {
            System.out.println("Катышуучу кошосузбу (yes/no)?");
            String yn = scanner.nextLine();
            if (yn.trim().toLowerCase().equals("yes")) {
                System.out.println("Катышуучунун аты: ");
                String groupUser = scanner.nextLine();
                for (WhatsApp user : users) {
                    if (groupUser.trim().equals(user.getUserName().trim())) {
                        System.out.println(user.getUserName() + " табылды\nKошуу (yes/no)?");
                        String yesOrNo = scanner.nextLine();
                        if (yesOrNo.trim().toLowerCase().equals("yes")) {
                            userName.add(user.getUserName());

                        }
                    }
                }
            }else {
                break;
            }
        }

        for (String nameUs : userName) {
            for (WhatsApp nUser : users) {
                if (nameUs.trim().equals(nUser.getUserName())){
                    nUser.addGroup(new Group(nameGroup, description, userName));
                }
            }
        }
        userName.add(myUser.getUserName());
        myUser.addGroup(new Group(nameGroup, description, userName));
        return "Группа ийгиликтуу ачылды!";
    }

    @Override
    public String getGroupMessage(List<WhatsApp> users, WhatsApp myUser, Group group) {
        Scanner scanner = new Scanner(System.in);
        String message = "";
                while (true) {
                    System.out.println("Билдируу жазасызбы(yes/no)?");
                    String noOrYes = scanner.nextLine();
                    if (noOrYes.trim().toLowerCase().equals("yes")) {
                        System.out.println("Билдируу...");
                        message = myUser.getUserName() + ": " + scanner.nextLine();
                        System.out.println("Жонотуу (yes/no)?");
                        String yesOrNo = scanner.nextLine();
                        if (yesOrNo.trim().toLowerCase().equals("yes")){
                            group.getGroupMessage().add(message);
                            for (String groupUser : group.getGroupUsers()) {
                                for (WhatsApp user : users) {
                                    if (groupUser.equals(user.getUserName()) && !groupUser.equals(myUser.getUserName())){
                                        for (Group gr : user.getGroups()) {
                                            if (gr.getGroupName().equals(group.getGroupName())){
                                                gr.getGroupMessage().add(message);
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
        return "Билдируу жонотулду";
    }

    @Override
    public String changeGroupName(List<WhatsApp> users, Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Группанын жаны аты: ");
        String groupName = scanner.nextLine();
        for (WhatsApp user : users) {
            for (Group gr : user.getGroups()) {
                if (gr.getGroupName().equals(group.getGroupName())){
                    gr.setGroupName(groupName);
                }
            }
        }
        return "Группанын аты ийгиликтуу озгортулду!";
    }

    @Override
    public String changeGroupDescription(List<WhatsApp> users, Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Жаны описание: ");
        String description = scanner.nextLine();
        for (WhatsApp user : users) {
            for (Group gr : user.getGroups()) {
                if (gr.getGroupName().equals(group.getGroupName())){
                    gr.setDescription(description);
                }
            }
        }
        group.setDescription(description);
        return "Группанын описаниясы ийгиликтуу озгортулду!";
    }
}

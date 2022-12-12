import java.util.List;

public interface Commands {
    String createPassport(List<Passport> passports);
    String installWhatsApp(List<WhatsApp> users);
    String addContact(List<WhatsApp> users, WhatsApp myUser);
    String getMessage (List<WhatsApp> users, WhatsApp myUser, Contact contact);
    String changeUserName(WhatsApp myUser);
    String changeStatus(WhatsApp myUser);
    String createGroup(List<WhatsApp> users, WhatsApp myUser);
    String getGroupMessage(List<WhatsApp> users, WhatsApp myUser, Group group);
    String changeGroupName(List<WhatsApp> users, Group group);
    String changeGroupDescription(List<WhatsApp> users, Group group);
}

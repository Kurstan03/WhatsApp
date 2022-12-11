import java.util.List;

public interface Commands {
    String createPassport(List<Passport> passports);
    String installWhatsApp(List<WhatsApp> users);
    String addContact(List<WhatsApp> users, WhatsApp myUser);
    String getMessage (List<WhatsApp> users, WhatsApp myUser);
}

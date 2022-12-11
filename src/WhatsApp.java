import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WhatsApp {
    private String phoneNumber;
    private String password;
    private String userName;
    private Status status = Status.САЛАМ_МЕН_WHATSAPP_КОЛДОНОМ;
    private List<Contact> contacts;

    public void addContact(Contact contact){
        if (contacts==null){
            contacts=new ArrayList<>();
        }
        contacts.add(contact);
    }

    private List<Group> groups;

    public void addGroups(Group group){
        if (groups == null){
            groups = new ArrayList<>();
        }
        groups.add(group);
    }

    public WhatsApp() {
    }

    public WhatsApp(String phoneNumber, String userName, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "WhatsApp{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                ", contacts=" + contacts +
                ", groups=" + groups +
                '}';
    }
}

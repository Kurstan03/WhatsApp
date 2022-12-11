import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Contact {
    private String phoneNumber;
    private String name;
    private List<String> messages = new ArrayList<>();

//    public void addMassage(String massage){
//        if (messages == null){
//            messages = new ArrayList<>();
//        }
//        messages.add(massage);
//    }
//    public void addMassage(List<String> massage){
////        if (messages == null){
////            messages = new ArrayList<>();
////        }
//        messages.addAll(massage);
//    }

    public Contact(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return  name + " (" + phoneNumber + ")" +
                "\n  чат: ";
    }
}

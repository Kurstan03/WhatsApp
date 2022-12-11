import java.util.List;

public class Group {
    private String groupName;
    private String description;
    private List<WhatsApp> groupUsers;

    public Group(String groupName, String description, List<WhatsApp> groupUsers) {
        this.groupName = groupName;
        this.description = description;
        this.groupUsers = groupUsers;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WhatsApp> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<WhatsApp> groupUsers) {
        this.groupUsers = groupUsers;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", description='" + description + '\'' +
                ", groupUsers=" + groupUsers +
                '}';
    }
}

public class BookClub {
    int maxMembers;
    String[] members;
    int memberCount = 0;

    public BookClub(int maxMembers) {
        this.members = new String[maxMembers];
    }

    public boolean addMember(String name) {
        if (memberCount != members.length) {
            System.out.println(name + " Was added to the bookclub");
            members[memberCount] = name;
            memberCount += 1;
            return true;
        }
        System.out.println("Book Club Is Full");
        return false;
    }

    public boolean removeMember(String name) {
        for (int i = 0; i < members.length; i++) {
            if (members[i].equals(name)) {
                System.out.println(members[i] + " Was Removed");
                members[i] = null;
                memberCount -= 1;
                return true;
            }
        }
        System.out.println("Member Not Found");
        return false;
    }

}
package everything.strings;

/**
 * Created by mcalancea on 2015-03-06.
 */
public class StringNameToNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String[] stringArray = {"A", "a", "b", "c", "d"};
        String[] stringArray = {"Baidu","Clone-Sync Emails", "Bulk Import", "Bugs", "Invalid atrkid", "My Jiras",
                "!Favorite", "Team 6", "JBoss", "Jenkins", "Log", "Management", "Oracle", "Oracle DB", "Setup",
                "Ticket","Java Guilde","Personal","DB Scripts"};
        for (String st : stringArray) {
            System.out.println(st + ":" + getNumber(st));
        }

//        getNumber("Oracle DB");
    }

    public static int getNumber(String name) {
        int limitStart = 1;
        int limitEnd = 48;
        int n = limitEnd - limitStart + 1;

        int hashCode = Math.abs(name.hashCode());
        return hashCode % n + 1;
    }
}

package stock_check;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<User> users;

    public static void main(String[] args) {
        Login login = new Login();
        login.users = login.getUsers();
        while(true)
            login.checkDetails();
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Nick458", "123", "Nick", "Moore", 101, true));
        users.add(new User("Nicole458", "321", "Nicole", "Hall", 102, false));
        return users;
    }

    public void checkDetails() {
        System.out.println("Please enter your username");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Please enter your password");
        String password = new Scanner(System.in).nextLine();
        for(User u : users) {
            if (username.equals(u.username)) {
                if (password.equals(u.password)) {
                    CurrentStock cs = new CurrentStock();
                    cs.getData();
                    break;
                }
            }
        }
    }
}

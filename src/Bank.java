import javax.swing.text.html.StyleSheet;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {
    private User[] users = new User[2];

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void addUser(User user) {
        int id;
        for (int i = 0; ; i++) {
            System.out.println("Yeni ishcninin id-sini daxil edin :");
            id = new Scanner(System.in).nextInt();
            user.setId(id);
            if (getUsers().length == 0) {
                setUsers(new User[2]);
            }
            if (getUsers()[i] != null && getUsers()[i].getId() == id) {
                System.out.println(" bu Id-de Melumat daxil edilib!! Yeniden daxil edin ");
                return;
            }
            break;

        }
        for (int i = 0; i < users.length; i++) {
            System.out.println("Yeni ishcini adini daxil edin :");
            String name = new Scanner(System.in).nextLine();
            user.setName(name);
            System.out.println("Ishcinin soyadini daxil edin :");
            String surname = new Scanner(System.in).nextLine();
            user.setSurname(surname);
            System.out.println("Ishcinin emailini daxil edin :");
            String email = new Scanner(System.in).nextLine();
            user.setEmail(email);
            System.out.println("Ishcinin passwordunu daxil edin :");
            int password = new Scanner(System.in).nextInt();
            user.setPassword(password);


            break;
        }
        boolean hasNull = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                hasNull = true;
                break;
            }
        }
        if (hasNull == false) {
            User[] newUser = new User[users.length * 2];
            for (int j = 0; j < users.length; j++) {
                newUser[j] = users[j];
            }
            newUser[users.length] = user;
            users = newUser;
        }
    }


    public void updateUserById(int id, User user) {

        user.setId(id);
        System.out.println("Ishcinin adini daxil edin :");
        String name = new Scanner(System.in).nextLine();
        user.setName(name);
        System.out.println("Ishcinin soyadini daxil edin :");
        String surname = new Scanner(System.in).nextLine();
        user.setSurname(surname);
        System.out.println("Ishcinin mailini daxil edin :");
        String email = new Scanner(System.in).nextLine();
        user.setEmail(email);
        System.out.println("Ishcinin passwordunu daxil edin :");
        int password = new Scanner(System.in).nextInt();
        user.setPassword(password);
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                users[i] = user;
                break;
            } else if (users[i] == null) {
                System.out.println("Bele bir Id yoxdur !!");
                break;
            }
        }
    }

    public void removeById(int id) {

        int location = 0;

        if (users.length == 0) {
            System.out.println("Array bohsdur");
            return;
        }


        User[] newUser = new User[users.length - 1];


        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                location = i;
                break;
            }
        }

        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (i != location) {
                newUser[j] = users[i];
                j++;
            }
        }
        users = newUser;


        for (int i = 0; i < newUser.length; i++) {
            if (newUser[i] != null)
                System.out.println(newUser[i].toString());
        }

    }

    public User[] getAllUser() {
        return users;
    }

    public User getUserById(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                System.out.println(users[i].toString());
            }

        }
        return null;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "users=" + Arrays.toString(users) +
                '}';
    }
}

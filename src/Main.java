import java.util.Scanner;

public class Main {
    static Bank bank = new Bank();

    public static void main(String[] args) {

        while (true) {


            System.out.println("""
                    1 - Bankdaki ishcileri gor :
                    2 - Bankdaki spesifik ishcini gor :
                    3 - Banka user elave et :
                    4 - Useri update et :
                    5 - Useri sil :   
                    """);
            int choise = new Scanner(System.in).nextInt();
            switch (choise) {
                case 1:
                    showAllUser();
                    break;
                case 2:
                    showUserById();
                    break;
                case 3:
                    createUser();
                    break;
                case 4:
                    System.out.println("Update etmek istediyiniz id-ni daxil edin :");
                    int id = new Scanner(System.in).nextInt();
                    bank.updateUserById(id, new User());
                    break;
                case 5:
                    System.out.println("Remove  etmek istediyiniz Id-ni daxil edin :");
                    int removingId = new Scanner(System.in).nextInt();
                    bank.removeById(removingId);
                    break;

            }
        }
    }

    public static void createUser() {

            bank.addUser(new User());
    }

    public static void showAllUser() {
        for (int i = 0; i < bank.getAllUser().length; i++) {
            if (bank.getAllUser()[i] != null) {
                System.out.println(bank.getAllUser()[i].toString());
            } else if (bank.getAllUser()[0] == null) {
                System.out.println("Ishci daxil edilmeyib !");
                break;
            }
        }
    }

    public static void showUserById() {
        System.out.println("Axtardiginiz  Id-ni daxil edin :");
        int id = new Scanner(System.in).nextInt();
        bank.getUserById(id);
    }

}


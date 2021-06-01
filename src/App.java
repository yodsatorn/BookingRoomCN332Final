import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {

            System.out.println(
                    "Welcome to Hotel del luna \nPlease login or register before booking room \n1.Login Normal \n2.Login via 2FA \n3.Login via Biometric \n4.Register \nYou can use Username: admin Password: 12345 for test.\n");
            int inputFromClient;
            Scanner sc = new Scanner(System.in);
            inputFromClient = sc.nextInt();
            LoginAcc logAcc = new LoginAcc();

            // add admin user for test
            logAcc.register("admin", "12345");

            switch (inputFromClient) {
                case 1:
                    if (inputFromClient == 1) {
                        System.out.println("Please input your Username and Password");
                        String inputUser = sc.nextLine();

                        String inputPass = sc.nextLine();

                        if (logAcc.loginNormal(inputUser, inputPass)) {
                            System.out.println("login success");
                        } else {
                            System.out.println("Login not success");
                        }
                    }
                case 2:
                    if (inputFromClient == 2) {
                        System.out.println("Login via 2FA \n");

                        if (logAcc.loginVia2FA()) {
                            System.out.println("login success");
                        } else {
                            System.out.println("Login not success");
                        }
                    }
                case 3:
                    if (inputFromClient == 3) {
                        System.out.println("Login via Biometric \n");

                        if (logAcc.loginViaBiometric()) {
                            System.out.println("login success");
                        } else {
                            System.out.println("Login not success");
                        }
                    }
                case 4:
                    if (inputFromClient == 4) {
                        System.out.println("Registation: Please input Username and Password\n Username: ");
                        String inputUser2 = sc.nextLine();
                        System.out.println("Password: \n");
                        String inputPass2 = sc.nextLine();

                        if (logAcc.register(inputUser2, inputPass2)) {
                            System.out.println("Registation success");
                        } else {
                            System.out.println("Registation not success");
                        }
                    }
            }

            File f = new File("backup");
            if (f.exists()) {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder) ois.readObject();
            }

            int ch, ch2;
            char wish;
            x: do {

                System.out.println(
                        "\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:
                        System.out.println(
                                "\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.order(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.order(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.order(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.order(ch2 - 1, 1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if (ch2 > 40)
                            Hotel.deallocate(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.deallocate(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.deallocate(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.deallocate(ch2 - 1, 1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish = sc.next().charAt(0);
                if (!(wish == 'y' || wish == 'Y' || wish == 'n' || wish == 'N')) {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish = sc.next().charAt(0);
                }

            } while (wish == 'y' || wish == 'Y');

            Thread t = new Thread(new write(Hotel.hotel_ob));
            t.start();
        } catch (Exception e) {
            System.out.println("Not a valid input");
        }
    }
}

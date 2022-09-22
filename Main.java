/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Random;
import java.util.Scanner;
 class Main {
    public static boolean validate(String password) {
        if (password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"))
            return true;

        return false;
    }

    public static boolean symbol(String password) {
        if (password.matches(".*[@#$%].*"))
            return true;

        return false;
    }

    public static boolean uppcase(String password) {
        if (password.matches(".*[A-Z].*"))
            return true;

        return false;
    }

    public static boolean lowerCase(String password) {
        if (password.matches(".*[a-z].*"))
            return true;

        return false;
    }

    public static boolean digit(String password) {
        if (password.matches(".*\\d.*"))
            return true;

        return false;
    }

    public static boolean validate2(String pass) {
        boolean flag = true;
 System.out.println("given password="+pass);
        if (pass.length() < 8) {
            System.out.println("Password must more than 8");
            flag = false;
        } else if (!digit(pass)) {
            System.out.println("Password must contains digit");
            flag = false;
        } else if (!symbol(pass)) {
            System.out.println("Password must contains symbol");
            flag = false;
        } else if (!uppcase(pass)) {
            System.out.println("Password must contains Upper case");
            flag = false;
        } else if (!lowerCase(pass)) {
            System.out.println("Password must contains Lower case");
            flag = false;
        }

        return flag;
    }

    public static String randomString(int len) {
        Random rnd = new Random();
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%&";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);

       System.out.print("1. Generatae password 2. Test Password :");
        int option = scan.nextInt();

        switch (option) {
            case 1:
                System.out.println("inside case 1");
                String pass = "";
                System.out.print("Length of password >8 : ");
                int len = scan.nextInt();
                System.out.println("length="+len);
                int count = 0;
                while (true) {
                    if (len < 8)
                        break;

                    pass = randomString(len);
                    if (validate(pass)) {
                        break;
                    } else {
                        System.out.println("Retrying..");
                        count++;
                    }
                }

                System.out.print("Password generated = " + pass);
                break;
            case 2:
                 System.out.println("inside case 2");
                System.out.print("Password : ");
                String password = scan.next();
                if (validate2(password)) {
                    System.out.println("Pass");
                }
                break;
            default:
                break;
        }


    }
}
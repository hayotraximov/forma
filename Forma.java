import org.omg.CORBA.WStringSeqHelper;

import java.util.Random;
import java.util.Scanner;

public class Forma {
    // asosiy o'zgaruvchilar
    static String name[] = new String[1000];
    static String lastname[] = new String[1000];
    static String email[] = new String[1000];
    static String millati[] = new String[1000];
    static String jinsi[] = new String[1000];
    static String password[] = new String[1000];
    static long phonenumber[] = new long[1000];
    static String chat[][] = new String[10000][10000];
    static int age[] = new int[1000];
    static Scanner sc = new Scanner(System.in);
    // joriy login va parol
    static String currentEmail ="";
    static String currentPass ="";
    static int currentIndex =-1;
    static int indexf = -1;
    static boolean bool = false;
    static Random rand = new Random(9);

    public static void main(String[] args) {
        System.out.println("========= * NOMSIZ DASTURGA XUSH KELIBSIZ * =========");
        int x;
        int namex;
        while (true) {
            menu();
            x = sc.nextInt();
            switch (x) {
                case 1:
                    if (bool == true  && captca()) {
                        editor();
                    }
                    if (bool == false && captca()) {
                        signin();
                    }
                    break;
                case 2:
                    if (bool == false && captca()) {
                        signup();
                    }
                    if (bool == true  && captca()) {
                        closep();
                    }
                    break;
                case 3:
                    chat();
                    break;
                case 4:
                    System.out.print("Maxsus parolni kiriting: ");
                    namex = sc.nextInt();
                    if (namex == 55886699) {
                        list();
                    } else {
                        System.out.println("Xato kiritdingiz!");
                    }
                    break;
                case 0:
                    System.out.println("Dasturimizdan foydalanganingiz uchun tashakkur!");
                    System.exit(1);
            }
        }
    }

    public static void menu() {
        System.out.println("-- Kerakli bo'limni tanlang --");
        if (bool == true) {
            System.out.println("1.O'zgartirish");
            System.out.println("2.Profildan chiqish");
            System.out.println("3.Chat");

        }
        if (bool == false) {
            if (indexf>-1) {
                System.out.println("1.Kirish");
            }
        System.out.println("2.Ro'yxatdan o'tish");
        }
        System.out.println("4.Foydalanuvchilar ro'yxati");
        System.out.println("0.Chiqish");
        System.out.println("===============================");
        System.out.print("Buyruq => ");
    }

    public static void signin() {
        System.out.print("Emailni kiriting: ");
        currentEmail = sc.next();
        System.out.print("Parolni kiriting: ");
        currentPass = sc.next();
        for (int i = 0; i <= indexf; i++) {
            if (email[i].equals(currentEmail) && password[i].equals(currentPass)) {
                bool = true;
                currentIndex = i;
                return;
            }


        }
        System.out.println("Login yoki parol xato!");

    }

    public static void signup() {
        boolean bool = false;
        String emailx, namex,lastnamex, parolx, phonex;
        int agex;
        indexf++;

        while (true) {
            System.out.print("Ismingizni kiriting: ");
            namex = sc.next();
            if (namex.length()>=3) {
            name[indexf] = namex;
            break;
            } else {
                System.out.println("Siz ismni xato kiritdingiz!");
            }
        }

        while (true) {
            System.out.print("Familyangizni kiriting: ");
            lastnamex = sc.next();
            if (lastnamex.length()>=3) {
                lastname[indexf] = lastnamex;
                break;
            } else {
                System.out.println("Siz familyangizni xato kiritdingiz!");
            }
        }

        while (true) {
            System.out.print("Email: ");
            emailx = sc.next();
            if (isMail(emailx)) {
                email[indexf] = emailx;
                break;
            } else {
                System.out.println("Emailni xato kiritdingiz!");
            }
        }

        while (true) {
            System.out.print("Parol: ");
            parolx = sc.next();
            if (ispassword(parolx)) {
            password[indexf] = parolx;
            break;
            } else {
                System.out.println("Parol harflar va raqamlardan tashkil topgan bo'lishi kerak!");
            }
        }

        System.out.print("Jinsi: ");
        jinsi[indexf] = sc.next();
        System.out.print("Millati: ");
        millati[indexf] = sc.next();
        //skannerni yangilash
        sc = new Scanner(System.in);

        while (true) {
            System.out.print("Yoshingizni kiriting: ");
            agex = sc.nextInt();
            if (agex>=3) {
             age[indexf] = agex;
             break;
            }
        }

        while (true) {
            System.out.print("Telefon raqam: ");
            phonex = sc.next();
            if ( phonex.length()==12 && phonex.substring(0,3).equals("998")) {
                phonenumber[indexf] = Long.parseLong(phonex);
                break;
            } else {
                System.out.println("Siz telefon raqamni xato kiritdingiz!");
            }
        }

        System.out.println("Ro'yxatdan o'tish muvaffaqqiyatli amalga oshirildi!");
        System.out.println("================================================");
    }

    public static boolean captca() {
        int y=0, temp;
        boolean bool = false;
        y = rand.nextInt();
        System.out.println("Captcha => " + y);
        System.out.print("Captchani kiriting: ");
        temp = sc.nextInt();
        if (y==temp) {
            bool = true;
        } else {
            System.out.println("Xato kiritdingiz!");
        }
        return bool;
    }

    public static void editor() {
            int x = currentIndex, y = -1;
        System.out.println("1.Ism: " + name[x]);
        System.out.println("2.Familya: " + lastname[x]);
        System.out.println("3.Email: " + email[x]);
        System.out.println("4.Jinsi: " + jinsi[x]);
        System.out.println("5.Millati: " + millati[x]);
        System.out.println("6.Yoshi: " + age[x]);
        System.out.println("7.Telefon raqam: " + phonenumber[x]);
        System.out.println("0.Bekor qilish ");
        y = sc.nextInt();
        switch (y) {
            case 0: return;
            case 1:
                System.out.println("Ismni kiriting:");
                name[x] = sc.nextLine();
                break;
            case 2:
                System.out.println("Familyani kiriting:");
                lastname[x] = sc.nextLine();
                break;
            case 3:
                System.out.println("Familyani kiriting:");
                email[x] = sc.next();
                break;
            case 4:
                System.out.println("Familyani kiriting:");
                jinsi[x] = sc.next();
                break;
            case 5:
                System.out.println("Familyani kiriting:");
                millati[x] = sc.next();
                break;
            case 6:
                System.out.println("Yoshingizni kiriting:");
                age[x] = sc.nextInt();
                break;
            case 7:
                System.out.println("Telefon raqam:");
                phonenumber[x] = sc.nextInt();
        }
    }

    public static void closep() {
        bool = false;
        currentIndex = -1;
    }

     public static void list() {
        for (int i = 0; i <= indexf; i++) {
            System.out.println(i + "." + name[i] + " " +lastname[i]);
        }
    }

    public static boolean ispassword(String pass) {
        String nums[] = {"0","1","2","3","4","5","6","7","8","9"};
        String albhabet[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        char passch[] = new char[pass.length()];
        boolean num=false, str=false;
        for (int i = 0; i < pass.length(); i++) {

            for (int j = 0; j <= 9; j++) {
                if (pass.substring(i,i+1).equals(nums[j]) && num == false) {
                    num = true;
                    //System.out.println(j);
                    break;
                }
            }

            for (int j = 0; j <= 25; j++) {
                if (pass.substring(i,i+1).equals(albhabet[j]) && str == false) {
                    str = true;
                   // System.out.println(j);
                    break;
                }
            }
            if (num && str) {
                break;
            }
        }
        return num && str;
 }

    public static boolean isMail(String mail) {
        boolean bol = false;
        String old="";
        if (mail.length()>=6) {
            for (int i = 0; i < mail.length() - 4; i++) {
                if (mail.substring(i, i + 1).equals("@")) {
                    old = mail.substring(i);
                    break;
                }
            }
            for (int i = 0; i < old.length() - 2; i++) {
                if (old.substring(i, i + 1).equals(".")) {
                    bol = true;
                    break;
                }
            }
        } else {
            bol = false;
        }

        return bol;
    }

    public static void chat() {
        int x = currentIndex;
        int indexx;
        System.out.println("Kimga xabar yozmoqchisiz?(email)");
        String emailx = sc.next();
        for (int i = 0; i <indexf; i++) {
//            if (email[i].equals())
        }
    }
 }


// bosh harflar 65 - 90
// kichik harflar 97 - 122
// raqamlar 48-57;







//
//#Uyga_vazifa
//
//        ✅ Ro'yhatdan o'tish uchun form menyusiga o'xshagan qilib foydalanuvchi ma'lumotlarni yozib olish kerak. Misol uchun
//
//        1. Ismi
//        2. Familyasi
//        3. Yoshi
//        4. Elektron pochtasi
//        5. Telefon raqami
//        6. Jinsi
//        7. Millati
//
//        ❗️ So'ng shu kiritilayotgan malumotlarga murojat qilinganda qaytadan o'zgartirish ham mumkin bo'lsin. Ma'lumotlarga o'zgartirish kiritilayotgan paytda foydalanuvchining Elektron manzili va paroli tekshirilsin.
//
//        ❗️Foydalanuvchilar soni cheksiz bo'lishi ham mumkin. Tizimdan Xoxlagancha ro'yxatdan o'tish mumkin bo'lsin! Lekin degan joyi bor! Bitta User un xam qilib  tizimga kirish degan narsani qilib shaxsiy ma'lumotlarini o'zgartirish imkonini qilib berish! Programma faqat chiqish bosilganda to'xtasin!
//
//
//        30.09.2020   ⏰ 17: 40
import java.util.*;
public class Main {
    public static HashSet<String> arabic = new HashSet<String>();
    public static HashSet<String> roman = new HashSet<String>();
    public static HashSet<String> operation = new HashSet<String>();

    public static void check(String[] args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Некорректное количество аргументов");
        } else {
            arabic.add("1");
            arabic.add("2");
            arabic.add("3");
            arabic.add("4");
            arabic.add("5");
            arabic.add("6");
            arabic.add("7");
            arabic.add("8");
            arabic.add("9");
            arabic.add("10");

            roman.add("I");
            roman.add("II");
            roman.add("III");
            roman.add("IV");
            roman.add("V");
            roman.add("VI");
            roman.add("VII");
            roman.add("VIII");
            roman.add("IX");
            roman.add("X");


            operation.add("+");
            operation.add("-");
            operation.add("*");
            operation.add("/");
            if (arabic.contains(args[0]) && arabic.contains(args[2]) && operation.contains(args[1]) ||
                    roman.contains(args[0]) && roman.contains(args[2]) && operation.contains(args[1])) {
                //System.out.println("OK");
            } else {
                throw new Exception("Некорректная арифметическая операция");
            }
        }

    }

    public static int RomanToArabic(String number) {
        int arabicnumber = 0;
        switch (number) {
            case ("I"):
                arabicnumber = 1;
                break;
            case ("II"):
                arabicnumber = 2;
                break;
            case ("III"):
                arabicnumber = 3;
                break;
            case ("IV"):
                arabicnumber = 4;
                break;
            case ("V"):
                arabicnumber = 5;
                break;
            case ("VI"):
                arabicnumber = 6;
                break;
            case ("VII"):
                arabicnumber = 7;
                break;
            case ("VIII"):
                arabicnumber = 8;
                break;
            case ("IX"):
                arabicnumber = 9;
                break;
            case ("X"):
                arabicnumber = 10;
                break;
        }
        return arabicnumber;
    }
 public static String ArabicToRoman(int number)
 {
     String str = "";
     int numCopy = number;
     if (number == 100)
     {
         str = "C";
         return str;
     }
     if (number == 90)
     {
         str = "XC";
         return str;
     }
     else
     {
         int L = numCopy / 50;
         numCopy = (numCopy - 50 * L);
         int X = numCopy / 10;
         numCopy = (numCopy - 10 * X);
         for (int k=0; k<L; k++)
         {
             str += "L";
         }
         if (X == 4)
         {
             str += "XL";
         }
         else
         {
             for (int k=0; k<X; k++)
             {
                 str += "X";
             }
         }
         if (numCopy == 9)
         {
             str += "IX";
             return str;
         }
         else
         {
             if (numCopy == 4)
             {
                 str += "IV";
                 return str;
             }
             else
             {
                 int V = numCopy / 5;
                 numCopy = (numCopy - 5 * V);
                 for (int k=0; k<V; k++)
                 {
                     str += "V";
                 }
                 for (int k=0; k<numCopy; k++)
                 {
                     str += "I";
                 }
                 return str;
             }
         }
     }
 }
    public static String calc(String input) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] symbols = line.split(" ");
        check(symbols);
  /*for (int i = 0; i < 3; i++) {
   System.out.println(symbols[i]);
  }*/
        int result = 0;
        String sign = symbols[1];
        if (arabic.contains(symbols[0])) {
            switch (sign) {
                case ("+"):
                    result = Integer.valueOf(symbols[0]) + Integer.valueOf(symbols[2]);
                    break;
                case ("-"):
                    result = Integer.valueOf(symbols[0]) - Integer.valueOf(symbols[2]);
                    break;
                case ("*"):
                    result = Integer.valueOf(symbols[0]) * Integer.valueOf(symbols[2]);
                    break;
                case ("/"):
                    result = Integer.valueOf(symbols[0]) / Integer.valueOf(symbols[2]);
                    break;
            }
            System.out.println(result);
            return String.valueOf(result);
        } else {
            switch (sign) {
                case ("+"):
                    result = Integer.valueOf(RomanToArabic(symbols[0])) + Integer.valueOf(RomanToArabic(symbols[2]));
                    break;
                case ("-"):
                    result = Integer.valueOf(RomanToArabic(symbols[0])) - Integer.valueOf(RomanToArabic(symbols[2]));
                    if (result < 1) throw new Exception("Результат меньше единицы");
                    break;
                case ("*"):
                    result = Integer.valueOf(RomanToArabic(symbols[0])) * Integer.valueOf(RomanToArabic(symbols[2]));
                    break;
                case ("/"):
                    result = Integer.valueOf(RomanToArabic(symbols[0])) / Integer.valueOf(RomanToArabic(symbols[2]));
                    break;
            }
            System.out.println(ArabicToRoman(result));
            return ArabicToRoman(result);
        }
    }

    public static void main(String[] args)throws Exception {
        calc("");
    }
}

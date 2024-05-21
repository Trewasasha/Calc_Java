import java.util.Scanner;

class Calculator {

    public static boolean search(String[] arr, String x) {
        for (String i : arr) {
            if (i.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Number should be in range [1, 3999]");
        }
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите пример: ");
        String primer = sc.nextLine();
        if (primer.length() > 5) {
            throw new Error();
        }
        try {
            String[] parts = primer.split(" ");

            String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            int a = 0;
            int b = 0;

            String num1 = parts[0];
            String opr = parts[1];
            String num2 = parts[2];

            if (search(arab, num1) && search(arab, num2)){
                a = Integer.parseInt(num1);
                b = Integer.parseInt(num2);
            } else {
                a = get(num1);
                b = get(num2);
            }

            int ans = switch (opr) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> 0;
            };

            if ((search(arab, num1) && search(rim, num2)) || (search(arab, num2) && search(rim, num1))) {
                throw new Error();
            } else if ((search(rim, num1) && search(rim, num2))) {
                System.out.println(intToRoman(ans));
            } else if ((search(arab, num1) && search(arab, num2))) {
                System.out.println(ans);
            }

            if (a < 1 || b < 1) {
                throw new Error();
            }

        } catch (Exception e) {
            throw new Error();
        }
    }

    private static int get(String num) {
        return switch (num) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };
    }
}
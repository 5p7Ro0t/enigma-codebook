import java.util.*;

public class CodeBookGenerator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rm = new Random();
        System.out.print("Enter number of days : ");
        int days = scan.nextInt();
        System.out.println("OKH-Maschinenschlussel A Nr. 39");
        System.out.println("Date |  Walzenlage | Ringstellung  |       Steckerverbindungen       |   Kenngruppen   ");
        for (int i = days; i > 0; i--) {
            System.out.print(i);
            rotorselector(rm);
            rotorposition(rm);
            plugboard(rm);
            startmessage(rm);
            System.out.println();
        }
    }

    static void plugboard(Random rm) {
        ArrayList<Character> alphabets = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (char e = 'A'; e <= 'Z'; e++) {
            alphabets.add(e);
        }
        for (int o = 1; o <= 25; o += 2) {
            odd.add(o);
        }
        for (int ev = 0; ev <= 24; ev += 2) {
            even.add(ev);
        }
        // System.out.println(odd);
        // System.out.println(even);
        int evenlength = even.size();
        int oddlength = odd.size();
        System.out.print("\t");
        for (int j = 1; j < 11; j++) {
            
            // System.out.println("\n-----------------------------------------");
            int num1 = even.get(rm.nextInt(evenlength--));
            int num2 = odd.get(rm.nextInt(oddlength--));
            // System.out.println("Array : " + alphabets);
            // System.out.println("\nNum1 : " + num1);
            // System.out.println("Num2 : " + num2);
            System.out.print(alphabets.get(num1) + "" + alphabets.get(num2) + " ");
            char char2 = alphabets.get(num2);
            alphabets.remove(num1);
            for (int k = 0; k < alphabets.size(); k++) {
                if (alphabets.get(k) == char2) {
                    alphabets.remove(k);
                }
            }
            // even.remove(evenlength-1);
            // odd.remove(oddlength-1);
            // System.out.println("Array : " + alphabets);
            // System.out.println("Length : " + length);
        }
    }

    static void rotorselector(Random rm) {
        ArrayList<String> evenrotor = new ArrayList<>();
        ArrayList<String> oddrotor = new ArrayList<>();
        evenrotor.add("ii");evenrotor.add("iv");
        oddrotor.add("i"); oddrotor.add("iii");oddrotor.add("v");
        System.out.print("\t");
        for(int i = 0; i<3; i++){
            int selectrotorlist = rm.nextInt(2);
            if(selectrotorlist == 0){
                if(evenrotor.size() != 0){   
                    int index = rm.nextInt(evenrotor.size());
                    System.out.print(evenrotor.get(index) + " ");
                    evenrotor.remove(index);
                }
                else{
                    int index = rm.nextInt(oddrotor.size());
                    System.out.print(oddrotor.get(index) + " ");
                    oddrotor.remove(index);
                }
            }
            else{
                int index = rm.nextInt(oddrotor.size());
                System.out.print(oddrotor.get(index) + " ");
                oddrotor.remove(index);
            }
        }
    }

    static void rotorposition(Random rm) {
        System.out.print("\t" +(rm.nextInt(26)+1) + " " + (rm.nextInt(26)+1) + " " + (rm.nextInt(26)+1));
    }
    static void startmessage(Random rm){
        ArrayList<Character> alphabets = new ArrayList<>();
        for (char e = 'A'; e <= 'Z'; e++) {
            alphabets.add(e);
        }
        System.out.print("\t");
        for(int i = 0; i<4; i++){
            System.out.print(alphabets.get(rm.nextInt(26)) + "" + alphabets.get(rm.nextInt(26)) + "" + alphabets.get(rm.nextInt(26)) + " ");
        }
    }
}

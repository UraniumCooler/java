import java.util.HashSet;
import java.util.Scanner;

public class jagvetintevadjagskakalladig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> uniqueIntegers = new HashSet<>();

        System.out.println("Skriv in heltal (Klicka enter när du är klar):");

        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (uniqueIntegers.add(num)) {
                System.out.print(num + " ");
            }
        }

        scanner.close();
    }
}

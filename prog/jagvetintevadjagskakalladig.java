import java.util.Scanner;

public class jagvetintevadjagskakalladig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hur många tärningar vill du kasta? (Klicka enter när du är klar):"); // Frågar använder hur många tärningar som skas kastas.
        int amountDice = scanner.nextInt();  // Läser in antalet tärningaer

        System.out.println("Vilken typ av tärning vill du kasta? (Klicka enter när du är klar):"); // Frågar använder vilken typ av tärning dom vill kasta.
        System.out.println("1. d4");
        System.out.println("2. d6");
        System.out.println("3. d8");
        System.out.println("4. d10");
        System.out.println("5. d12");
        System.out.println("6. d20");
        System.out.println("7. d100");
        
        int typeDice = scanner.nextInt(); // Läser in vilken typ av tärning.

        int[] dice = new int[amountDice]; // Variabel för att se till att det kastas önskad mängd tärningar.

        String riggedInput = scanner.next(); // Scanner för lösenordet för dom riggade tärningarna.
        if (riggedInput.equals("Skylanders")) { // Deklarerar lösenordet för att rigga tärningarna.
            switch (typeDice) {
                case 1: // Situation ett för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d4"); 
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 2) + 3; // Riggade tärningen som bara kan ge 3 eller 4.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;
                
                case 2: // Situation två för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d6");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 3) + 4; // Riggade tärningen som bara kan ge 4 till 6.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;

                case 3: // Situation tre för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d8");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 4) + 5; // Riggade tärningen som bara kan ge 5 till 8.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;

                case 4: // Situation fyra för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d10");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 5) + 6; // Riggade tärningen som bara kan ge 6 till 10.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;

                case 5: // Situation fem för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d12");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 6) + 7; // Riggade tärningen som bara kan ge 7 till 12.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;

                case 6: // Situation sex för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d20");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 10) + 11; // Riggade tärningen som bara kan ge 11 till 20.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;
                
                case 7: // Situation sju för riggade tärningar.
                    System.out.println("Du valde " + amountDice + " d100");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 50) + 51; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                    break;
            }
        } else {
        
            switch (typeDice) {
                case 1: // Situation ett för origgade tärningar.
                    System.out.println("Du valde " + amountDice + " d4");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 4) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                break;
                case 2: // Situation två för origgade tärningar.
                    System.out.println("Du valde " + amountDice + " d6");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 6) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                break;
                case 3: // Situation tre för origgade tärningar.
                    System.out.println("Du valde " + amountDice + " d8");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 8) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    } 
                break;
                case 4: // Situation fyra för origgade tärningar.
                    System.out.println("Du valde " + amountDice + " d10");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 10) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    } 
                break;
                case 5: // Situation fem för origgade tärningar.
                    System.out.println("Du valde " + amountDice + " d12");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 12) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    } 
                break;
                case 6: // Situation sex för origgade tärningar.
                    System.out.println("Du valde " + amountDice + " d20");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 20) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    }
                break;
                case 7: // Situation sju för origgade tärningar.
                    System.out.println("Du valde " + amountDice + "d100");
                    for (int i = 0; i < amountDice; i++ ) {
                        dice[i] = (int) (Math.random() * 100) + 1; // Riggade tärningen som bara kan ge 51 till 100.
                        System.out.print(dice[i] + " "); // Lägger till ett mellanslag emellan varje siffra innan dom blir printade.
                    } 
                break;
                default:
                System.out.println("Missclick????? Välj SIFFRA mellan 1-7.");
            }
        }
        scanner.close();
    }
}

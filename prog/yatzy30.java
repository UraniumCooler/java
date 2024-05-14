import java.util.Scanner;

public class yatzy30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Skapar en Scanner för inläsning av använderens input

        int antalSpelare; // Variabel för att spara antalet spelare

        do { // do-while Loopen säkerställer att det finns åtminstone 2 spelare och max 5 spelare
            System.out.print("How many player are playing? (Min 2 players, Max 5 players)"); // Frågar användern hur många person som ska spela
            antalSpelare = scanner.nextInt(); // Läser in antalet spelare och svaret från användaren
            if (antalSpelare < 2) {
                System.out.println("You need atleast 2 players to play");
                // Meddelar spelaren att dom behöver minst 2 spelare.
            }
        } while (antalSpelare < 2 || antalSpelare > 5); // Upprepar loopen tills antalet spelare är minst 2 och max 5

        System.out.println("There are now " + antalSpelare + " players"); // Skriver ut antalet spelare
        scanner.nextLine(); // Förhindrar inläsning av resterande från scanner.nextInt();

        String[] spelareNamn = new String[antalSpelare]; // Skapar en array för att spara namnen på spelarna
        int[] spelareHP = new int[antalSpelare]; // Variabel för att hålla koll på varje spelares HP
        boolean[] spelareLevande = new boolean[antalSpelare]; // En array för att hålla koll på levande spelare 

        for (int i = 0; i < antalSpelare; i++) {
            System.out.print("Give name to player " + (i + 1) + ": ");// Loop för att fråga om namn för varje spelare
            spelareNamn[i] = scanner.nextLine(); // Läser in namnet på spelaren
            spelareHP[i] = 30; // Ger varje spelare 30 HP
            spelareLevande[i] = true; // Alla spelare ska börja med att vara levande
        }
        int levandeSpelare = antalSpelare; // Variabel för att hålla koll på antalet spelare som är levande 
        int nuvarandeSpelare = 0; //Variabel för aktuella spelare
        
        while (true) {
            if (levandeSpelare == 1) { // Om endast en spelare är levande
                for (int i = 0; i < antalSpelare; i++){
                    if (spelareLevande[i]) { // Hittar den sista aktiva spelaren
                        System.out.println("Player " + spelareNamn[i] + " wins"); // Deklarerar vinnande spelare
                        System.exit(0); //Avslutar programmet
                    }
                }
            }

            if (spelareHP[nuvarandeSpelare] > 0 && spelareLevande[nuvarandeSpelare]) { // Endast om spelare är levanade och har HP kvar
                System.out.println("\n" + spelareNamn[nuvarandeSpelare] + "'s turn:"); // Säger vems tur det är att spela
                System.out.println("You have " + spelareHP[nuvarandeSpelare] + " HP remaining"); // Hur mycket HP/Poäng/Liv dom har kvar

                int[] tarningar = new int[6]; // Skapar en array för tärningarna
                int kast = 1; // Variabel för antalet kast/rundor
                int sum = 0; //Variabel för att spara summan
                int raknareTarningar = 0; //Variabel för att hålla koll på hur många tärningar som totalts har valt
                int tarningarKvar = 6; // Variabel för antalet tärningar kvar att kasta

                while (true) { 
                    System.out.println("\nRound " + kast + ":"); //skriver ut hur många tärnings kast man har gjort
                    System.out.println("Your die: ");
                    for (int j = 0; j < tarningarKvar; j++) {
                        tarningar[j] = (int) (Math.random() * 6 ) + 1;
                        System.out.print(tarningar[j] + " "); // " " seperar de värden som blir ut skrivna
                    }
                    System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                    String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                    String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                    int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                    for (String s : array) { // Skriver ut allt i array;en en i taget
                        int vald = Integer.parseInt(s) - 1; // Konvertera en string s till ett heltal och tar bort 1
                        if (vald >= 0 && vald < 6) {// Kontrollerar så det är inom korrekt interval
                            System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                            sum += tarningar[vald]; // Adderar de valda värdet/värdenerna till summan
                            tarningar[vald] = (int) (Math.random() * 6) + 1; // Generara nästa sät tärningsvärde
                            valdaTarningar++;
                            raknareTarningar++;
                        } else {
                            System.out.println("Choose another or try again");
                        }
                    }
                    if (valdaTarningar == 0) {
                        System.out.println("\nYou have took keep one die minimum"); 
                        continue; // Hoppar över restan av loopen
                    }
                    if (raknareTarningar == 6) {
                        break; // bryter loopen
                    }
                    tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                    kast++; 
                }

                System.out.println("Sum of your chosen die: " + sum); // Skriver ut summan av de valda tärningarna

                if (sum > 30) {
                        System.out.println("You rolled over 30. Choose a player you want to attack (Number)");

                        for (int i = 0; i < antalSpelare; i++) {
                            if (i != nuvarandeSpelare && spelareLevande[i]) {
                                System.out.println((i +1) + ". " + spelareNamn[i]);
                            }
                        }

                        int forsvarandeSpelare = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (forsvarandeSpelare >= 0 && forsvarandeSpelare < antalSpelare && forsvarandeSpelare != nuvarandeSpelare && spelareLevande[forsvarandeSpelare]) {
                            System.out.println("You attacked " + spelareNamn[forsvarandeSpelare]);
                            if (sum == 31) {
                                
                                int attack = 0;
                                int ettorValda = 0;

                                System.out.println("You need to get 1's");
                                System.out.println("Your attack die: ");
                                for (int i = 0; i < 6; i++) {
                                    tarningar[i] = (int) (Math.random() * 6) + 1;
                                    System.out.print(tarningar[i] + " ");
                                    if (tarningar[i] == 1) {
                                        attack += 1;
                                    }
                                }
                                System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                                String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                                String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                                int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                                for (String s : array) { 
                                    int vald = Integer.parseInt(s) - 1; // Konvertera en string s till ett heltal och tar bort 1
                                    if (vald >= 0 && vald < 6 && tarningar[vald] == 1) {// Kontrollerar så det är inom korrekt interval och är en 1
                                        System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                                        ettorValda++;
                                    } else {
                                        System.out.println("Invalid choice or it's not a 1");
                                    }
                                }
                                if (ettorValda > 0) {
                                    int nyttAntal = 6 - ettorValda; // Räknar hur många tärningar som ska slås om
                                    int[] nyaTarningar = new int[nyttAntal]; // Array som sparar nya värden
                                    System.out.println("Rerolling " + nyttAntal + " die...");
                                    for (int i = 0, j = 0; i < 6; i++) {
                                        if (tarningar[i] != 1) {
                                            nyaTarningar[j++] = (int) (Math.random() * 6) + 1;
                                        }
                                    }
                                    System.out.println("New dice values: ");
                                    for (int i = 0; i < 6; i++) {
                                        System.out.print(nyaTarningar[i] + " ");
                                        if (nyaTarningar[i] == 1)
                                            attack += 2;
                                    }
                                }
                                
                                tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                                kast++;
                                int skada = attack * ettorValda;

                                System.out.println("You attacked " + spelareNamn[forsvarandeSpelare] + " with " + skada + " points of damage");
                                spelareHP[forsvarandeSpelare] -= skada;
                                if (spelareHP[forsvarandeSpelare] <= 0) {
                                    spelareLevande[forsvarandeSpelare] = false;
                                    levandeSpelare--;
                                } 
                                
                                
                            } else if (sum == 32) {
                                
                                int attack = 0;
                                int tvaValda = 0;

                                System.out.println("You need to get 2's");
                                System.out.println("Your attack die: ");
                                for (int i = 0; i < 6; i++) {
                                    tarningar[i] = (int) (Math.random() * 6) + 1;
                                    System.out.print(tarningar[i] + " ");
                                    if (tarningar[i] == 1) {
                                        attack += 1;
                                    }
                                }
                                System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                                String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                                String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                                int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                                for (String s : array) { 
                                    int vald = Integer.parseInt(s) - 1; // Konvertera en string s till ett heltal och tar bort 1
                                    if (vald >= 0 && vald < 6 && tarningar[vald] == 2) {// Kontrollerar så det är inom korrekt interval och är en 1
                                        System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                                        tvaValda++;
                                    } else {
                                        System.out.println("Invalid choice or it's not a 2");
                                    }
                                }
                                if (tvaValda > 0) {
                                    int nyttAntal = 6 - tvaValda; // Räknar hur många tärningar som ska slås om
                                    int[] nyaTarningar = new int[nyttAntal]; // Array som sparar nya värden
                                    System.out.println("Rerolling " + nyttAntal + " die...");
                                    for (int i = 0, j = 0; i < 6; i++) {
                                        if (tarningar[i] != 1) {
                                            nyaTarningar[j++] = (int) (Math.random() * 6) + 1;
                                        }
                                    }
                                    System.out.println("New dice values: ");
                                    for (int i = 0; i < 6; i++) {
                                        System.out.print(nyaTarningar[i] + " ");
                                        if (nyaTarningar[i] == 1)
                                            attack += 2;
                                    }
                                }
                                
                                tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                                kast++;
                                int skada = attack * tvaValda;

                                System.out.println("You attacked " + spelareNamn[forsvarandeSpelare] + " with " + skada + " points of damage");
                                spelareHP[forsvarandeSpelare] -= skada;
                                if (spelareHP[forsvarandeSpelare] <= 0) {
                                    spelareLevande[forsvarandeSpelare] = false;
                                    levandeSpelare--;
                                }


                            } else if (sum == 33) {

                                int attack = 0;
                                int treValda = 0;

                                System.out.println("You need to get 3's");
                                System.out.println("Your attack die: ");
                                for (int i = 0; i < 6; i++) {
                                    tarningar[i] = (int) (Math.random() * 6) + 1;
                                    System.out.print(tarningar[i] + " ");
                                    if (tarningar[i] == 1) {
                                        attack += 3;
                                    }
                                }
                                System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                                String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                                String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                                int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                                for (String s : array) { 
                                    int vald = Integer.parseInt(s) - 3; // Konvertera en string s till ett heltal och tar bort 1
                                    if (vald >= 0 && vald < 6 && tarningar[vald] == 1) {// Kontrollerar så det är inom korrekt interval och är en 1
                                        System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                                        treValda++;
                                    } else {
                                        System.out.println("Invalid choice or it's not a 3");
                                    }
                                }
                                if (treValda > 0) {
                                    int nyttAntal = 6 - treValda; // Räknar hur många tärningar som ska slås om
                                    int[] nyaTarningar = new int[nyttAntal]; // Array som sparar nya värden
                                    System.out.println("Rerolling " + nyttAntal + " die...");
                                    for (int i = 0, j = 0; i < 6; i++) {
                                        if (tarningar[i] != 1) {
                                            Tarningar[j++] = (int) (Math.random() * 6) + 1;
                                        }
                                    }
                                    System.out.println("New dice values: ");
                                    for (int i = 0; i < 6; i++) {
                                        System.out.print(nyaTarningar[i] + " ");
                                        if (nyaTarningar[i] == 1)
                                            attack += 3;
                                    }
                                }
                                
                                tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                                kast++;
                                int skada = attack * treValda;

                                System.out.println("You attacked " + spelareNamn[forsvarandeSpelare] + " with " + skada + " points of damage");
                                spelareHP[forsvarandeSpelare] -= skada;
                                if (spelareHP[forsvarandeSpelare] <= 0) {
                                    spelareLevande[forsvarandeSpelare] = false;
                                    levandeSpelare--;
                                }


                            } else if (sum == 34) {

                                int attack = 0;
                                int fyraValda = 0;

                                System.out.println("You need to get 4's");
                                System.out.println("Your attack die: ");
                                for (int i = 0; i < 6; i++) {
                                    tarningar[i] = (int) (Math.random() * 6) + 1;
                                    System.out.print(tarningar[i] + " ");
                                    if (tarningar[i] == 1) {
                                        attack += 4;
                                    }
                                }
                                System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                                String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                                String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                                int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                                for (String s : array) { 
                                    int vald = Integer.parseInt(s) - 1; // Konvertera en string s till ett heltal och tar bort 1
                                    if (vald >= 0 && vald < 6 && tarningar[vald] == 4) {// Kontrollerar så det är inom korrekt interval och är en 1
                                        System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                                        fyraValda++;
                                    } else {
                                        System.out.println("Invalid choice or it's not a 4");
                                    }
                                }
                                if (fyraValda > 0) {
                                    int nyttAntal = 6 - fyraValda; // Räknar hur många tärningar som ska slås om
                                    int[] nyaTarningar = new int[nyttAntal]; // Array som sparar nya värden
                                    System.out.println("Rerolling " + nyttAntal + " die...");
                                    for (int i = 0, j = 0; i < 6; i++) {
                                        if (tarningar[i] != 1) {
                                            nyaTarningar[j++] = (int) (Math.random() * 6) + 1;
                                        }
                                    }
                                    System.out.println("New dice values: ");
                                    for (int i = 0; i < 6; i++) {
                                        System.out.print(nyaTarningar[i] + " ");
                                        if (nyaTarningar[i] == 1)
                                            attack += 4;
                                    }
                                }
                                
                                tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                                kast++;
                                int skada = attack * fyraValda;

                                System.out.println("You attacked " + spelareNamn[forsvarandeSpelare] + " with " + skada + " points of damage");
                                spelareHP[forsvarandeSpelare] -= skada;
                                if (spelareHP[forsvarandeSpelare] <= 0) {
                                    spelareLevande[forsvarandeSpelare] = false;
                                    levandeSpelare--;
                                }


                            } else if (sum == 35) {

                                int attack = 0;
                                int femValda = 0;

                                System.out.println("You need to get 5's");
                                System.out.println("Your attack die: ");
                                for (int i = 0; i < 6; i++) {
                                    tarningar[i] = (int) (Math.random() * 6) + 1;
                                    System.out.print(tarningar[i] + " ");
                                    if (tarningar[i] == 1) {
                                        attack += 5;
                                    }
                                }
                                System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                                String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                                String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                                int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                                for (String s : array) { 
                                    int vald = Integer.parseInt(s) - 1; // Konvertera en string s till ett heltal och tar bort 1
                                    if (vald >= 0 && vald < 6 && tarningar[vald] == 5) {// Kontrollerar så det är inom korrekt interval och är en 1
                                        System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                                        femValda++;
                                    } else {
                                        System.out.println("Invalid choice or it's not a 1");
                                    }
                                }
                                if (femValda > 0) {
                                    int nyttAntal = 6 - femValda; // Räknar hur många tärningar som ska slås om
                                    int[] nyaTarningar = new int[nyttAntal]; // Array som sparar nya värden
                                    System.out.println("Rerolling " + nyttAntal + " die...");
                                    for (int i = 0, j = 0; i < 6; i++) {
                                        if (tarningar[i] != 1) {
                                            nyaTarningar[j++] = (int) (Math.random() * 6) + 1;
                                        }
                                    }
                                    System.out.println("New dice values: ");
                                    for (int i = 0; i < 6; i++) {
                                        System.out.print(nyaTarningar[i] + " ");
                                        if (nyaTarningar[i] == 1)
                                            attack += 5;
                                    }
                                }
                                
                                tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                                kast++;
                                int skada = attack * femValda;

                                System.out.println("You attacked " + spelareNamn[forsvarandeSpelare] + " with " + skada + " points of damage");
                                spelareHP[forsvarandeSpelare] -= skada;
                                if (spelareHP[forsvarandeSpelare] <= 0) {
                                    spelareLevande[forsvarandeSpelare] = false;
                                    levandeSpelare--;
                                }

                            } else {
                                int attack = 0;
                                int sexValda = 0;

                                System.out.println("You need to get 6's");
                                System.out.println("Your attack die: ");
                                for (int i = 0; i < 6; i++) {
                                    tarningar[i] = (int) (Math.random() * 6) + 1;
                                    System.out.print(tarningar[i] + " ");
                                    if (tarningar[i] == 1) {
                                        attack += 6;
                                    }
                                }
                                System.out.println("\nWhich die do you want to keep? (Remember to uses spaces, eg `1 2 3`) (Reminder it's the slot you choose)");
                                String value = scanner.nextLine(); //Läser in vilken tärning som ska behållas
                                String[] array = value.split(" "); // Delar upp inmatningen i en array baserat på hur många mellanslag som anges
                                int valdaTarningar = 0; // Variabel för antalet sparade/valda tärningar. Återsålls vid varje kast
                                for (String s : array) { 
                                    int vald = Integer.parseInt(s) - 1; // Konvertera en string s till ett heltal och tar bort 1
                                    if (vald >= 0 && vald < 6 && tarningar[vald] == 6) {// Kontrollerar så det är inom korrekt interval och är en 1
                                        System.out.println("You choose: " + tarningar[vald]); // Skriver ut de tal spelaren valt
                                        sexValda++;
                                    } else {
                                        System.out.println("Invalid choice or it's not a 2");
                                    }
                                }
                                if (sexValda > 0) {
                                    int nyttAntal = 6 - sexValda; // Räknar hur många tärningar som ska slås om
                                    int[] nyaTarningar = new int[nyttAntal]; // Array som sparar nya värden
                                    System.out.println("Rerolling " + nyttAntal + " die...");
                                    for (int i = 0, j = 0; i < 6; i++) {
                                        if (tarningar[i] != 1) {
                                            nyaTarningar[j++] = (int) (Math.random() * 6) + 1;
                                        }
                                    }
                                    System.out.println("New dice values: ");
                                    for (int i = 0; i < 6; i++) {
                                        System.out.print(nyaTarningar[i] + " ");
                                        if (nyaTarningar[i] == 1)
                                            attack += 2;
                                    }
                                }
                                
                                tarningarKvar -= valdaTarningar; //Tar bort antalet behållna tärningar från antalet tärningar att kasta
                                kast++;
                                int skada = attack * sexValda;

                                System.out.println("You attacked " + spelareNamn[forsvarandeSpelare] + " with " + skada + " points of damage");
                                spelareHP[forsvarandeSpelare] -= skada;
                                if (spelareHP[forsvarandeSpelare] <= 0) {
                                    spelareLevande[forsvarandeSpelare] = false;
                                    levandeSpelare--;
                                
                                }
                            }

                        }
                } else {
                    spelareHP[nuvarandeSpelare] -= (30 - sum); // Tar bort differense från spelarens HP
                    System.out.println("Your new HP: " + spelareHP[nuvarandeSpelare]);
                    if (spelareHP[nuvarandeSpelare] <= 0) { // Om spelaren når eller går under 0 HP
                        spelareLevande[nuvarandeSpelare] = false; // Registrerar spelaren som död
                        levandeSpelare--; // Drar bort en från mängden levande spelare
                    }
                }
            }
            nuvarandeSpelare++; //Går till nästa spelare
            if (nuvarandeSpelare == antalSpelare) { 
                nuvarandeSpelare = 0; // Om det är sista spelaren gå till första
            }
            scanner.close();
        }
        
    }
    
}

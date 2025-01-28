package main;
import java.util.Scanner;

public class ConvertitoreValuta {
    
    // Tassi di cambio di esempio (valore relativo a 1 EUR)
    private static final double USD_TO_EUR = 0.93;
    private static final double EUR_TO_USD = 1.08;
    private static final double EUR_TO_GBP = 0.86;
    private static final double GBP_TO_EUR = 1.16;
    private static final double USD_TO_GBP = 0.80;
    private static final double GBP_TO_USD = 1.25;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Benvenuto nel Convertitore di Valuta!");
        
        // Seleziona la valuta di partenza
        System.out.println("Scegli la valuta di partenza:");
        System.out.println("1. Euro (EUR)");
        System.out.println("2. Dollaro Americano (USD)");
        System.out.println("3. Sterlina Inglese (GBP)");
        System.out.print("Inserisci la tua scelta (1/2/3): ");
        int sceltaPartenza = scanner.nextInt();
        
        // Seleziona la valuta di destinazione
        System.out.println("Scegli la valuta di destinazione:");
        System.out.println("1. Euro (EUR)");
        System.out.println("2. Dollaro Americano (USD)");
        System.out.println("3. Sterlina Inglese (GBP)");
        System.out.print("Inserisci la tua scelta (1/2/3): ");
        int sceltaDestinazione = scanner.nextInt();
        
        // Chiedi l'importo da convertire con un controllo di validità
        double importo = 0;
        boolean inputValido = false;
        
        while (!inputValido) {
            System.out.print("Inserisci l'importo da convertire: ");
            if (scanner.hasNextDouble()) {
                importo = scanner.nextDouble();
                if (importo > 0) {
                    inputValido = true;
                } else {
                    System.out.println("L'importo deve essere un numero positivo. Riprova.");
                }
            } else {
                System.out.println("Input non valido. Devi inserire un numero. Riprova.");
                scanner.next(); // Scarta l'input non valido
            }
        }
        
        // Esegui la conversione
        double risultato = converti(sceltaPartenza, sceltaDestinazione, importo);
        
        // Mostra il risultato
        if (risultato != -1) {
            System.out.println("Risultato: " + importo + " valuta di partenza = " + risultato + " valuta di destinazione.");
        } else {
            System.out.println("Conversione non valida.");
        }
        
        scanner.close();
    }
    
    // Metodo per effettuare la conversione in base alla scelta dell'utente
    public static double converti(int partenza, int destinazione, double importo) {
        double risultato = -1;
        
        // Conversioni tra le valute
        if (partenza == 1 && destinazione == 2) {
            risultato = importo * EUR_TO_USD;
        } else if (partenza == 1 && destinazione == 3) {
            risultato = importo * EUR_TO_GBP;
        } else if (partenza == 2 && destinazione == 1) {
            risultato = importo * USD_TO_EUR;
        } else if (partenza == 2 && destinazione == 3) {
            risultato = importo * USD_TO_GBP;
        } else if (partenza == 3 && destinazione == 1) {
            risultato = importo * GBP_TO_EUR;
        } else if (partenza == 3 && destinazione == 2) {
            risultato = importo * GBP_TO_USD;
        } else if (partenza == destinazione) {
            risultato = importo; // Se sono le stesse valute
        }
        
        return risultato;
    }
}
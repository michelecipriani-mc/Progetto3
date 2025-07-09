// Gestione di una Piattaforma di Notifiche Personalizzabili

// Descrizione generale:

// In un gruppo di lavoro, progettate un’applicazione Java che simuli una piattaforma in cui utenti ricevono notifiche da una
// sorgente centrale, e possono personalizzarne il contenuto o la forma. L’applicazione deve integrare tre design pattern
// obbligatori: Singleton, Decorator, Observer.


// Obiettivo didattico:

// Comprendere e applicare design pattern reali in un sistema coeso

// Lavorare in gruppo su componenti modulari

// Usare Java in modo avanzato con progettazione orientata agli oggetti


// Requisiti obbligatori:

// 1. Pattern Singleton – Gestore Notifiche Unico

// Create una classe NotificationManager che:

// È una Singleton

// Rappresenta la sorgente centrale da cui partono le notifiche

// Contiene un metodo inviaNotifica(String messaggio)

// 2. Pattern Observer – Utenti che ricevono notifiche

// Ogni utente è un oggetto che:

// Implementa un’interfaccia Observer

// Si registra a NotificationManager

// Riceve il messaggio e lo stampa sul terminale

// Deve poter essere aggiunto e rimosso dinamicamente

// 3. Pattern Decorator – Personalizzazione delle notifiche

// Create decoratori per modificare il messaggio prima della stampa da parte dell’utente:

// Aggiunta di timestamp

// Conversione in maiuscolo/minuscolo

// Aggiunta di emoji o prefissi


// Ogni utente può essere decorato in modo diverso.


// Esempio funzionale atteso:

// Il NotificationManager invia “Sistema in manutenzione”

// L’utente 1 stampa: [2025-07-09 10:30] SISTEMA IN MANUTENZIONE

// L’utente 2 stampa: Notifica: Sistema in manutenzione

// L’utente 3 non è più iscritto e non riceve nulla

import java.util.Scanner;

public class GestioneNotifiche {
    public static void main(String[] args) {
         //dichiaro uno scanner per gli interi
        Scanner myScannerInt = new Scanner(System.in);
        Scanner myScannerStr = new Scanner(System.in);
        NotificationManager notManager = NotificationManager.getInstance();
        //dichiaro una variabile per la scelta
        int scelta;
        //attraverso un do-while inizio il ciclo per la gestione del menù
        do {
            //Menù
            System.out.println("===MENù===");
            System.out.println("1 - Aggiungi utente");
            System.out.println("2 - Invia notifica");
            System.out.println("3 - Stampa notifica");
            System.out.println("4 - Esci");
            //prendo l'input di scelta e lo salvo nella variabile scelta
            scelta = myScannerInt.nextInt();
            //effttuo una verifica di correttezza della scelta altrimenti richiedo 
            while (scelta < 1 || scelta > 4) {
                System.out.println("Errore: comando non valido, inserisci un comando valido: ");
                scelta = myScannerInt.nextInt();
            }
            //gestisco la scelta con uno switch
            switch (scelta) {
                //nel primo caso 
                case 1:
                    //chiedo il nome per la creazione dell'utente
                    System.out.println("Inserisci nome utente: ");
                    //salvo l'input nella variabile
                    String nomeUtente = myScannerStr.nextLine();
                    //creo utente
                    notManager.register(new Utente(nomeUtente));
                    break;
                case 2:
                    //chiedo il messagio per la creazione dell'utente
                    System.out.println("Inserisci messaggio: ");
                    //salvo l'input nella variabile
                    String messaggio = myScannerStr.nextLine();
                    //chiamoil metodo e paso il messaggio
                    notManager.inviaNotifica(messaggio);
                    break;
                case 3:
                    //possibili scelte di stampa
                    System.out.println("1 - Saluta");
                    System.out.println("2 - Maiuscolo");
                    System.out.println("3 - emoji");
                    int risposta = myScannerInt.nextInt();
                    notManager.creaNotifica(risposta);
                    break;
                //nel caso di default
                default: 
                    //se la scelta è 4 stampo l'uscita
                    if (scelta == 4) {
                        System.out.println("Programma terminato!");
                    //altrimenti stampo l'errore
                    } else {
                        System.out.println("Errore: comando non valido, inserisci un comando valido:");
                    }
                    break;
            }
        } while (scelta != 4); //controllo lo stato della condizione
        //chiusura degli scanner
        myScannerStr.close();
        myScannerInt.close();
    }
}
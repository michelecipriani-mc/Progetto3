import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private static NotificationManager instance; 
    private static Notifica notifica;

    private final List<Observer> observers = new ArrayList<>();

    private NotificationManager() {}

    //Imposta il NotificationManager come unica istanza
    public static NotificationManager getInstance() { 
        if (instance == null) {
            instance = new NotificationManager();
            notifica = new NotificaBase();
        }
        return instance;
    }

    //Metodi per registrare, cancellare e inviare
    public void register(Observer observer) {
        observers.add(observer);
        System.out.println("Utente aggiunto.");
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
        System.out.println("Utente rimosso.");
    }

    public void inviaNotifica(String messaggio) {
        for (Observer observer : observers) {
            observer.update(messaggio);
            notifica.creaNotifica(((Utente)observer).getId(), messaggio);
        }
    }

    public void creaNotifica(int tipo){
        switch (tipo){
            case 1 : 
                notifica = new NotificaTimestamp(notifica);
            break;

            case 2 : 
                notifica = new NotificaMaiuscolo(notifica);
            break;

            case 3 : 
                notifica = new NotificaConSmileEmoji(notifica);
            break;

            case 4 : 
                notifica = new NotificaConSaluto(notifica);
            break;

            default : 
                System.out.println("Scelta non valida.");
            break;
        }
    }
}
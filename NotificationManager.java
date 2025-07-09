import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private static NotificationManager instance;
    private Notifica notifica = new NotificaBase();

    private final List<Observer> observers = new ArrayList<>();

    private NotificationManager() {
    }

    // Imposta il NotificationManager come unica istanza
    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    // Metodi per registrare, cancellare e inviare
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
            notifica.creaNotifica(((Utente) observer).getId(), messaggio);
        }
    }

    public void creaNotifica(int tipo, String messaggio) {
        System.out.println("Come vuoi stampare la notifica?");
        System.out.println("1 - Saluta");
        System.out.println("2 - Maiuscolo");
        System.out.println("3 - emoji");
        switch (tipo) {
            case 1:
                notifica = new NotificaTimestamp(notifica);
                inviaNotifica(messaggio);
                break;

            case 2:
                notifica = new NotificaMaiuscolo(notifica);
                inviaNotifica(messaggio);

                break;

            case 3:
                notifica = new NotificaConSmileEmoji(notifica);
                inviaNotifica(messaggio);

                break;

            case 4:
                notifica = new NotificaConSaluto(notifica);
                inviaNotifica(messaggio);

                break;

            default:
                System.out.println("Scelta non valida.");
                break;
        }

    }
}
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

    public void setNotifica(Notifica notifica) {
        this.notifica = notifica;
    }

    public void inviaNotifica(int tipo, String messaggio) {
        for (Observer observer : observers) {

            notifica.creaNotifica(tipo, messaggio);

            observer.update(messaggio, notifica);
        }
    }

    public void creaNotifica(int tipo, String messaggio) {
        System.out.println("Come vuoi stampare la notifica?");
        System.out.println("1 - Saluta");
        System.out.println("2 - Maiuscolo");
        System.out.println("3 - emoji");
        switch (tipo) {
            case 1:
                setNotifica(new NotificaTimestamp(notifica));
                break;

            case 2:
                setNotifica(new NotificaMaiuscolo(notifica));
                break;

            case 3:
                setNotifica(new NotificaConSmileEmoji(notifica));
                break;

            case 4:
                setNotifica(new NotificaConSaluto(notifica));
                break;

            default:
                System.out.println("Scelta non valida.");
                break;
        }

    }

    public Notifica getNotifica() {
        return notifica;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
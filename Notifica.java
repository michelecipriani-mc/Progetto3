
// Component interface

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Notifica {
    String creaNotifica(int numeroUtente, String messaggio);
}

// implementazione concreta dell'interfaccia component
class NotificaBase implements Notifica {
    @Override
    public String creaNotifica(int numeroUtente, String messaggio) {
        return "L'utente #" + numeroUtente + " " + messaggio;
    }
}

// Classe NotificaSpecializzata astratta, devve implementare Component
abstract class NotificaSpecializzata implements Notifica {
    protected Notifica notificaSpecializzata;

    public NotificaSpecializzata(Notifica notificaSpecializzata) {
        this.notificaSpecializzata = notificaSpecializzata;
    }

    @Override
    public String creaNotifica(int numeroUtente, String messaggio) {
        return notificaSpecializzata.creaNotifica(numeroUtente, messaggio);
    }
}

// Notifica con TimeStamp
class NotificaTimestamp extends NotificaSpecializzata {
    public NotificaTimestamp(Notifica notificaSpecializzata) {
        super(notificaSpecializzata);
    }

    @Override
    public String creaNotifica(int numeroUtente, String messaggio) {

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                + super.creaNotifica(numeroUtente, messaggio);
    }
}

// Notifica in Maiuscolo
class NotificaMaiuscolo extends NotificaSpecializzata {
    public NotificaMaiuscolo(Notifica notificaSpecializzata) {
        super(notificaSpecializzata);
    }

    @Override
    public String creaNotifica(int numeroUtente, String messaggio) {
        return super.creaNotifica(numeroUtente, messaggio).toUpperCase();
    }
}

// Notifica che aggiunge :-)
class NotificaConSmileEmoji extends NotificaSpecializzata {
    public NotificaConSmileEmoji(Notifica notificaSpecializzata) {
        super(notificaSpecializzata);
    }

    @Override
    public String creaNotifica(int numeroUtente, String messaggio) {
        return super.creaNotifica(numeroUtente, messaggio) + " :-)";
    }
}

// Notifica con saluto iniziale
class NotificaConSaluto extends NotificaSpecializzata {
    public NotificaConSaluto(Notifica notificaSpecializzata) {
        super(notificaSpecializzata);
    }

    @Override
    public String creaNotifica(int numeroUtente, String messaggio) {
        return "Salve! " + super.creaNotifica(numeroUtente, messaggio);
    }
}

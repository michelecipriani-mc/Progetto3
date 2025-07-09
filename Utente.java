public abstract class Utente implements Observer {

    private String nome;
    private static int contatoreUtenti = 0; 
    private int id;                        
    private Notifica decorator;

    public User() {
        this.nome = nome;
        this.id = ++contatoreUtenti;
    }

    public int getId() {
        return id;
    }

    public static int getNumeroTotaleUtenti() {
        return contatoreUtenti;
    }

    public void setDecorator(Notifica decorator) {
        this.decorator = decorator;
    }

    @Override
    public void update(String messaggio) {
        if (decorator != null) {
            messaggio = decorator.elabora(messaggio);
        }
        System.out.println("[Utente " + id + "] " + messaggio);
    }
}
public class Utente implements Observer {

    private String nome;

    private static int contatoreUtenti = 0;
    private int id;


    public Utente(String nome) {
        this.nome = nome;
        this.id = ++contatoreUtenti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public static int getNumeroTotaleUtenti() {
        return contatoreUtenti;
    }

    @Override
    public void update(String messaggio, Notifica notificaNuova) {

        messaggio = notificaNuova.creaNotifica(getId(), messaggio);


        System.out.println("[Utente " + id + "] " + messaggio);
    }
}
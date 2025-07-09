public class PatternDecorator {
    
}

// Interfaccia Component
interface Messaggio{
    void operation();
}

// Componente Concreto
class MessaggioBase implements Messaggio {
    public void operation() {
        System.out.println("Operazione base");
    }
}

// Decorator astratto
abstract class Decorator implements Messaggio {
    protected Messaggio messaggio;
    
    public Decorator(Messaggio messaggio) {
        this.messaggio = messaggio;
    }

    public void operation() {
        messaggio.operation();
    }
}

// Decoratore Concreto
class TimestampDecorator extends Decorator {
    public TimestampDecorator(Messaggio messaggio) {
        super(messaggio);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}

// Decoratore Concreto
class UppercaseDecorator extends Decorator {
    public UppercaseDecorator(Messaggio messaggio) {
        super(messaggio);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}

// Decoratore Concreto
class LowercaseDecorator extends Decorator {
    public LowercaseDecorator(Messaggio messaggio) {
        super(messaggio);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}

// Decoratore Concreto
class SmilingfaceDecorator extends Decorator {
    public SmilingfaceDecorator(Messaggio messaggio) {
        super(messaggio);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}

// Decoratore Concreto
class SmilingemojiDecorator extends Decorator {
    public SmilingemojiDecorator(Messaggio messaggio) {
        super(messaggio);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}

// Decoratore Concreto
class GreetingPrefixDecorator extends Decorator {
    public GreetingPrefixDecorator(Messaggio messaggio) {
        super(messaggio);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}
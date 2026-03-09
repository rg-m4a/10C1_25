package czg.util;

/**
 * Behälter für einen beliebigen Wert. Hilfreich, da die
 * Getter- und Setter-Methoden z.B. in Lambdas verwendet
 * werden können, oder um Zugriff auf eine Variable zu
 * gewähren, ohne Getter- und Setter-Methoden zu einer
 * Klasse hinzuzufügen und diese einzeln als Lambdas
 * übergeben zu müssen.
 * @param <T> Datentyp
 */
public class Capsule<T> {

    /**
     * Gespeicherter Wert
     */
    private T value;

    /**
     * Neue Kapsel erstellen
     * @param value Gespeicherter Wert
     */
    public Capsule(T value) {
        this.value = value;
    }

    /**
     * Getter-Methode
     * @return Den gespeicherten Wert
     */
    public T get() {
        return value;
    }

    /**
     * Setter-Methode
     * @param value Neuer Wert
     * @return Den neuen Wert
     */
    public T set(T value) {
        return (this.value = value);
    }
}

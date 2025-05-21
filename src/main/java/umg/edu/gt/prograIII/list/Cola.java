package umg.edu.gt.prograIII.list;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }

    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (fin == null) { // cola vacía
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) {
            return null; // o lanzar excepción si prefieres
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) { // si la cola quedó vacía
            fin = null;
        }
        tamaño--;
        return dato;
    }

    public T peek() {
        if (estaVacia()) {
            return null;
        }
        return frente.getDato();
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int tamanio() {
        return tamaño;
    }
}

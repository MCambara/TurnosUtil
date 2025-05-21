package umg.edu.gt.prograIII.testObjeto;

public class Persona implements Comparable<Persona> {
    int edad;
    String nombre;
    String apellido;
    int telefono;

    public Persona(int edad, String nombre, String apellido, int telefono) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    @Override
    public int compareTo(Persona otra) {
        // Comparar por edad
        return Integer.compare(this.edad, otra.edad);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + edad + ")";
    }
}

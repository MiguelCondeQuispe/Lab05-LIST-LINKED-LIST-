public class Tarea {
    String descripcion;
    int prioridad;

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return descripcion + " (Prioridad: " + prioridad + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tarea) {
            Tarea otra = (Tarea) obj;
            return this.descripcion.equals(otra.descripcion) && this.prioridad == otra.prioridad;
        }
        return false;
    }
}

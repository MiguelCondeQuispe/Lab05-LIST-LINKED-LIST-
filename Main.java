import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        int opcion;
        do {
            System.out.println("\n--- MENÚ DEL GESTOR DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Mostrar tareas actuales");
            System.out.println("4. Verificar si existe una tarea");
            System.out.println("5. Invertir lista de tareas");
            System.out.println("6. Transferir tarea a tareas completadas");
            System.out.println("7. Mostrar tareas completadas");
            System.out.println("8. Mostrar tarea más prioritaria");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese descripción de la tarea: ");
                    String desc = sc.nextLine();
                    System.out.print("Ingrese prioridad (número): ");
                    int prio = sc.nextInt();
                    gestor.agregarTarea(new Tarea(desc, prio));
                    System.out.println("Tarea agregada.");
                    break;

                case 2:
                    System.out.print("Ingrese descripción de la tarea a eliminar: ");
                    String descEliminar = sc.nextLine();
                    System.out.print("Ingrese prioridad (número): ");
                    int prioEliminar = sc.nextInt();
                    if (gestor.eliminarTarea(new Tarea(descEliminar, prioEliminar))) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Tareas actuales:");
                    gestor.imprimirTareas();
                    break;

                case 4:
                    System.out.print("Ingrese descripción de la tarea a buscar: ");
                    String descBuscar = sc.nextLine();
                    System.out.print("Ingrese prioridad (número): ");
                    int prioBuscar = sc.nextInt();
                    boolean existe = gestor.contieneTarea(new Tarea(descBuscar, prioBuscar));
                    System.out.println(existe ? "La tarea existe." : "La tarea no existe.");
                    break;

                case 5:
                    gestor.invertirTareas();
                    System.out.println("Tareas invertidas.");
                    break;

                case 6:
                    System.out.print("Ingrese descripción de la tarea a transferir: ");
                    String descTrans = sc.nextLine();
                    System.out.print("Ingrese prioridad (número): ");
                    int prioTrans = sc.nextInt();
                    gestor.transferirATareasCompletadas(new Tarea(descTrans, prioTrans));
                    System.out.println("Tarea transferida (si existía).");
                    break;

                case 7:
                    gestor.mostrarTareasCompletadas();
                    break;

                case 8:
                    Tarea tPrioritaria = (Tarea) gestor.obtenerTareaMasPrioritaria();
                    System.out.println("Tarea más prioritaria: " + (tPrioritaria != null ? tPrioritaria : "No hay tareas."));
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}

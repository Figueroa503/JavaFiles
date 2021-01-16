import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        Control ctr = new Control();
        int opcion;

        String path = "registro.txt";
      

        String ID, name, age;

        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Que opcion desea\n1. Crear archivo\n2. escribir\n3. leer\n4. limpiar\n.5 borrar\n6. eliminar registro\n Otro numero para salir"));

        while (opcion >= 1 && opcion <= 6) {

            switch (opcion) {
                case 1:

                    ctr.crearArchivo(path);

                    break;

                case 2:

                    ID = JOptionPane.showInputDialog(null, "Ingrese un Id ejemplo 0001");
                    name = JOptionPane.showInputDialog(null, "Ingrese un nombre");
                    age = JOptionPane.showInputDialog(null, "Ingrese una edad");
                    ctr.escribirArchivo(ID, name, age);

                    break;
                case 3:

                ctr.leerTexto(path);

                    break;
                case 4:

                    ctr.limpiarArchivo(path);

                    break;
                case 5:

                ctr.eliminarArchivo(path);
                    break;
                case 6:

               String delete =  JOptionPane.showInputDialog(null, "ID del registro que desea eliminar");
                ctr.borrarRegistro(path, delete);
                    break;
            }

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Que opcion desea\n1. Crear archivo\n2. escribir\n3. leer\n4. limpiar\n.5 borrar\n6. eliminar registro\n Otro numero para salir"));

        }

    }
}



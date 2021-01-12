
public class App {
    public static void main(String[] args) {

        Control ctr = new Control();

        String path = "registro.txt";

        

        String id, name, age;

        ctr.crearArchivo(path);

        id = "0078";
        name = "Rodrigo";
        age = "20";

        ctr.escribirArchivo(id, name, age);
        

        ctr.leerTexto(path);

    }
}

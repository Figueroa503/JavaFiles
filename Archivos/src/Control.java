import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Control {

    private File file;
    private String path, ID, name, age;

    public void crearArchivo(String path) {

        this.path = path;
        file = new File(path);

        try {

            if (file.createNewFile()) {
                JOptionPane.showMessageDialog(null, "Archivo creado con exito!!");
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ya existe");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void escribirArchivo(String ID, String name, String age) {

        this.ID = ID;
        this.name = name;
        this.age = age;

        try {

            FileWriter write = new FileWriter(file, true);

            write.write(ID + "," + name + "," + age + "\r" + "\n");
            write.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void leerTexto(String path) {

        String readLine;
        try {
            FileReader reader = new FileReader(path);
            BufferedReader breader = new BufferedReader(reader);

            readLine = breader.readLine();
            while (readLine != null) {
                System.out.println(readLine);
                readLine = breader.readLine();
            }

            breader.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

    }


    public void eliminarArchivo(String path) {

        file = new File(path);

        if (file.exists()) {

            file.delete();
            JOptionPane.showMessageDialog(null, "Archivo eliminado con exito");
        } else {
            JOptionPane.showMessageDialog(null, "El Archivo no existe");
        }

    }
    

}

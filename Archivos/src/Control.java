import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Control {

    private File file;
    private String path, ID, name, age;
    private Scanner x;

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
            BufferedWriter bw = new BufferedWriter(write);
            PrintWriter pwritter = new PrintWriter(bw);

            pwritter.println(ID + "," + name + "," + age);
           // write.write(ID + "," + name + "," + age + "\r" + "\n");
            pwritter.flush();
            pwritter.close();
            bw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void leerTexto(String path) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        String readLine;
        try {
            FileReader reader = new FileReader(path);
            BufferedReader breader = new BufferedReader(reader);

            readLine = breader.readLine();
            System.out.println(ANSI_RED + "Lista de registros\n");
            while (readLine != null) {
                System.out.println(ANSI_GREEN + readLine);
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

    public void limpiarArchivo(String path) {

        this.path = path;
        FileWriter writer;
        try {
            writer = new FileWriter(path);
            writer.write("");
            writer.close();
        } catch (IOException e) {

        }

    }

    /*public void borrarRegistro(String path, String delete) {

        this.path = path;
        String tempfile = "tempfile.txt";
        File oldfile = new File(path);
        File newfile = new File(tempfile);
        File temp = new File(path);

        name = "";
        age = "";
        ID = "";

        try {

            FileWriter writter = new FileWriter(tempfile);
            BufferedWriter bwritter = new BufferedWriter(writter);
            PrintWriter pwritter = new PrintWriter(bwritter);

            File tm = new File(path);
            try {
                x = new Scanner(tm);
                x.useDelimiter("[,]");

                while (x.hasNextLine()) {

                    ID = x.next();
                    name = x.next();
                    age = x.next();

                    if (!ID.equals(delete)) {

                        pwritter.println(ID + "," + name + "," + age);
                    }

                }

                x.close();
                bwritter.flush();
                bwritter.close();
                pwritter.flush();
                pwritter.close();

                oldfile.delete();
                newfile.renameTo(temp);

            } catch (FileNotFoundException ex) {

            }

        } catch (IOException e) {

        }

    }*/

    public void borrarRegistro(String path, String delete) {

        File file = new File(path);
        String tempfile = "tempfile.txt";
        File temp = new File(tempfile);
        String name = "", age = "", ID = "";
    
        try {
    
          FileWriter writter = new FileWriter(tempfile);
          BufferedWriter bwritter = new BufferedWriter(writter);
          PrintWriter pwritter = new PrintWriter(bwritter);
    
          try {
            Scanner x = new Scanner(file);
            x.useDelimiter("[,\n]");
    
            while (x.hasNext()) {
    
              ID = x.next();
              name = x.next();
              age = x.next();
    
              if (!ID.equals(delete)) {
    
                pwritter.println(ID + "," + name + "," + age);
              }
    
            }
    
            x.close();
            pwritter.flush();
            pwritter.close();
    
            if (file.delete()) {
              temp.renameTo(file);
            }
    
          } catch (FileNotFoundException ex) {
    
          }
    
        } catch (IOException e) {
    
        }
    
      }

}

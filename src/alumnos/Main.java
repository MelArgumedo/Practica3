package alumnos;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.annotation.processing.Filer;
import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frmAlumnos pantalla = new frmAlumnos();
                pantalla.setVisible(true);

                pantalla.setBotonGuardarListener(new BotonGuardarListener() {
                    @Override
                    public void guardando(alumno persona) {
                        System.out.println("Nombre: "+persona.getNombre());
                        System.out.println("A. Paterno: "+persona.getAPaterno());
                        System.out.println("A. Materno: "+persona.getAMaterno());
                        System.out.println("Sexo: "+persona.getSexo());
                        System.out.println("CURP: "+ persona.getCURP());
                        System.out.println("Correo: "+persona.getCorreo());
                        System.out.println("Telefono: "+persona.getTelefono());
                        System.out.println("Discapacidad: "+persona.getDiscapacidad());
                        System.out.println("Edad:  "+calcularEdadDesdeCurp(persona.getCURP()));
                        System.out.println();

                        Path path= Path.of("C:\\Users\\melan\\IdeaProjects\\Practica3\\Luis.txt");
                                String contenido =persona.getNombre();

                                try(FileWriter archivo = new FileWriter(path.toFile(), true))
                                {
                                    PrintWriter pw= new PrintWriter(archivo);
                                    pw.println(contenido);
                                    pw.println(persona.getAPaterno());
                                    pw.println(persona.getAMaterno());
                                    pw.println(persona.getSexo());
                                    pw.println(persona.getCURP());
                                    pw.println(persona.getTelefono());
                                    pw.println(persona.getDiscapacidad());
                                    pw.println(calcularEdadDesdeCurp(persona.getCURP()));
                                    pw.println();

                                }
                                catch (IOError e){e.getMessage();}catch (IOException e)
                                {throw new IOError(e);}
                    }
                });

            }
        });
    }

    public static int calcularEdadDesdeCurp(String curp) {
      int añoCurp = Integer.parseInt(curp.substring(4, 6));
      int curpMes= Integer.parseInt(curp.substring(6, 8));
      int curpDia= Integer.parseInt(curp.substring(8, 10));

        LocalDate ahora= LocalDate.now();
        int añoActual= ahora.getYear();
        int mesActual= ahora.getMonthValue();
        int diaActual= ahora.getDayOfMonth();
         if (añoCurp > (añoActual-2000))
             añoCurp+=1900;
         else
             añoCurp+=2000;

         int edad= añoActual-añoCurp;

         if(mesActual < curpMes )
         {
             edad--;
             return edad;

         }
         if(mesActual == curpMes && diaActual < diaActual- curpDia)
         {
             edad--;
             return edad;
         }
             return edad;
    }
}


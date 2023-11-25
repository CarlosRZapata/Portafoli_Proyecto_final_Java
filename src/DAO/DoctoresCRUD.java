package DAO;

import Entidades.Doctor;
import java.io.*;
import java.util.ArrayList;

public class DoctoresCRUD {
    public void insertarDoctor(Doctor d){
        //poner este codigo copiado dentro de metodos y empezar a invocarlos
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\ListaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctor> otraLista = (ArrayList<Doctor>)o;
            otraLista.add(d);

            //con remove para eliminar y con set para editar
            //hacer otra ventana gui de profesores /doctores

            //escribir de vuelta al archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\ListaDoctor.txt");
            ObjectOutputStream miStream = new ObjectOutputStream(escribir);
            miStream.writeObject(otraLista);
            miStream.close();
            miStream2.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Doctor buscarDoctorPorMat(String IDDoctor){
        //obtener lista de alumnos desde Archivo
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\ListaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctor> otraLista = (ArrayList<Doctor>)o;
            for (Doctor d: otraLista){
                if (d.getIDDoctor().equals(IDDoctor)){
                    return d;
                }
            }
            miStream2.close();
            //Saliendo del for
            return null;

            //Alumno pruebAlumno = otraLista.get(0);
            //System.out.println(pruebAlumno.getNombre());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

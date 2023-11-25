package DAO;

import Entidades.Paciente;

import java.io.*;
import java.util.ArrayList;

public class PacientesCRUD {
    public void insertarPaciente(Paciente a){
        //poner este codigo copiado dentro de metodos y empezar a invocarlos
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\ListaPaciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>)o;
            otraLista.add(a);

            //con remove para eliminar y con set para editar
            //hacer otra ventana gui de profesores /doctores

            //escribir de vuelta al archivo
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\ListaPaciente.txt");
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

    public Paciente buscarPacientePorMat(String IDPaciente){
        //obtener lista de alumnos desde Archivo
        try {
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\ListaPaciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>)o;
            for (Paciente a: otraLista){
                if (a.getIDPaciente().equals(IDPaciente)){
                    return a;
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

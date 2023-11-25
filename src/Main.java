
import Entidades.Doctor;
import Entidades.Paciente;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        Paciente p = new Paciente();
        p.setIDPaciente("0000");
        p.setNombre("Pedro");
        p.setApPaterno("Lopez");
        p.setApMaterno("Perez");

        Date fecha = new Date();
        p.setFechaNac(fecha);
        lista.add(p);
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\ListaPaciente.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
            miStream.writeObject(lista);
            miStream.close();
            // LEER LISTA DESDE ARCHIVO
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\ListaPaciente.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Paciente> otraLista = (ArrayList<Paciente>) o;
            Paciente pruebPaciente = otraLista.get(0);
            System.out.println(pruebPaciente.getNombre());
            miStream2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer lista de clase Pacientes");
        }

        ArrayList<Doctor> listaDoctores = new ArrayList<Doctor>();
        Doctor d = new Doctor();
        d.setIDDoctor("0000");
        d.setNombre("Mariano");
        d.setApPaterno("GALLEGOS");
        d.setApMaterno("MERINO");
        Date fechaD = new Date();
        d.setFechaNac(fechaD);
        listaDoctores.add(d);
        try {
            FileOutputStream escribir =
                    new FileOutputStream("C:\\temp\\ListaDoctor.txt");
            ObjectOutputStream miStream =
                    new ObjectOutputStream(escribir);
            miStream.writeObject(listaDoctores);
            miStream.close();
            // LEER LISTA DESDE ARCHIVO
            FileInputStream leer =
                    new FileInputStream("C:\\temp\\ListaDoctor.txt");
            ObjectInputStream miStream2 = new ObjectInputStream(leer);
            Object o = miStream2.readObject();
            ArrayList<Doctor> otraListaDoctores = (ArrayList<Doctor>) o;
            Doctor pruebDoctor = otraListaDoctores.get(0);
            System.out.println(pruebDoctor.getNombre());
            miStream2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer lista de clase Pacientes");
        }
    }
}
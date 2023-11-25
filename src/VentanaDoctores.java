import DAO.DoctoresCRUD;
import Entidades.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class VentanaDoctores extends JFrame{

    private JTextField textIDDoctores;
    private JTextField textNombre;
    private JTextField textApPaterno;
    private JTextField textApMaterno;
    private JTextField textFhecaNac;
    private JComboBox comboBox1;
    private JButton BtnBuscar;
    private JButton BtnEliminar;
    private JButton BtnAgregar;
    private JButton BtnGuardar;
    private JLabel lblIDDoctores;
    private JLabel lblNombre;
    private JLabel lblApellidoPaterno;
    private JLabel lblApellidoMaterno;
    private JLabel lblFechaNac;
    private JLabel lblSexo;
    private JPanel miPanel;

    public VentanaDoctores() {
        BtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar alumno
                DoctoresCRUD crud = new DoctoresCRUD();
                String IDDoctores = textIDDoctores.getText();
                Doctor a = crud.buscarDoctorPorMat(IDDoctores);
                //Codigotodo junto las ultimas 2 lineas
                //crud.buscarAlumnoPorMat(txtMatricula.getText());
                if (a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encunetra el alumno con la matricula: " + matricula, "Alumnos",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encunetra el doctor con el ID: " + IDDoctores + "\n¿Desea dar de alta?","Doctor",JOptionPane.YES_NO_OPTION);
                    if (respuesta == 0){
                        //si quiere dar de alta el alumno inexistente
                        BtnEliminar.setEnabled(true);
                        textNombre.requestFocus();

                    } else if (respuesta == 1) {
                        //no quiere dar de alta
                        //Limpiar el formulario
                        //invocar un metodo para limpiar el formulario


                    }
                }
                else {
                    textNombre.setText(a.getNombre());
                    textApPaterno.setText(a.getApPaterno());
                    textApMaterno.setText(a.getApMaterno());
                }
            }
        });
        BtnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Instanciar objeto de la clase alumno
                Doctor a = new Doctor();
                a.setIDDoctor(textIDDoctores.getText());
                a.setNombre(textNombre.getText());
                a.setApPaterno(textApPaterno.getText());
                a.setApMaterno(textApMaterno.getText());

                //Date fechaNac = new Date(txtFechaNac.getText());
                a.setFechaNac(new Date());

                //invocar metodo de insertarAlumno
                DoctoresCRUD crud = new DoctoresCRUD();
                crud.insertarDoctor(a);
            }
        });
    }

    public static void main(String[] args) {
        VentanaDoctores v = new VentanaDoctores();
        v.setTitle("Doctores");
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }

}

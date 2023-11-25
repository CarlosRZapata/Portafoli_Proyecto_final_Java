import DAO.PacientesCRUD;
import Entidades.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class VentanaPacientes extends JFrame {
    private JPanel miPanel;
    private JTextField txtIDPaciente;
    private JLabel lblIDPaciente;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellidoPaterno;
    private JLabel lblApellidoMaterno;
    private JLabel lblFechaNac;
    private JLabel lblSexo;
    private JTextField txtApPaterno;
    private JTextField txtApMaterno;
    private JComboBox cmbSexo;
    private JTextField txtFechaNac;
    private JButton BtnBuscar;
    private JButton BtnEliminar;
    private JButton BtnNuevo;
    private JButton BtnGuardar;


    public VentanaPacientes() {
        BtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //buscar alumno
                PacientesCRUD crud = new PacientesCRUD();
                String IDPaciente = txtIDPaciente.getText();
                Paciente a = crud.buscarPacientePorMat(IDPaciente);
                //Codigotodo junto las ultimas 2 lineas
                //crud.buscarAlumnoPorMat(txtMatricula.getText());
                if (a == null){
                    //JOptionPane.showMessageDialog(miPanel,"No se encunetra el alumno con la matricula: " + matricula, "Alumnos",JOptionPane.ERROR_MESSAGE);
                    int respuesta = JOptionPane.showConfirmDialog(miPanel,"No se encunetra el paciente con el ID: " + IDPaciente + "\n¿Desea dar de alta?","Paciente",JOptionPane.YES_NO_OPTION);
                    if (respuesta == 0){
                        //si quiere dar de alta el alumno inexistente
                        BtnNuevo.setEnabled(true);
                        txtNombre.requestFocus();

                    } else if (respuesta == 1) {
                        //no quiere dar de alta
                        //Limpiar el formulario
                        //invocar un metodo para limpiar el formulario


                    }
                }
                else {
                    txtNombre.setText(a.getNombre());
                    txtApPaterno.setText(a.getApPaterno());
                    txtApMaterno.setText(a.getApMaterno());
                }
            }
        });
        BtnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Instanciar objeto de la clase alumno
                Paciente a = new Paciente();
                a.setIDPaciente(txtIDPaciente.getText());
                a.setNombre(txtNombre.getText());
                a.setApPaterno(txtApPaterno.getText());
                a.setApMaterno(txtApMaterno.getText());

                //Date fechaNac = new Date(txtFechaNac.getText());
                a.setFechaNac(new Date());

                //invocar metodo de insertarAlumno
                PacientesCRUD crud = new PacientesCRUD();
                crud.insertarPaciente(a);
            }
        });
    }

    public static void main(String[] args) {
        VentanaPacientes v = new VentanaPacientes();
        v.setTitle("Paciente");
        v.setContentPane(v.miPanel);
        v.setSize(500,500);
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setVisible(true);
    }

    public boolean validarCamposPaciente() {
        if (txtIDPaciente.getText().isEmpty() || txtNombre.getText().isEmpty()|| txtApPaterno.getText().isEmpty() || txtApMaterno.getText().isEmpty() ||txtFechaNac.getText().isEmpty()) {
            JOptionPane.showMessageDialog(miPanel, "Hay una casilla vacia o con un valor invalido, cheque de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            return true;
        }
    }
}

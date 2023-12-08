import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame{
    private JPanel miPanel;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancelar;

    public login() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(txtPassword.getPassword());
                if (txtUsuario.getText().equals("admin") && password.equals("1234")){
                    JOptionPane.showMessageDialog(miPanel, "Bienvenido admin");
                    dispose();
                    String[] tipoUsuario={"admin"};
                    VentanaDoctores.main(tipoUsuario);
                }else if (txtUsuario.getText().equals("usuario") && password.equals("4567")){
                    JOptionPane.showMessageDialog(miPanel, "Bienvenido usuario");
                    dispose();
                    String[] tipoUsuario={"usuario"};
                    VentanaPacientes.main(tipoUsuario);
                } else if (txtUsuario.getText().equals("consultas") && password.equals("7890")){
                    JOptionPane.showMessageDialog(miPanel, "Bienvenido a consultas");
                    dispose();
                    String[] tipoUsuario={"consultas"};
                    Consultas.main(tipoUsuario);
                } else {
                    JOptionPane.showMessageDialog(miPanel, "Usuario o contrasela incorrectas", "Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        login vLogin = new login();
        vLogin.setContentPane(vLogin.miPanel);
        vLogin.setSize(300,300);
        vLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vLogin.setVisible(true);
    }
}

package alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmAlumnos {
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JCheckBox chkDiscapacidad;
    private JButton btnAcpectar;
    private JButton btnCancelar;
    private JComboBox cmbSexo;
    private JTextField txtCurp;

    public frmAlumnos() {
        btnAcpectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrar();

            }
        });
    }
    private void Borrar()
    {
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtCurp.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        chkDiscapacidad.setSelected(false);

    }
    private void poblarComboBox()
    {
        DefaultComboBoxModel <Genero> modelo = (DefaultComboBoxModel<Genero>) cmbSexo.getModel();
        for(Genero genero: Genero.values()){
            comboBoxModel.addElement(genero);
        }
    }
}

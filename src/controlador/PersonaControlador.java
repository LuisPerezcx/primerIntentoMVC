package controlador;

import modelo.Persona;
import validaciones.Validaciones;
import vista.MostrarPersonas;
import vista.PersonaVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PersonaControlador implements ActionListener {
    private PersonaVista vista;
    private ArrayList<Persona> personaArrayList = Persona.personaArray;
    private JFrame jFrame = new JFrame();
    public PersonaControlador(PersonaVista vista){
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == vista.registrarButton){
            if(!validar()){
                return;
            }
            String nombre = vista.txtNombre.getText();
            String apellido = vista.txtApellidos.getText();
            String telefono = vista.txtTelefono.getText();
            String correo = vista.txtCorreo.getText();
            String empresa = String.valueOf(vista.empresas.getSelectedItem());
            String genero;
            if(vista.btnMasculino.isSelected()){
                genero = "Masculino";
            }else if(vista.btnFemenino.isSelected()){
                genero = "Femenino";
            } else{
                genero = "no definido";
            }
            personaArrayList.add(new Persona(nombre,apellido,empresa,telefono,correo,genero));
            limpiar();
            System.out.println(personaArrayList);
        } else if (o == vista.verButton) {
            new MostrarPersonas(personaArrayList);
        }
    }
    private boolean validar(){
        if(vista.txtNombre.getText().isEmpty() || vista.txtApellidos.getText().isEmpty() || vista.txtTelefono.getText().isEmpty() ||
        vista.txtCorreo.getText().isEmpty() || (!vista.btnFemenino.isSelected() && !vista.btnMasculino.isSelected())){
            JOptionPane.showMessageDialog(jFrame,"Primero complete el formulario");
            return false;
        }
        if(!Validaciones.validarcnRegex(vista.txtNombre.getText(), "^[A-Z][a-zA-Z]*$|^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$")){
            JOptionPane.showMessageDialog(jFrame,"Ingresa un nombre valido");
            return false;
        }
        if(!Validaciones.validarcnRegex(vista.txtApellidos.getText(), "^[A-Z][a-zA-Z]*$|^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$")){
            JOptionPane.showMessageDialog(jFrame,"Ingresa un Apellido valido");
            return false;
        }
        if(!Validaciones.validarcnRegex(vista.txtTelefono.getText(),"^[0-9]{10}$")){
            JOptionPane.showMessageDialog(jFrame,"Ingresa un Telefono valido");
            return false;
        }
        if(!Validaciones.validarcnRegex(vista.txtCorreo.getText(),"^[a-z0-9+_.-]+@(.+)$")){
            JOptionPane.showMessageDialog(jFrame,"Ingresa un Correo valido");
            return false;
        }
        return true;
    }
    public void limpiar(){
        vista.txtNombre.setText("");
        vista.txtApellidos.setText("");
        vista.txtCorreo.setText("");
        vista.txtTelefono.setText("");
        vista.empresas.setSelectedIndex(0);
        vista.btnFemenino.setSelected(false);
        vista.btnMasculino.setSelected(false);
    }
}

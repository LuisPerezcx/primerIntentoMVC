package controlador;

import modelo.Persona;
import vista.MostrarPersonas;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarControlador implements ActionListener {
    private MostrarPersonas mostrar;
    private JTable jTable;
    private JFrame jFrame = new JFrame();
    private int renglonSeleccionado = -1;

    public MostrarControlador(MostrarPersonas mostrar, JTable jTable){
        this.mostrar = mostrar;
        this.jTable = jTable;
        listenerTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(renglonSeleccionado);
        Object o = e.getSource();
        if (o == mostrar.btnEliminar) {
            if (renglonSeleccionado != -1) {
                eliminar(renglonSeleccionado);
                MostrarPersonas.actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(jFrame, "Primero selecciona un producto");
            }
        }else if( o == mostrar.btnEditar){
            if (renglonSeleccionado != -1) {
                System.out.println("ola");
            } else {
                JOptionPane.showMessageDialog(jFrame, "Primero selecciona un producto");
            }
        }
    }
    private void listenerTable(){
        jTable.getSelectionModel().addListSelectionListener(e -> {
            renglonSeleccionado =jTable.getSelectedRow();
            System.out.println(renglonSeleccionado);
        });
    }
    private void eliminar(int index){
        Persona.personaArray.remove(index);
    }
}

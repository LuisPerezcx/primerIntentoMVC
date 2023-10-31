package vista;

import controlador.MostrarControlador;
import modelo.Persona;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MostrarPersonas extends JFrame{
    public static JTable jTable;
    private static DefaultTableModel defaultTableModel;
    private static ArrayList<Persona> personaArrayList;
    private JPanel panelContenedor, panelBoton;
    public JButton btnEliminar, btnEditar;

    public MostrarPersonas(ArrayList<Persona> list){
        this.personaArrayList = list;
        initControl();
        configTable();
        configFrame();
        crearComponentes();
        dibujarCuerpo();
        add(panelContenedor);
        pack();
        addListeners();
    }
    private void crearComponentes(){
        panelContenedor = new JPanel();
        panelBoton = new JPanel();
        btnEliminar = new JButton("Eliminar Producto");
        btnEditar = new JButton("Editar Producto");
    }
    private void dibujarCuerpo(){
        panelBoton.setLayout(new FlowLayout());
        panelBoton.setPreferredSize(new Dimension(650, 50));
        panelBoton.add(btnEliminar);
        panelBoton.add(btnEditar);

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        panelContenedor.add(new JScrollPane(jTable));
        panelContenedor.add(panelBoton);
    }
    private void initControl() {
        defaultTableModel = new DefaultTableModel();
        String[] titulos = {"NOMBRE", "APELLIDOS", "EMPRESA", "TELEFONO", "CORREO", "GENERO"};
        defaultTableModel.setColumnIdentifiers(titulos);
        String [] fila = new String[defaultTableModel.getColumnCount()];
        if (personaArrayList != null) {
            for (Persona userTable : personaArrayList) {
                fila[0] = userTable.getNombre();
                fila[1] = userTable.getApellidos();
                fila[2] = userTable.getEmpresa();
                fila[3] = userTable.getTelefono();
                fila[4] = userTable.getCorreo();
                fila[5] = userTable.getGenero();
                defaultTableModel.addRow(fila);
            }
        } else System.out.println("nada");
        jTable = new JTable(defaultTableModel);
    }

    private void configFrame(){
        setTitle("Tabla de usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 250);
        setLocationRelativeTo(null);
    }

    private void configTable(){
        jTable.setGridColor(new Color(88, 214, 141));
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
    }
    private void addListeners(){
        btnEliminar.addActionListener(new MostrarControlador(this,jTable));
        btnEditar.addActionListener(new MostrarControlador(this,jTable));
    }
    public static void actualizarTabla(){
        defaultTableModel.setRowCount(0); // Limpiar los datos de la tabla
        defaultTableModel = new DefaultTableModel();
        String[] titulos = {"NOMBRE", "APELLIDOS", "EMPRESA", "TELEFONO", "CORREO", "GENERO"};
        defaultTableModel.setColumnIdentifiers(titulos);
        String [] fila = new String[defaultTableModel.getColumnCount()];
        if (personaArrayList != null) {
            for (Persona userTable : personaArrayList) {
                fila[0] = userTable.getNombre();
                fila[1] = userTable.getApellidos();
                fila[2] = userTable.getEmpresa();
                fila[3] = userTable.getTelefono();
                fila[4] = userTable.getCorreo();
                fila[5] = userTable.getGenero();
                defaultTableModel.addRow(fila);
            }
        } else System.out.println("nada");
        jTable = new JTable(defaultTableModel);
    }
}

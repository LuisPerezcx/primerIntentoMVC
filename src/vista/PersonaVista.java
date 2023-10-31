package vista;

import controlador.PersonaControlador;

import javax.swing.*;
import java.awt.*;

public class PersonaVista extends JFrame{
    public JTextField txtNombre, txtApellidos, txtTelefono, txtCorreo;
    private JLabel lblNombre, lblApellidos, lblTelefono, lblCorreo, lblEmpresa, lblGenero,lblM,lblF;
    private JPanel contenedorPnls,panelIz,panelDer,panelRadio, contenedorPrincipal,pnlBotones;
    public JRadioButton btnMasculino, btnFemenino;
    private ButtonGroup radioGroup;
    public JComboBox<String> empresas;
    public JButton registrarButton, verButton;

    public PersonaVista(){
        initializeComponents();
        setupFrame();
        setupPanelContainer();
        add(contenedorPrincipal);
        setLocationRelativeTo(null);

        addListeners();
    }
    private void initializeComponents(){
        contenedorPnls = new JPanel();
        panelIz = new JPanel();
        panelDer = new JPanel();
        contenedorPrincipal = new JPanel();
        pnlBotones = new JPanel();

        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtTelefono = new JTextField();
        txtCorreo = new JTextField();
        lblNombre = new JLabel("Nombre:");
        lblApellidos = new JLabel("Apellidos:");
        lblTelefono = new JLabel("Teléfono:");
        lblCorreo = new JLabel("Correo:");
        lblEmpresa = new JLabel("Empresa:");
        lblGenero = new JLabel("Género:");
        registrarButton = new JButton("Registrar");
        verButton = new JButton("Ver");

        btnMasculino = new JRadioButton();
        btnFemenino = new JRadioButton();
        radioGroup = new ButtonGroup();

        String[] empresasnombre = {"UNSIJ","UTM","UNITSMO","UMAR"};
        empresas = new JComboBox<>(empresasnombre);

        panelRadio = new JPanel();
        lblM = new JLabel("Masculino");
        lblF = new JLabel("Femenino");
    }
    private void setupFrame() {
        setTitle("Formulario Persona");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(350, 250);
    }
    private void setupPanelContainer(){
        panelIz.setLayout(new GridLayout(6,0));
        panelIz.setPreferredSize(new Dimension(70,150));
        panelIz.add(lblNombre);
        panelIz.add(lblApellidos);
        panelIz.add(lblTelefono);
        panelIz.add(lblCorreo);
        panelIz.add(lblEmpresa);
        panelIz.add(lblGenero);

        panelDer.setLayout(new GridLayout(6,0));
        panelDer.setPreferredSize(new Dimension(200,150));
        panelDer.add(txtNombre);
        panelDer.add(txtApellidos);
        panelDer.add(txtTelefono);
        panelDer.add(txtCorreo);
        panelDer.add(empresas);

        panelRadio.setLayout(new FlowLayout());
        panelRadio.add(lblM);
        panelRadio.add(btnMasculino);
        panelRadio.add(lblF);
        panelRadio.add(btnFemenino);
        radioGroup.add(btnMasculino);
        radioGroup.add(btnFemenino);
        panelDer.add(panelRadio);



        contenedorPnls.setLayout(new FlowLayout());
        contenedorPnls.add(panelIz);
        contenedorPnls.add(panelDer);

        pnlBotones.setLayout(new FlowLayout());
        pnlBotones.add(verButton);
        pnlBotones.add(registrarButton);

        contenedorPrincipal.setLayout(new BoxLayout(contenedorPrincipal, BoxLayout.Y_AXIS));
        contenedorPrincipal.add(contenedorPnls);
        contenedorPrincipal.add(pnlBotones);
    }
    public void addListeners(){
        registrarButton.addActionListener(new PersonaControlador(this));
        verButton.addActionListener(new PersonaControlador(this));
        btnFemenino.addActionListener(new PersonaControlador(this));
        btnMasculino.addActionListener(new PersonaControlador(this));
        empresas.addActionListener(new PersonaControlador(this));
    }
}

package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.GestionDatosEmpr;
import controlador.GestionDatosPais;

public class FormularioEmp extends JInternalFrame implements ActionListener {
	
	private GestionDatosEmpr ge;
	private JTextField nombreE;
	private JTextField presidente;
	private JTextField cajera;
	private JTextField nombreTr;
	private JTextField apellidoTr;
	private JTable tblinscripciones;

	public FormularioEmp(GestionDatosEmpr ge) {
		this.ge = ge;
		setSize(950, 700);
		setVisible(true);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		tblinscripciones = new JTable();
		tblinscripciones.setModel(new ModelInscripcionEmp());
		JScrollPane scrollinscripciones = new JScrollPane(tblinscripciones);
		
		JPanel scrollPane = new JPanel();
		scrollPane.setLayout(new GridLayout(1, 1));
		scrollPane.add(scrollinscripciones);

		JPanel pnlIns = new JPanel();
		pnlIns.setLayout(new GridBagLayout());
		pnlIns.setBorder(BorderFactory.createTitledBorder("Ingresar datos"));

		GridBagConstraints gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 0;
		pnlIns.add(new JLabel("Nombre de la empresa"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridwidth = 2;
		gb.fill = 2;
		nombreE = new JTextField(20);
		pnlIns.add(nombreE, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 1;
		pnlIns.add(new JLabel("Nombre del presidente"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 1;
		gb.gridwidth = 2;
		gb.fill = 2;
		presidente = new JTextField(20);
		pnlIns.add(presidente, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 2;
		pnlIns.add(new JLabel("Nombres del Trabajador(Guardia)"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 2;
		//gb.gridwidth = 5;
		gb.fill = 5;
		nombreTr = new JTextField(20);
		pnlIns.add(nombreTr, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 5;
		pnlIns.add(new JLabel("Apellidos del Trabajador(Guardia)"), gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 5;
		gb.fill = 1;
		apellidoTr = new JTextField(20);
		pnlIns.add(apellidoTr, gb);
		

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 7;
		pnlIns.add(new JLabel("Nombre Cajera"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 7;
		gb.fill = 1;
		cajera = new JTextField(20);
		pnlIns.add(cajera, gb);

		JPanel pnlBot = new JPanel();
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("btnGuardar");
		
		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 9;
		gb.fill = 1;
		pnlIns.add(btnGuardar, gb);
		
		//pnlBot.add(btnGuardar);
		pnlIns.add(pnlBot);
		c.add(pnlIns, BorderLayout.CENTER);
		c.add(scrollPane, BorderLayout.SOUTH);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		switch (comando) {
		case "btnGuardar":
			
			try {
				guardarDatosR();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			nombreE.setText("");
			presidente.setText("");
			nombreTr.setText("");
			cajera.setText("");
			apellidoTr.setText("");
			cargarDatos();
			break;
		default:
			break;
		}
	}
	
public void guardarDatosR() throws IOException {
	try {
		String emp=ge.buscarEmpleado(nombreTr.getText().toString().toLowerCase(), apellidoTr.getText().toString().toLowerCase());
		int a = 2/(ge.buscarEmpresa(nombreE.getText().toString().toLowerCase()));
		if(emp != null && a==2){
	ge.newEmpresa(nombreE.getText().toString().toLowerCase(), presidente.getText().toString().toLowerCase(), cajera.getText().toString().toLowerCase(),
			nombreTr.getText().toString().toLowerCase(), apellidoTr.getText().toString().toLowerCase());
		}
	if (emp==null) {

		JOptionPane.showMessageDialog(null, "El empleado ya fue registado en otra empresa");

	} 
	} catch (ArithmeticException e) {

		JOptionPane.showMessageDialog(null, "La Empresa ya fue registada");

	}
}

public void cargarDatos(){
	
	tblinscripciones.setModel(new ModelInscripcionEmp(ge.getEmpresas()));
}	

}

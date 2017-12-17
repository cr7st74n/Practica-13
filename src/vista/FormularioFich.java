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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import controlador.GestionDatosFich;

public class FormularioFich extends JInternalFrame implements ActionListener {
	
	private GestionDatosFich gf;
	
	private JTextField costo;
	private JTextField nombreEquipo;
	private JTextField capitan;
	private JTextField nombreJug;
	private JTextField apellidoJug;
	private JTable tblinscripciones;

	public FormularioFich(GestionDatosFich gf) {
		this.gf = gf;
		setSize(950, 700);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		tblinscripciones = new JTable();
		tblinscripciones.setModel(new ModelInscripcionFich());
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
		pnlIns.add(new JLabel("Costo inscripcion"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridwidth = 2;
		gb.fill = 2;
		costo = new JTextField(20);
		pnlIns.add(costo, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 1;
		pnlIns.add(new JLabel("Nombre equipo"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 1;
		gb.gridwidth = 2;
		gb.fill = 2;
		nombreEquipo = new JTextField(20);
		pnlIns.add(nombreEquipo, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 2;
		pnlIns.add(new JLabel("(Nombres y Apellidos) Capitan"), gb);


		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 2;
		gb.fill = 1;
		capitan = new JTextField(40);
		pnlIns.add(capitan, gb);
		
		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 5;
		pnlIns.add(new JLabel("Nombres del Jugador"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 5;
		gb.fill = 1;
		nombreJug = new JTextField(20);
		pnlIns.add(nombreJug, gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 7;
		pnlIns.add(new JLabel("Apellidos del Jugador"), gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 7;
		gb.fill = 1;
		apellidoJug = new JTextField(20);
		pnlIns.add(apellidoJug, gb);

		
		

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
			
			guardarDatosR();
			
			costo.setText("");
			nombreEquipo.setText("");
			nombreJug.setText("");
			capitan.setText("");
			apellidoJug.setText("");
			cargarDatos();
			break;
		default:
			break;
		}
	}
	
public void guardarDatosR()  {
	
			String costo1=costo.getText().toString().toLowerCase();
			String nombreEquipo1=nombreEquipo.getText().toString().toLowerCase();
			String capitan1=capitan.getText().toString().toLowerCase();
			String nombreJug1=nombreJug.getText().toString().toLowerCase();
			String apellidoJug1=apellidoJug.getText().toString().toLowerCase();

		try {

			int a = 2 / (gf.buscarFicha(nombreEquipo.getText().toString().toLowerCase()));
			String ficha = gf.buscarCapitan(capitan1);
			
			if (ficha == null) {
				JOptionPane.showMessageDialog(null, "Capitan ya registrado en otro equipo");
			}else if(ficha != null && a==2){
				gf.newFicha(costo1, nombreEquipo1, capitan1, nombreJug1, apellidoJug1);
			}

		} catch (ArithmeticException e) {

			JOptionPane.showMessageDialog(null, "Equipo ya registrado");

		}
	}

	public void cargarDatos() {
	
	tblinscripciones.setModel(new ModelInscripcionFich(gf.getFichas()));
}	

	
}

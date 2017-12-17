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

import controlador.GestionDatosPais;
import modelo.Provincia;

public class FormularioPais extends JInternalFrame implements ActionListener {
	
	private GestionDatosPais gp;
	private JTextField nombrePais;
	private JTextField txtIdioma;
	private JTextField nombreProvincia;
	private JTextField nombreCanton;
	private JTextField alcalde;
	private JTable tblinscripciones;

	public FormularioPais(GestionDatosPais gp) {
		this.gp = gp;
		setSize(950, 700);
		setVisible(true);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		tblinscripciones = new JTable();
		tblinscripciones.setModel(new ModelInscripcionP());
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
		pnlIns.add(new JLabel("Nombre del pais"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridwidth = 2;
		gb.fill = 2;
		nombrePais = new JTextField(20);
		pnlIns.add(nombrePais, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 1;
		pnlIns.add(new JLabel("Idioma del Pais"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 1;
		gb.gridwidth = 2;
		gb.fill = 2;
		txtIdioma = new JTextField(20);
		pnlIns.add(txtIdioma, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 2;
		pnlIns.add(new JLabel("Nombre de una provincia"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 2;
		gb.fill = 1;
		nombreProvincia = new JTextField(20);
		pnlIns.add(nombreProvincia, gb);
		
		

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 5;
		pnlIns.add(new JLabel("Nombre de un canton de la provincia"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 5;
		//gb.gridwidth = 5;
		gb.fill = 5;
		nombreCanton = new JTextField(20);
		pnlIns.add(nombreCanton, gb);

		
		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 7;
		pnlIns.add(new JLabel("Nombre del alcalde del canton"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 7;
		gb.fill = 1;
		alcalde = new JTextField(20);
		pnlIns.add(alcalde, gb);

		JPanel pnlBot = new JPanel();
		JButton btnGuardar = new JButton("Guardar");

		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("btnGuardar");

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 9;
		gb.fill = 1;
		pnlIns.add(btnGuardar, gb);

		// pnlBot.add(btnGuardar);
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

			nombrePais.setText("");
			txtIdioma.setText("");
			nombreCanton.setText("");
			nombreProvincia.setText("");
			alcalde.setText("");
			cargarDatos();
			break;
		default:
			break;
		}
	}

	public void guardarDatosR() throws IOException {
		String a = null;
		int provi = 0;
		try {
			 provi = 4 / (gp.buscarProvincia(nombrePais.getText().toString().toLowerCase(), nombreProvincia.getText().toLowerCase(),nombreCanton.getText().toString().toLowerCase()));

			 a = gp.buscarCanton(nombrePais.getText().toString().toLowerCase(), nombreProvincia.getText().toLowerCase(),
					nombreCanton.getText().toString().toLowerCase());

			
			if (provi == 4 && a != null) {
				gp.newPais(nombrePais.getText().toString().toLowerCase(), txtIdioma.getText().toString().toLowerCase(),
						nombreProvincia.getText().toString().toLowerCase(), nombreCanton.getText().toString().toLowerCase(),
						alcalde.getText().toString().toLowerCase());
			}
			
			if (a == null) {

				JOptionPane.showMessageDialog(null, "Canton ya registrado en una provincia de este pais");
			}
			
		} catch (ArithmeticException e) {

			JOptionPane.showMessageDialog(null, "Provincia ya registrada en este pais");
			

		} catch (IOException ei) {

			JOptionPane.showMessageDialog(null, "Canton ya registrado en una provincia de este pais");
		}

	}

	public void cargarDatos() {

		tblinscripciones.setModel(new ModelInscripcionP(gp.getPais()));
	}

}

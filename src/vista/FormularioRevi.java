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


import controlador.GestionDatosRevi;

public class FormularioRevi extends JInternalFrame implements ActionListener {
	
	private GestionDatosRevi gd;
	private JTextField txtNombreR;
	private JTextField txtIdioma;
	private JTextField txtTarticulo;
	private JTextField txtNombreAu;
	private JTextField txtApellidoAu;
	private JTable tblinscripciones;

	public FormularioRevi(GestionDatosRevi gd) {
		this.gd = gd;
		setSize(950, 700);
		setVisible(true);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		tblinscripciones = new JTable();
		tblinscripciones.setModel(new ModelInscripcionRe());
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
		pnlIns.add(new JLabel("Nombre de la revista"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridwidth = 2;
		gb.fill = 2;
		txtNombreR = new JTextField(20);
		pnlIns.add(txtNombreR, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 1;
		pnlIns.add(new JLabel("Idioma de la revista"), gb);

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
		pnlIns.add(new JLabel("Titulo del articulo"), gb);


		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 2;
		gb.fill = 1;
		txtTarticulo = new JTextField(20);
		pnlIns.add(txtTarticulo, gb);
		
		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 5;
		pnlIns.add(new JLabel("Nombre del Autor "), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 5;
		//gb.gridwidth = 5;
		gb.fill = 5;
		txtNombreAu = new JTextField(20);
		pnlIns.add(txtNombreAu, gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 7;
		pnlIns.add(new JLabel("Apellido del autor"), gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 7;
		gb.fill = 1;
		txtApellidoAu = new JTextField(20);
		pnlIns.add(txtApellidoAu, gb);

		
		

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
			
			txtNombreR.setText("");
			txtIdioma.setText("");
			txtNombreAu.setText("");
			txtTarticulo.setText("");
			txtApellidoAu.setText("");
			cargarDatos();
			break;
		default:
			break;
		}
	}
	
public void guardarDatosR() throws IOException {
	try {
		String art= gd.buscarArticulo(txtTarticulo.getText().toString().toLowerCase());
		int a = 2/(gd.buscarRevista(txtNombreR.getText().toString().toLowerCase()));
		
	gd.newRevista(txtNombreR.getText().toString().toLowerCase(), txtIdioma.getText().toString().toLowerCase(), txtTarticulo.getText().toString().toLowerCase(),
			txtNombreAu.getText().toString().toLowerCase(), txtApellidoAu.getText().toString().toLowerCase());
	if (art==null) {

		JOptionPane.showMessageDialog(null, "Articulo ya registrado");

	} 
} catch (ArithmeticException e) {

	JOptionPane.showMessageDialog(null, "La revista que ha ingresado ya a sido registrada");

}
}

public void cargarDatos(){
	
	tblinscripciones.setModel(new ModelInscripcionRe(gd.getRevista()));
}	

}

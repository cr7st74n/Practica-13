package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;


import controlador.GestionDatosRevi;
import modelo.Revista;


public class LeerRevi extends JInternalFrame implements ActionListener {

	private GestionDatosRevi gd;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextArea txtaInscripciones;

	public LeerRevi(GestionDatosRevi gd) {

		this.gd = gd;
		setSize(950, 400);
		
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1));

		

		txtaInscripciones = new JTextArea(80, 80);
		JPanel pnlBusqueda = new JPanel();
		pnlBusqueda.add(txtaInscripciones);


		p.add(pnlBusqueda);

		JButton btnCargar = new JButton("Cargar");
		btnCargar.setActionCommand("btnCargar");
		btnCargar.addActionListener(this);

		c.add(p, BorderLayout.CENTER);
		c.add(btnCargar, BorderLayout.SOUTH);

	}


	public void cargar() throws Exception {

			txtaInscripciones.setText(gd.leerArchivos().toString());

	}

	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		switch (comando) {
		case "btnCargar":
			try {
				cargar();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;
			break;
		default:
			break;
		}
	}

}

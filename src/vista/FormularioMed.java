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

import controlador.GestionDatosMedi;

public class FormularioMed extends JInternalFrame implements ActionListener {
	
	private GestionDatosMedi gm;
	private JTextField nombreMed;
	private JTextField turno;
	private JTextField hora;
	private JTextField nombreP;
	private JTextField edad;
	private JTable tblinscripciones;

	public FormularioMed(GestionDatosMedi gm) {
		this.gm = gm;
		setSize(950, 700);
		setVisible(true);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		tblinscripciones = new JTable();
		tblinscripciones.setModel(new ModelInscripcionMed());
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
		pnlIns.add(new JLabel("Nombre del Medico"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridwidth = 2;
		gb.fill = 2;
		nombreMed = new JTextField(20);
		pnlIns.add(nombreMed, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 1;
		pnlIns.add(new JLabel("Numero de turno"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 1;
		gb.gridwidth = 2;
		gb.fill = 2;
		turno = new JTextField(20);
		pnlIns.add(turno, gb);

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 2;
		pnlIns.add(new JLabel("Nombres y Apellidos del paciente"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 2;
		//gb.gridwidth = 5;
		gb.fill = 5;
		nombreP = new JTextField(20);
		pnlIns.add(nombreP, gb);

		
		

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 5;
		pnlIns.add(new JLabel("Hora del turno"), gb);

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 5;
		gb.fill = 1;
		hora = new JTextField(20);
		pnlIns.add(hora, gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 0;
		gb.gridy = 7;
		pnlIns.add(new JLabel("Edad del pasiente"), gb);

		

		gb = new GridBagConstraints();
		gb.gridx = 1;
		gb.gridy = 7;
		gb.fill = 1;
		edad = new JTextField(20);
		pnlIns.add(edad, gb);

		
		

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
			
			nombreMed.setText("");
			turno.setText("");
			nombreP.setText("");
			hora.setText("");
			edad.setText("");
			cargarDatos();
			break;
		default:
			break;
		}
	}
	
public void guardarDatosR() throws IOException {
	try {
		int a = 2/(gm.buscarConsulta(turno.getText().toString().toLowerCase(),hora.getText().toString().toLowerCase()));
		String pas=gm.buscarPaciente(nombreP.getText().toString().toLowerCase());
		if(a==2 && pas!=null){
	gm.newMedico(nombreMed.getText().toString().toLowerCase(), turno.getText().toString().toLowerCase(), hora.getText().toString().toLowerCase(),
			nombreP.getText().toString().toLowerCase(), edad.getText().toString().toLowerCase());
		}else if(pas ==null){
			JOptionPane.showMessageDialog(null, "Pasiente ya registrado ");
		}
		} catch (ArithmeticException e) {

		JOptionPane.showMessageDialog(null, "Un pasiente ya fue registrado (Contiene mismo caracteres de hora o turno)");

	}
}

public void cargarDatos(){
	
	tblinscripciones.setModel(new ModelInscripcionMed(gm.getMedicos()));
}	

}

package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.GestionDatosAtle;
import controlador.GestionDatosEmpr;
import controlador.GestionDatosFich;
import controlador.GestionDatosMedi;
import controlador.GestionDatosPais;
import controlador.GestionDatosRevi;

public class MiVentana extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionDatosRevi gd;
	private GestionDatosPais gp;
	private GestionDatosEmpr ge;
	private GestionDatosAtle ga;
	//private GestionDatosFich gficha;
	//private GestionDatosMedi gm;
	JMenu mnInscripciones;
	JMenuItem Formulario;
	JMenuItem listarInscripciones;
	
	JMenu mnBusqueda;
	JMenuItem BusquedaEstudiante;
	JMenuItem mnCarrera;
	
	JMenu mnRevista;
	JMenuItem agregarR;
	JMenuItem listarR;
	
	JMenu fichaInscripcione;

	JMenuItem ingresarFichas;
	JMenuItem listarfichas;
	
	JMenu medico;
	JMenuItem ingresarMedico;
	JMenuItem listarMedico;
	
	JMenu Atleta;
	JMenuItem ingresarAtleta;
	JMenuItem listarAtleta;
	
	public MiVentana() {
		this.gd = new GestionDatosRevi();
		this.gp = new GestionDatosPais();
		this.ge = new GestionDatosEmpr();
		this.ga = new GestionDatosAtle();
		initComponents();
	}
	
	private void initComponents() {

		setSize(965,660);
		setTitle("Gestion de Datos");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		c.add(escritorio, BorderLayout.CENTER);
		
		JMenuBar barMenu = new JMenuBar();
		
		mnInscripciones = new JMenu("Pais");
		Formulario = new JMenuItem("Ingresar pais");
		Formulario.addActionListener(this);
		Formulario.setActionCommand("mnFor");
		
		listarInscripciones = new JMenuItem("Listar pais");
		listarInscripciones.addActionListener(this);
		listarInscripciones.setActionCommand("mnListarP");
		mnInscripciones.add(Formulario);
		mnInscripciones.add(listarInscripciones);

		
		mnBusqueda = new JMenu("Empresa");
		BusquedaEstudiante = new JMenuItem("Ingresar Empresas");
		BusquedaEstudiante.addActionListener(this);
		BusquedaEstudiante.setActionCommand("mnEmp");
		
		mnCarrera = new JMenuItem("Listar empresas");
		mnCarrera.addActionListener(this);
		mnCarrera.setActionCommand("mnListarEm");
		mnBusqueda.add(BusquedaEstudiante);
		mnBusqueda.add(mnCarrera);
		
		mnRevista  = new JMenu("Revista");
		agregarR = new JMenuItem("Ingresar Revista");
		agregarR.addActionListener(this);
		agregarR.setActionCommand("mnRev");
		listarR = new JMenuItem("Listar Revista");
		listarR.addActionListener(this);
		listarR.setActionCommand("mnListarRev");
		mnRevista.add(agregarR);
		mnRevista.add(listarR);
		
		
		fichaInscripcione  = new JMenu("Ingresar fichas");
		ingresarFichas = new JMenuItem("Agregar Ficha");
		ingresarFichas.addActionListener(this);
		ingresarFichas.setActionCommand("mnAFic");
		
		listarfichas = new JMenuItem("Listar Fichas");
		listarfichas.addActionListener(this);
		listarfichas.setActionCommand("mnListarF");
		fichaInscripcione.add(ingresarFichas);
		fichaInscripcione.add(listarfichas);
		
		medico  = new JMenu("Medico");
		ingresarMedico = new JMenuItem("Agregar Medico");
		ingresarMedico.addActionListener(this);
		ingresarMedico.setActionCommand("mnAgM");
		
		listarMedico = new JMenuItem("Listar Medico");
		listarMedico.addActionListener(this);
		listarMedico.setActionCommand("mnListarM");
		medico.add(ingresarMedico);
		medico.add(listarMedico);
		
		Atleta  = new JMenu("Atleta");
		ingresarAtleta = new JMenuItem("Agregar Atleta");
		ingresarAtleta.addActionListener(this);
		ingresarAtleta.setActionCommand("mnAgAt");
		listarAtleta = new JMenuItem("Listar Atleta");
		listarAtleta.addActionListener(this);
		listarAtleta.setActionCommand("mnListarAt");
		Atleta.add(ingresarAtleta);
		Atleta.add(listarAtleta);
		
		barMenu.add(mnRevista);
		barMenu.add(mnInscripciones);
		barMenu.add(mnBusqueda);
		barMenu.add(fichaInscripcione);
		barMenu.add(medico);
		barMenu.add(Atleta);
		
		setJMenuBar(barMenu);
		
		JOptionPane.showMessageDialog(null, "* Bienvenido estimado Usuario*\n |al siguiente programa|");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		FormularioRevi f = new FormularioRevi(gd);
		LeerRevi be = new LeerRevi(gd);
		
		FormularioPais p=new FormularioPais(gp);
		LeerPais pl = new LeerPais(gp);
		
		FormularioEmp e1=new FormularioEmp(ge);
		LeerEmpr le = new LeerEmpr(ge);
		
		FormularioAtl a=new FormularioAtl(ga);
		LeerAtle la = new LeerAtle(ga);
		
		GestionDatosMedi gm=new GestionDatosMedi();
		FormularioMed m=new FormularioMed(gm);
		LeerMedi lm = new LeerMedi(gm);
		
		GestionDatosFich ficha=new GestionDatosFich();
	FormularioFich F=new FormularioFich(ficha);
	LeerFich lf = new LeerFich(ficha);
		
		String comando = e.getActionCommand();
		
		switch(comando){
		case "mnRev":
			escritorio.removeAll();
			f.setVisible(true);
			escritorio.add(f);
			break;
		case "mnListarRev":
		escritorio.removeAll();
		be.setVisible(true);
		escritorio.add(be);
			break;
		case "mnFor":
			escritorio.removeAll();
			p.setVisible(true);
			escritorio.add(p);
			break;
			
		case "mnListarP":
			escritorio.removeAll();
			pl.setVisible(true);
			escritorio.add(pl);
			break;
			
		case "mnEmp":
			escritorio.removeAll();
			e1.setVisible(true);
			escritorio.add(e1);
			break;
			
		case "mnListarEm":
			escritorio.removeAll();
			le.setVisible(true);
			escritorio.add(le);
			break;
			
		case "mnAgAt":
			escritorio.removeAll();
			a.setVisible(true);
			escritorio.add(a);
			break;
			
		case "mnListarAt":
			escritorio.removeAll();
			la.setVisible(true);
			escritorio.add(la);
			break;
			
			//
	case "mnAFic":
			escritorio.removeAll();
			F.setVisible(true);
			escritorio.add(F);
			break;
			
		case "mnListarF":
			escritorio.removeAll();
			lf.setVisible(true);
			escritorio.add(lf);
			break;
			
		case "mnAgM":
			escritorio.removeAll();
			m.setVisible(true);
			escritorio.add(m);
			break;
			
		case "mnListarM":
			escritorio.removeAll();
			lm.setVisible(true);
			escritorio.add(lm);
			break;
			
		default:
			break;
		}
		
	}

}

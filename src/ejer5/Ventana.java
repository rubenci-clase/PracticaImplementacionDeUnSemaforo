package ejer5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

class Ventana extends JFrame{
	
	public Ventana(String nombreVentana) {
		super(nombreVentana);
		
		

		//Características de la ventana
		setSize(540, 420);
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		//Título
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(135, 206, 235));
		titulo = new JLabel("Formulario de inscripción");
		titulo.setFont(new Font("ITALIC", Font.ITALIC, 22));
		panelTitulo.add(titulo);
		add(panelTitulo, BorderLayout.NORTH);
		
		//Añadimos el formulario
		panelCentral = new LaminaFormulario();
		add(panelCentral, BorderLayout.CENTER);
		
		//Botón de enviar
		botonEnviar = new JButton("Enviar");
		botonEnviar.addActionListener(new ListenerBotonEnviar()); //ActionListener para comprobar los datos
		botonEnviar.setFont(fuenteTitulo);
		botonEnviar.setBackground(new Color(70, 130, 180));
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(colorFondo);
		panelBoton.add(botonEnviar);
		add(panelBoton, BorderLayout.SOUTH);	
	}
	
	class LaminaFormulario extends JPanel{
		public LaminaFormulario() {
			setBackground(colorFondo);
			//añadimos cada titulo y cuadro de texto a la lámina.
			add(new LaminaLinea("Nombre", nombre));
			add(new LaminaLinea("Apellido 1", apellido1));
			add(new LaminaLinea("Apellido 2", apellido2));
			add(new LaminaLinea("Fecha nacimiento dd/mm/yyyy", fechaNacimiento));
			add(new LaminaLinea("Email", email));
		}	
	}
	
	class LaminaLinea extends JPanel{	
		public LaminaLinea(String nombre, JTextField Cuadrotexto) {
			setBackground(colorFondo);
			setLayout(new GridLayout(2,1));
			//Modificamos la etiqueta que va antes del Cuadro de texto
			JLabel label = new JLabel(nombre);
			label.setFont(fuenteTitulo); //Letra en negrita y más grande

			//Modificamos el cuadro de texto
			Cuadrotexto.setFont(funeteNormal); //Letra sin negrita y más pequeña
			Cuadrotexto.setBackground(colorCuadrosDeTexto);
			Cuadrotexto.setBorder(new LineBorder(new Color(211, 211, 211))); //Borde gris
			
			add(label); //Titulo
			add(Cuadrotexto); //Cuadro de texto
		}
	}
	
	class LaminaLineaMostrarDatos extends JPanel{
		public LaminaLineaMostrarDatos(String nombrePropiedad, String propiedad) {
			setBackground(colorFondo);
			setLayout(new FlowLayout(FlowLayout.LEFT));
			
			JLabel label = new JLabel(nombrePropiedad);
			label.setFont(fuenteTitulo);
			
			JLabel dato = new JLabel(propiedad);
			dato.setFont(funeteNormal);
			
			add(label);
			add(dato);	
		}		
	}
	
	class LaminaMostrarDatos extends JPanel{
		public LaminaMostrarDatos() {
			setBackground(colorFondo);
			setLayout(new GridLayout(6,1));
			
			add(new JLabel("  Has enviado el formulario con los siguientes datos:")).setFont(fuenteTitulo);
			add(new LaminaLineaMostrarDatos("   Nombre: ", nombre.getText()));
			add(new LaminaLineaMostrarDatos("   Apellido 1: ", apellido1.getText()));
			add(new LaminaLineaMostrarDatos("   Apellido 2: ", apellido2.getText()));
			add(new LaminaLineaMostrarDatos("   Fecha nacimiento: ", fechaNacimiento.getText()));
			add(new LaminaLineaMostrarDatos("   Email: ", email.getText()));
		}	
	}
	
	class ListenerBotonCerrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);	
		}
	}
	
	class ListenerBotonEnviar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int contadorErrores = 0;
			
			if(!Comprobar.Nombre(nombre.getText())) { //Si el nombre no es valido pintamos en rojo el campo
				nombre.setBackground(colorCuadrosError);
				contadorErrores++;
			}
			else nombre.setBackground(colorCuadrosDeTexto);
			
			if(!Comprobar.Nombre(apellido1.getText())) { //Si el apellido1 no es valido pintamos en rojo el campo
				apellido1.setBackground(colorCuadrosError);
				contadorErrores++;
			}
			else apellido1.setBackground(colorCuadrosDeTexto);
			
			if(!Comprobar.Nombre(apellido2.getText())) { //Si el apellido2 no es valido pintamos en rojo el campo
				apellido2.setBackground(colorCuadrosError);
				contadorErrores++;
			}
			else apellido2.setBackground(colorCuadrosDeTexto);
			
			if(!Comprobar.Fecha(fechaNacimiento.getText())) { //Si la fecha no es valida pintamos en rojo el campo
				fechaNacimiento.setBackground(colorCuadrosError);
				contadorErrores++;
			}
			else fechaNacimiento.setBackground(colorCuadrosDeTexto);
			
			if(!Comprobar.Correo(email.getText())) { //Si el email no es valida pintamos en rojo el campo
				email.setBackground(colorCuadrosError);
				contadorErrores++;
			}
			else email.setBackground(colorCuadrosDeTexto);
			
			if (contadorErrores >= 1) { //Si tenemos un error o más lo indicamos y dejamos que se corrijan
				JOptionPane.showMessageDialog(null, "Hay " + contadorErrores + " datos incorrectos introducidos", 
						"Error en los datos", JOptionPane.ERROR_MESSAGE);
			}
			else { //Si no hay errores quitamos el panel que tenía el formulario y mostramos en su lugar uno con los datos.
				panelCentral.setVisible(false); //Quitamos el panel que contiene el formulario
				titulo.setText("Datos de formulario"); //Cambiamos el texto del JLabel superior
				add(new LaminaMostrarDatos(), BorderLayout.CENTER); //Añadimos en el hueco que hemos dejado libre el nuevo panel con la info introducida
				botonEnviar.setText("Cerrar"); //Cambiamos el texto del botón a cerrar
				botonEnviar.addActionListener(new ListenerBotonCerrar()); //Indicamos que el boton cambie de actionListener
			}
		}
	}
	
	//Campos del formulario
	JTextField nombre = new JTextField(20);
	JTextField apellido1 = new JTextField(20);
	JTextField apellido2 = new JTextField(20);
	JTextField fechaNacimiento = new JTextField(20);
	JTextField email = new JTextField(20);
	JPanel panelCentral;
	JLabel titulo;
	JButton botonEnviar;
		
	Color colorFondo = new Color(240, 248, 255);
	Color colorCuadrosDeTexto = new Color(255, 250, 240);
	Color colorCuadrosError = new Color(255, 99, 71);
		
	Font fuenteTitulo = new Font("BOLD", Font.BOLD, 19);
	Font funeteNormal = new Font("PLAIN", Font.PLAIN, 18);
}

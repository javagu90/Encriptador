/**
 * @(#)Criptografia.java
 *
 *
 * @author Javier Valderrábano Gutiérrez 
 * @version 1.00 2013/3/23
 */
package Cryptography;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Criptografia extends JFrame implements ActionListener
{
 private Container Ccontenedor;
 private JPanel JPpanel, JPpanel2;
 private JButton encriptar, desencriptar;
 private JTextArea natural, encriptado;
 private JComboBox JCBlista;
 private JScrollPane JSPscrol1, JSPscrol2;
 public Cesar cesc;
 public Avanzados algadv;
 public Atbash espejo;
 public Albam ROT13;
 public Atbah atba;
 public String nature, encrypth;
 public Criptografia() 
 {
  super("Criptografia");
  Ccontenedor = getContentPane();
  Ccontenedor.setLayout(new BorderLayout());
  CreaPanel();
  cesc=new Cesar();
  algadv=new Avanzados();
  espejo=new Atbash();
  ROT13=new Albam();
  atba=new Atbah();
  Ccontenedor.add(JPpanel, BorderLayout.WEST);
  setSize(645,415);
  setVisible(true);
  setResizable(false);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public void CreaPanel()
 {
  JPpanel=new JPanel();
  JPpanel.setLayout(new FlowLayout());
  
  String elementos[] = {"Tipo de Encriptacion","Cesar","MD5","SHA-1","Atbash (Espejo)","Albam (ROT13)","Atbah"};
  
  JCBlista=new JComboBox (elementos);
  JCBlista.setMaximumRowCount(3);

  encriptar=new JButton("Encriptar");
  encriptar.addActionListener(this);
  desencriptar= new JButton("Desencriptar");
  desencriptar.addActionListener(this);
  
  natural = new JTextArea(20,20);
 // natural.setToolTipText("Escriba el texto a encriptar");
  //Si se selecciona a true, las líneas se parten si son demasiado largas 
  //para entrar en la anchura adecuada. Si se selecciona a false, 
  //las líneas no son partidas.
  natural.setLineWrap(true);
  //Si se selecciona a true las líneas se partirán en un límite 
  //de palabra como un espacio en blanco. 
  //Si selecciona a false, las líneas se partirán en caracteres.
  natural.setWrapStyleWord(true);		
  JSPscrol1 = new JScrollPane(natural);
  //hacer q sea mi area d texto una forma para ver un documento de texto
  //como si fuera el WordPad de windows
  //hacer q sea mi area d texto una forma para ver un documento de texto
  //como si fuera el WordPad de windows
  JSPscrol1.setViewportView(natural);	
  //creamos un borde
  natural.setBorder(BorderFactory.createTitledBorder("Natural"));
  
  encriptado = new JTextArea(20,20);
 // natural.setToolTipText("Escriba el texto a encriptar");
  //Si se selecciona a true, las líneas se parten si son demasiado largas 
  //para entrar en la anchura adecuada. Si se selecciona a false, 
  //las líneas no son partidas.
  encriptado.setLineWrap(true);
  //Si se selecciona a true las líneas se partirán en un límite 
  //de palabra como un espacio en blanco. 
  //Si selecciona a false, las líneas se partirán en caracteres.
  encriptado.setWrapStyleWord(true);		
  JSPscrol2 = new JScrollPane(encriptado);
  //hacer q sea mi area d texto una forma para ver un documento de texto
  //como si fuera el WordPad de windows
  //hacer q sea mi area d texto una forma para ver un documento de texto
  //como si fuera el WordPad de windows
  JSPscrol2.setViewportView(encriptado);	
  //creamos un borde
  encriptado.setBorder(BorderFactory.createTitledBorder("Encriptado"));
  
  JPpanel.add(JSPscrol1);
  JPpanel.add(JSPscrol2);
  JPpanel.add(JCBlista);
  
  JPpanel2=new JPanel();
  JPpanel2.setLayout(new FlowLayout());
  
  JPpanel2.add(encriptar);
  JPpanel2.add(desencriptar);
  
  Ccontenedor.add(JPpanel2, BorderLayout.SOUTH);
  
 }
 public void actionPerformed(ActionEvent ee)
 {
  //System.out.println(JCBlista.getSelectedIndex());
  int seleccion;
  if((ee.getSource()==encriptar) && (natural.getText().isEmpty()==false))
  {
   seleccion=JCBlista.getSelectedIndex();
   switch(seleccion)
   {
   	case 0:
    {
     JOptionPane.showMessageDialog(null,"SELECCIONE UN ALGORITMO A UTILIZAR!","ERROR DE SELECCION",JOptionPane.ERROR_MESSAGE);
     break;
    }
    case 1:
    {	
     encrypth=cesc.Encriptar(natural.getText(),2);
     encriptado.setText(encrypth);
     break;
    }
    case 2:
    {
     encrypth=algadv.getStringMessageDigest(natural.getText(),"MD5");
     encriptado.setText(encrypth);
	 break;
    }
    case 3:
    {
     encrypth=algadv.getStringMessageDigest(natural.getText(),"SHA-1");
     encriptado.setText(encrypth);
     break;
    }
    case 4:
    {
     encrypth=espejo.encripta(natural.getText());
     encriptado.setText(encrypth);
     break;
    }
    case 5:
    {
     encrypth=ROT13.encripta(natural.getText());
     encriptado.setText(encrypth);
     break;
    }
    case 6:
    {
     encrypth=atba.encripta(natural.getText());
     encriptado.setText(encrypth);
     break;
    }
   }
  }
  else
  	if((ee.getSource()==desencriptar) &&(encriptado.getText().isEmpty()==false))
  	{
  	 seleccion=JCBlista.getSelectedIndex();
     switch(seleccion)
     {
      case 0:
      {
       JOptionPane.showMessageDialog(null,"SELECCIONE UN ALGORITMO A UTILIZAR!","ERROR DE SELECCION",JOptionPane.ERROR_MESSAGE);
       break;
      }
      case 1:
      {	
       nature=cesc.Desencriptar(encriptado.getText(),2);
       natural.setText(nature);
       //desencriptar.setEnabled(false);
       break;
      }
      case 4:
      {
       nature=espejo.desencripta(encriptado.getText());
       natural.setText(nature);
       break;
      }
      case 5:
      {
       nature=ROT13.desencripta(encriptado.getText());
       natural.setText(nature);
       break;
      }
      case 6:
      {
       nature=atba.desencripta(encriptado.getText());
       natural.setText(nature);
       break;
      }
  	 }		
  	}
  	else
  	 	if ((ee.getSource()==encriptar) && (natural.getText().isEmpty()==true) ||((ee.getSource()==desencriptar) && (encriptado.getText().isEmpty()==true)))
  	 		JOptionPane.showMessageDialog(null,"RELLENE EL AREA A UTILIZAR!","ERROR DE TEXTO",JOptionPane.ERROR_MESSAGE);
   }
  }
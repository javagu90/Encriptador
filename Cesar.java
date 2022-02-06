/**
 * @(#)Cesar.java
 *
 *
 * @author Javier Valderrábano Gutiérrez
 * @version 1.00 2013/3/27
 */
package Cryptography;
public class Cesar 
{
 private String tabla = "abcdefghijklmnopqrstuvwxyzáéíóú 1234567890@.,;:-+*/$#¿?!¡=()[]{}";
 
 public String Encriptar(String t, int key)
 {
  //String texto = LimpiarCadena(t);
  t=t.toLowerCase();
  String texto=t;
  //aqui se almacena el resultado
  String res = "";
  for(int i = 0; i < texto.length();i++)
  {
   //busca la posicion del caracter en la variable tabla
   int pos = tabla.indexOf(texto.charAt(i));
   //realiza el reemplazo
   if ((pos + key) < tabla.length())
    res = res + tabla.charAt(pos+key);
   else
    res = res + tabla.charAt((pos+key) - tabla.length());
  }
  return res;
 }
 
 public String Desencriptar(String t, int key)
 {
  t=t.toLowerCase();
  String texto = LimpiarCadena(t);
  String res = "";
  for(int i = 0; i < texto.length();i++)
  {
   int pos = tabla.indexOf(texto.charAt(i));
   if ((pos - key) < 0)
    res = res + tabla.charAt((pos-key) + tabla.length());
   else
    res = res + tabla.charAt(pos-key);
    res=res.toLowerCase();
  }
  return res;
 }
 
 private String LimpiarCadena(String t)
 {
  //transforma el texto a minusculas
  t = t.toLowerCase();
  //eliminamos todos los retornos de carro
  t = t.replaceAll("\n", "");
  //eliminamos caracteres prohibidos
  for(int i = 0; i < t.length();i++)
  {
   int pos = tabla.indexOf(t.charAt(i));
   if (pos == -1)
    t = t.replace(t.charAt(i), ' ');
  }
  return t;
 }
}
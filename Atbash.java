/**
 * @(#)Atbash.java
 *
 *
 * @author Javier Valderrábano Gutiérrez
 * @version 1.00 2013/4/4
 */
package Cryptography;
public class Atbash 
{
 char abc[]={'.','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
 char xyz[]={'.','z','y','x','w','v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a','0','9','8','7','6','5','4','3','2','1'};
 public String encripta(String s)
 {
  s=s.toLowerCase();
  String cadena="";
  int i=0, j=0;
  do
  {
   if(s.charAt(i)==abc[j])
   {
  	cadena+=xyz[j];
  	i++;
  	j=0;
   }
   else
   {
    if(s.charAt(i)==' ')
    {
  	 cadena+=' ';
  	 i++;
  	 j=0;
    }
   }
   j++;
  }while(cadena.length()!=s.length());
  return cadena;
 }
 
 public String desencripta(String s)
 {
  s=s.toLowerCase();
  String cadena="";
  int i=0, j=0;
  do
  {
   if(s.charAt(i)==xyz[j])
   {
  	cadena+=abc[j];
  	i++;
  	j=0;
   }
   else
   {
    if(s.charAt(i)==' ')
    {
  	 cadena+=' ';
  	 i++;
  	 j=0;
    }
   }
   j++;
  }while(cadena.length()!=s.length());
  return cadena;
 }
}
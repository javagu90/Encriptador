/**
 * @(#)Atbah.java
 *
 *
 * @author Javier Valderrabano Gutierrez
 * @version 1.00 2013/4/9
 */

package Cryptography;
public class Atbah 
{
 char abc[]={'.','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
 char ihg[]={'.','i','h','g','f','n','d','c','b','a','r','q','p','o','e','m','l','k','j','z','y','x','w','v','u','t','s','1','3','5','7','9','2','4','6','8','0'};
 public String encripta(String s)
 {
  s=s.toLowerCase();
  String cadena="";
  int i=0, j=0;
  do
  {
   if(s.charAt(i)==abc[j])
   {
  	cadena+=ihg[j];
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
   if(s.charAt(i)==ihg[j])
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
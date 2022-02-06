/**
 * @(#)Albam.java
 *
 *
 * @author Javier Valderrabano Gutierrez
 * @version 1.00 2013/4/9
 */

package Cryptography;
public class Albam 
{
  char abc[]={'.','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
  char nmo[]={'.','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','3','4','5','6','7','8','9','0','1','2'};
 public String encripta(String s)
 {
  s=s.toLowerCase();
  String cadena="";
  int i=0, j=0;
  do
  {
   if(s.charAt(i)==abc[j])
   {
  	cadena+=nmo[j];
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
   if(s.charAt(i)==nmo[j])
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
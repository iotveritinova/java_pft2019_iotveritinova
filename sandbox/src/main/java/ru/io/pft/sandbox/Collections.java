package ru.io.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    /*    same massive
    String[] langs=new String[4];
    langs[0]="Java";
    langs[1]="C#";
    langs[2]="Python";
    langs[3]="PHP";
    */
    String[] langs = {"Java", "C#", "Python", "PHP"};

    /*same list
    List<String> languages =new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");
    */
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    /*    same cicle
    for (int i=0;i<langs.length;i++)
    {System.out.println("Я хочу выучить "+langs[i]);}
    */
    for (String l : langs) {
      System.out.println("Я хочу выучить " + l);
    }
    for (String l : languages) {
      System.out.println("Я очень хочу выучить " + l);
    }
   /*    same list
    for (int i=0;i<languages.size();i++) {

      System.out.println("Я очень хочу выучить " + languages.get(i));
    }
    */
  }
}

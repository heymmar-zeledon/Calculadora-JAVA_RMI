/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadora_cliente_servidor;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
/**
 *
 * @author eliazith
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String Ip = new String();
        JOptionPane.showMessageDialog(null,"Bienvenido\n");
        Ip = JOptionPane.showInputDialog("Ingrese la Direccion Ip del servidor:\n");
        String Puerto = JOptionPane.showInputDialog("Ingrese el Puerto donde escucha el servidor:\n");
        int Port = Integer.parseInt(Puerto);
        try
        {
            Registry Registro = LocateRegistry.getRegistry(Ip,Port);
            Operaciones OP = (Operaciones) Naming.lookup("//"+Ip+"/Operaciones");
            boolean Continuar = true;
            while(Continuar == true)
            {
                String menu = JOptionPane.showInputDialog("--Calculadora RMI--\n"+
                "Division [1]\n"+
                "Resta    [2]\n"+
                "Multiplicacion  [3]\n"+
                "Suma     [4]\n"+
                "Cancelar >> para salir de la calculadora");
                switch(menu)
                {
                    case "1":
                        try
                        {
                            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                            int Result = OP.division(num1, num2);
                            if (Result ==0) 
                            {
                                JOptionPane.showMessageDialog(null,"La division entre 0 no existe");
                            }
                            else
                            {
                              JOptionPane.showMessageDialog(null,"La Division de: "+num1+"/"+num2+": "+Result);
                            }
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showInternalMessageDialog(null,e);
                        }
                    break;
                    case "2":
                        try
                        {
                            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                            int Result = OP.resta(num1, num2);
                            JOptionPane.showMessageDialog(null,"La resta de "+num1+"-"+num2+": "+Result);
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showInternalMessageDialog(null,e);
                        }
                    break;
                    case "3":
                        try
                        {
                            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                            int Result = OP.multiplicacion(num1, num2);
                            JOptionPane.showMessageDialog(null,"La multiplicacion de "+num1+"*"+num2+": "+Result);
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showInternalMessageDialog(null,e);
                        }
                    break;
                    case "4":
                        try
                        {
                            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
                            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
                            int Result = OP.suma(num1, num2);
                            JOptionPane.showMessageDialog(null,"La suma de "+num1+"+"+num2+": "+Result);
                        }
                        catch(Exception e)
                        {
                            JOptionPane.showInternalMessageDialog(null,e);
                        }
                    break;
                    case "Cancelar":
                        JOptionPane.showMessageDialog(null,"->Cierre de la calculadora...\n"); 
                       
                        Continuar = false;
                    break;
                    default:
                        JOptionPane.showMessageDialog(null,"->Opcion no valida\n");
                    break;
                }
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "->Servidor no conectado "+e);
        }
    }
    
}

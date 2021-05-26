/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadora_cliente_servidor;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
/**
 *
 * @author eliazith
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try
        {
            Registry x = java.rmi.registry.LocateRegistry.createRegistry(1099);
            x.rebind("Operaciones", new Calculos_RMI());
            JOptionPane.showMessageDialog(null, "->Servidor conectado");
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "servidor no concectado!! "+ e);
        }
    }
    
}

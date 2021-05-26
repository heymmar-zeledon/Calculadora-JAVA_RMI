/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadora_cliente_servidor;
import java.rmi.*;
/**
 *
 * @author eliazith
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Operaciones extends Remote
{
    public String notificacion(String Message)throws java.rmi.RemoteException;
    public int division(int num1, int num2)throws RemoteException;
    public int resta(int num1, int num2)throws RemoteException;
    public int multiplicacion(int num1, int num2)throws RemoteException;
    public int suma(int num1, int num2)throws RemoteException;
}

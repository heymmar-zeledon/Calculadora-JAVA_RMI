/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculadora_cliente_servidor;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author eliazith
 */
public class Calculos_RMI extends UnicastRemoteObject implements Operaciones
{
    public Calculos_RMI() throws RemoteException
    {
        super( );
        int num1, num2;
    }
    @Override
    public String notificacion(String message) throws RemoteException
    {
        String returnMessage = "Call back received: "+ message;
        System.out.println(returnMessage);
        return returnMessage;
    }
    @Override
    public int division(int num1, int num2) throws RemoteException
    {
        if(num2 == 0)
        {
            return 0;
        }
        else
        {
            return num1 / num2;
        }
    }
    @Override
    public int resta(int num1, int num2) throws RemoteException
    {
        return num1 - num2;
    }
    @Override
    public int multiplicacion(int num1, int num2) throws RemoteException
    {
        return num1 * num2;
    }
    @Override
    public int suma(int num1, int num2) throws RemoteException
    {
        return num1 + num2;
    }
}

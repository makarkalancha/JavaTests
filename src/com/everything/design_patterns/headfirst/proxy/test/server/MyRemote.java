package com.everything.design_patterns.headfirst.proxy.test.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 2:07 PM
 */
public interface MyRemote extends Remote{
    public String sayHello() throws RemoteException;
}

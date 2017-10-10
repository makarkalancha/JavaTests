package com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.server.engine;

import com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.compute.Compute;
import com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 3:07 PM
 */
public class ComputeEngine implements Compute {
    public ComputeEngine(){
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        System.out.println("Inside executeTask");
        return t.execute();
    }

    public static void main(String[] args) {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name,stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

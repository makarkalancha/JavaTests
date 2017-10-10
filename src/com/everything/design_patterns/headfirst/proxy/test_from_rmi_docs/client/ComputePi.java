package com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.client;

import com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.compute.Compute;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 4:42 PM
 */
public class ComputePi {
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e){
            System.err.println(">>>ComputePi Exception:");
            e.printStackTrace();
        }
    }
}

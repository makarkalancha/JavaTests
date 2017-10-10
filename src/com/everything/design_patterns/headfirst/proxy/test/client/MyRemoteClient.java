package com.everything.design_patterns.headfirst.proxy.test.client;

import com.everything.design_patterns.headfirst.proxy.test.server.MyRemote;

import java.rmi.Naming;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 2:09 PM
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        try {
//            MyRemote service = new MyRemoteImpl("bitch");
//            Naming.rebind("RemoteHello",service);

            //WORKING
            MyRemote service = (MyRemote) Naming.lookup("//localhost/Hello");
            System.out.println(service.sayHello());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

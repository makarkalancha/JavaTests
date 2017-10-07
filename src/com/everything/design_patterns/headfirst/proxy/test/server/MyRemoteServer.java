package com.everything.design_patterns.headfirst.proxy.test.server;

import java.rmi.Naming;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 3:32 PM
 */
public class MyRemoteServer {
    public static void main(String[] args) {
        try {
            String word = "bitch, motherfucker";
            if(args.length > 0) {
                word = args[0];
            }
//            Naming.rebind("Hello", new MyRemoteImpl(word));

//            if(System.getSecurityManager() == null){
//                System.setSecurityManager(new SecurityManager(){
//                    @Override
//                    public void checkConnect(String host, int port) {
//                        super.checkConnect(host, port);
//                    }
//
//                    @Override
//                    public void checkConnect(String host, int port, Object context) {
//                        super.checkConnect(host, port, context);
//                    }
//                });
//            }
            MyRemote myRemote = new MyRemoteImpl(word);
            Naming.bind("Hello",myRemote);

            System.out.println("Server is ready");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Server FAILED");
        }
    }
}

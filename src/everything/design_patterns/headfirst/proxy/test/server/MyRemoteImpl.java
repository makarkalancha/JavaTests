package everything.design_patterns.headfirst.proxy.test.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 2:08 PM
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    private String message;
    public MyRemoteImpl(String message) throws RemoteException{
        this.message = message;
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says, "+message;
    }
}

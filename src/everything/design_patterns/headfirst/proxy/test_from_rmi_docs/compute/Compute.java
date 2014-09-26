package everything.design_patterns.headfirst.proxy.test_from_rmi_docs.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 2:44 PM
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}

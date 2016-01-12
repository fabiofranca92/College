package implement;
import Interface.ConsultaE;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Filipe
 */
public class ConsultaE_Impl extends UnicastRemoteObject implements ConsultaE, java.io.Serializable {
    private int idenfermeiro;
    private int idutente;
    
    
  public ConsultaE_Impl(int idenfermeiro, int idutente) throws RemoteException{
      
      this.idenfermeiro= idenfermeiro;
      this.idutente= idutente;
      
  }  
    
    
    @Override
    public void setenfermeiro(int idenfermeiro) throws RemoteException {
        this.idenfermeiro= idenfermeiro;
    }
    @Override
    public void setidutente(int idutente) throws RemoteException {
        this.idutente= idutente;
       }
    
}
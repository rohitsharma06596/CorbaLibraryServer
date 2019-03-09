import LibraryApp.*;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.Object;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class Server_Manager {
    /**
     * This is the main trigger method which creates multiple instances of the Base Server class,
     * and checks the validation.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            Server_Base concordiaLib = new Server_Base("CONCORDIA");
            concordiaLib.setORB(orb);
            concordiaLib = concordiaLib.loadServerRec(concordiaLib);

            Server_Base mcgillLib = new Server_Base("MCGILL");
            mcgillLib = mcgillLib.loadServerRec(mcgillLib);
            mcgillLib.setORB(orb);

            Server_Base montrealuLib = new Server_Base("MONTREALU");
            montrealuLib = montrealuLib.loadServerRec(montrealuLib);
            montrealuLib.setORB(orb);

            Object concordiaRef = rootpoa.servant_to_reference(concordiaLib);
            Object mcgillRef = rootpoa.servant_to_reference(mcgillLib);
            Object montrealRef = rootpoa.servant_to_reference(montrealuLib);

            Library concordiaHpref = LibraryHelper.narrow(concordiaRef);
            Library mcgillHpref = LibraryHelper.narrow(mcgillRef);
            Library montrealHpref = LibraryHelper.narrow(montrealRef);

            Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent[] concordiaPath = ncRef.to_name("CON");
            ncRef.rebind(concordiaPath, concordiaHpref);
            System.out.println("*************************************************************************");
            System.out.println("Concordia Library has Started\n");

            NameComponent[] mcgillPath = ncRef.to_name("MCG");
            ncRef.rebind(mcgillPath, mcgillHpref);
            System.out.println("*************************************************************************");
            System.out.println("Mcgill Library has Started\n");

            NameComponent[] montrealPath = ncRef.to_name("MON");
            ncRef.rebind(montrealPath, montrealHpref);
            System.out.println("*************************************************************************");
            System.out.println("Montreal University Library has Started\n");
        }
        catch (Exception e)
        {
            System.err.println("ERROR: " + e);
            e.printStackTrace();
        }
    }



}

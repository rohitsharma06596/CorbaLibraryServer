package LibraryApp;


import java.net.UnknownHostException;

/**
* LibraryApp/LibraryPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Library.idl
* Friday, March 8, 2019 7:16:00 o'clock PM EST
*/

public abstract class LibraryPOA extends org.omg.PortableServer.Servant
 implements LibraryApp.LibraryOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("addItem", new java.lang.Integer (0));
    _methods.put ("removeItem", new java.lang.Integer (1));
    _methods.put ("listItemAvailability", new java.lang.Integer (2));
    _methods.put ("borrowItem", new java.lang.Integer (3));
    _methods.put ("findItem", new java.lang.Integer (4));
    _methods.put ("returnItem", new java.lang.Integer (5));
    _methods.put ("verify", new java.lang.Integer (6));
    _methods.put ("load_server", new java.lang.Integer (7));
    _methods.put ("addToWait", new java.lang.Integer (8));
    _methods.put ("exchangeItem", new java.lang.Integer (9));
    _methods.put ("shutdown", new java.lang.Integer (10));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // LibraryApp/Library/addItem
       {
         String managerID = in.read_string ();
         String itemID = in.read_string ();
         String itemName = in.read_string ();
         int quantity = in.read_long ();
         String $result = null;
         $result = this.addItem (managerID, itemID, itemName, quantity);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // LibraryApp/Library/removeItem
       {
         String managerID = in.read_string ();
         String itemID = in.read_string ();
         int quantity = in.read_long ();
         boolean completeRemove = in.read_boolean ();
         String $result = null;
         $result = this.removeItem (managerID, itemID, quantity, completeRemove);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // LibraryApp/Library/listItemAvailability
       {
         String managerID = in.read_string ();
         String $result = null;
         $result = this.listItemAvailability (managerID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // LibraryApp/Library/borrowItem
       {
         String userID = in.read_string ();
         String itemID = in.read_string ();
         int numberOfDays = in.read_long ();
         String $result = null;
           try {
               $result = this.borrowItem (userID, itemID, numberOfDays);
           } catch (UnknownHostException e) {
               e.printStackTrace();
           }
           out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // LibraryApp/Library/findItem
       {
         String userID = in.read_string ();
         String itemName = in.read_string ();
         String $result = null;
           try {
               $result = this.findItem (userID, itemName);
           } catch (UnknownHostException e) {
               e.printStackTrace();
           }
           out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 5:  // LibraryApp/Library/returnItem
       {
         String userID = in.read_string ();
         String itemID = in.read_string ();
         String $result = null;
         $result = this.returnItem (userID, itemID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 6:  // LibraryApp/Library/verify
       {
         String ID = in.read_string ();
         String $result = null;
         $result = this.verify (ID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 7:  // LibraryApp/Library/load_server
       {
         String server_name = in.read_string ();
         boolean $result = false;
         $result = this.load_server (server_name);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 8:  // LibraryApp/Library/addToWait
       {
         String parm = in.read_string ();
         String itemID = in.read_string ();
         String userID = in.read_string ();
         String $result = null;
         $result = this.addToWait (parm, itemID, userID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 9:  // LibraryApp/Library/exchangeItem
       {
         String userID = in.read_string ();
         String newItemID = in.read_string ();
         String oldItemID = in.read_string ();
         String $result = null;
         $result = this.exchangeItem (userID, newItemID, oldItemID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 10:  // LibraryApp/Library/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:LibraryApp/Library:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Library _this() 
  {
    return LibraryHelper.narrow(
    super._this_object());
  }

  public Library _this(org.omg.CORBA.ORB orb) 
  {
    return LibraryHelper.narrow(
    super._this_object(orb));
  }


} // class LibraryPOA
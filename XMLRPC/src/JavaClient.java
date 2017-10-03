import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Hashtable;


public class JavaClient {

    // The location of our server.
    private final static String server_url =
        "http://xmlrpc-c.sourceforge.net/api/sample.php";

    public static void main (String [] args) {

    	XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    		    
    	        try{
    	
    	            config.setServerURL(new URL("http://192.168.1.151:3306/xmlrpc"));
    	            XmlRpcClient client = new XmlRpcClient();
    	            client.setConfig(config);
    	            // Assuming some.method has a 'String', 'Int', 'Int' signature and returns Int
                    Object[] params = new Object[]{ new String("Some Text"),
    		                                    new Integer(38),
    	                                            new Integer(0),
    	                                          };
    			    
    	            Integer result = (Integer)client.execute("some.method", params);
    	            System.out.println("Results" + result);
    	        }
    	        catch(Exception e)
    	        {
    	            System.out.println("Exception: " + e.getMessage());
    		}  	
    	
    	
    	
    	
  }
}
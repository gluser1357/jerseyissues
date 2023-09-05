package gluser1357.client;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyClient {

	public static void main(String[] args)
	throws Exception {
        WebAppContext webappContext = new WebAppContext();
        webappContext.setContextPath("/jerseyissue-4867-wicket10");
        webappContext.setResourceBase(computeTargetResourceBase());
        //webappContext.setParentLoaderPriority(true);
        
        Server server = new Server(8080); 
        server.setHandler(webappContext);
        server.start();
	}
	
	public static String computeTargetResourceBase() {

		// look for target/.../WEB-INF in current dir
		File f = findFile(new File("target"), "WEB-INF");
		String dir = f == null ? null : f.getParent();
		return dir;
	}
	
     private static File findFile(File f0, String name) {
         
    	 if (f0.getName().equals(name)) return f0;
         if (!f0.isDirectory()) return null;
         
         for (File f : f0.listFiles()) {
        	 File found = findFile(f, name);
             if (found != null) return found;
         }
         return null;
     }

}

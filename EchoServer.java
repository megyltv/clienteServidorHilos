package echo;

import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoServer {
    public static void main() throws IOException {
        
        
        /*if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }*/
        
        int portNumber = 8080;
        
        try         
        {
            ServerSocket serverSocket = new ServerSocket();
            Socket clientSocket = serverSocket.accept();
            Thread t1 = new Thread(new MiThread(clientSocket));
            t1.start();
            
            try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
//import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EchoServer {
    public static void main(String[] args) throws IOException {   
        
        /*if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }*/
        
        int portNumber = 8000;
        
        try        
        {
            ServerSocket serverSocket = new ServerSocket(8000);
            /*ArrayList<Socket> clientS=new ArrayList();
            clientS.add(serverSocket.accept());
            for(Socket s:clientS){
                
            }*/
            Socket clientSocket = serverSocket.accept();
            Socket clientSocket2 = serverSocket.accept();
            Thread t1 = new Thread(new MiThread(clientSocket,clientSocket2));
            Thread t2 = new Thread(new MiThread(clientSocket2,clientSocket));
            t1.start();
            t2.start();
            
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

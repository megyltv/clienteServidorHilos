/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

/**
 *
 * @author USRDES
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class EchoServer {
    public static void main(String[] args) throws IOException {   
        
        int portNumber = 8000;
        int i,j=1;
        
        try        
        {
            ServerSocket serverSocket = new ServerSocket(8000);
            ArrayList<Socket> clientS=new ArrayList();
            ArrayList<Thread> threads=new ArrayList();
            
            for(i=0;i<j;i++){
                Socket clientSocket = serverSocket.accept();
                clientS.add(clientSocket);
            
                Thread t1 = new Thread(new MiThread(clientSocket));
                threads.add(t1);
                t1.start();
                j++;
                
                //Enrutamiento
                System.out.println(t1.toString());
            }
            /*try {
                t1.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EchoServer.class.getName()).log(Level.SEVERE, null, ex);
            }*/

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
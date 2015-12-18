/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiThread extends Thread{
   
    Socket clientSocket;
    Socket clientSocket2;
    
    public MiThread(Socket client,Socket client2){
        clientSocket=client;
        clientSocket2=client2;
    }
    
    public void run(){
        PrintWriter out = null;   
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket2.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                out.println(inputLine);
            }
        } catch (IOException ex) {
            Logger.getLogger(MiThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialpoo;
import java.io.*;
import java.net.*;

/**
 *
 * @author steph
 */
public class ServerSocket {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try{
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server esperando conexiones...");
        while(true){
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado desde: "
                    + socketCliente.getInetAddress());
            new Thread(new ManejadorClientes(socketCliente)).start();
        }

        
    }
    catch(IOException e){
        System.out.println(e);
    }
}
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientecuadrado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Stephanie Alessandra Vasquez Maravilla 00056024
 * @author Katherine Nicole Martinez Ruiz 00045724
 *  @author Andrea Lissette Marquez Monterrosa 00033924
 */
public class ClienteCuadrado {

    public static void main(String[] args) {
        try{
            //conexion con el servidor
            Socket socket = new Socket("localhost",5000);
            System.out.println("Se ha conectado al server");
            
            //flujos de entrada y de salida
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream,true);
            BufferedReader reader = new BufferedReader(new InputStreamReader
                                                               (inputStream));
            
            //introducir nombre del cliente
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce tu nombre: ");
            String clientName = sc.nextLine();
            writer.println(clientName);
            
            //introducir un numero entero del cliente
            System.out.println("Introduce un numero entero: ");
            String clientNumber = sc.nextLine();
            writer.println(clientNumber);
            
            //mostrar respuesta del servidor
            writer.println("Esto lo envio desde Cliente"); 
            String respuesta = reader.readLine();
            System.out.println("Respuesta del server: " + "Hola, " + clientName + "!");
            System.out.println("Este es tu numero: " + clientNumber + "!");
            
            //cerrar conexion
            socket.close();
            
        }catch(IOException e){
            System.out.println(e);}
        }
}
    


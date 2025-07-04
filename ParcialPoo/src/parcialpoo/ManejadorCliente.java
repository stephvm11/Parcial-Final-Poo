/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialpoo;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

/**
 *
 * @author steph
 */
public class ManejadorCliente implements Runnable{
    private Socket socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    @Override 
    public void run(){
        try{
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader
                                                        (inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            //lee nombre del cliente
            String nombreCliente = reader.readLine();
            int numeroCliente = Integer.parseInt(reader.readLine());
            System.out.println("Nombre del cliente conectado: " + nombreCliente);
            int operacion = (numeroCliente*numeroCliente);
            System.out.println("Numero ingresado al cuadrado: " + operacion);
            LocalDateTime fechaHora = LocalDateTime.now();
            System.out.println("Fecha y hora del proceso: " + fechaHora);
           
            writer.println("Bienvenido, " + nombreCliente + "!");  
            writer.println("El numero ingresado al cuadrado es: " + operacion);
            writer.println(fechaHora);
            socketCliente.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}

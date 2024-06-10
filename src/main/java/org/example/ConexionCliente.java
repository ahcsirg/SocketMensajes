package org.example;

import java.io.IOException;

/**
 * Alexis Santander
 */

//clase que mantiene las conexion con cada uno de los clientes, es la clase que convierte en un hilo

public class ConexionCliente extends Thread{

    private Cliente cliente;
    private Servidor servidor;

    public ConexionCliente(Cliente cliente, Servidor servidor){
        this.cliente = cliente;
        this.servidor = servidor;
    }

    @Override
    public void run(){
        try {


        cliente.salida.println("Buenas, bienvenido a mi servicio de mensajeria");
        while(cliente.estaConectado()){
            String mensaje = cliente.entrada.readLine();
            servidor.enviarMensajeATodos(mensaje);
        }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }


}

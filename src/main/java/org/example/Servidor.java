package org.example;


//clase que mantiene información de conexiones con clientes, clase que mantiene el servicio activo

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    //para recibir conexiones desde otros equipos
    private ServerSocket socket;
    private int puerto;
    private ArrayList<Cliente> clientes;

    public Servidor(int puerto){
        this.puerto = puerto;
        clientes = new ArrayList<Cliente>();
    }

    public void iniciar() throws IOException {
        socket = new ServerSocket(puerto);
    }

    public void detener() throws IOException{
        socket.close();
    }

    public boolean estaConectado() {
        return !socket.isClosed();
    }

    public Socket aceptarConexion() throws IOException {
        return socket.accept();
    }

    public void anadirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void enviarMensajeATodos(String mensaje){
        for (Cliente cliente : clientes){
            cliente.salida.println(mensaje);
        }

    }







}

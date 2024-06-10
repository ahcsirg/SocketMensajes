package org.example;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        Servidor servidor = new Servidor(5555);
        try{
            servidor.iniciar();
        while(servidor.estaConectado()){
            Socket socketCliente = servidor.aceptarConexion();
            Cliente cliente = new Cliente(socketCliente);
            servidor.anadirCliente(cliente);
            ConexionCliente conexionCliente = new ConexionCliente(cliente, servidor);
            conexionCliente.start();
           }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
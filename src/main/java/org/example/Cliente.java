package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Alexis Santander
 */

// clase que representa cada uno de los clientes que se pueden conectar, que información guardar de ellos etc
public class Cliente {

    private Socket socket;
    BufferedReader entrada;
    PrintWriter salida;

    public Cliente(Socket socket) throws IOException{
        this.socket = socket;
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        salida = new PrintWriter(socket.getOutputStream(), true);
    }

    public boolean estaConectado(){
        return !socket.isClosed();
    }

}

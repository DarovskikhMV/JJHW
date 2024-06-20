package HW5;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Server {
    public static final  int SERVER_PORT = 8181;
    public static void main(String[] args) {

        try ( ServerSocket server = new ServerSocket(SERVER_PORT)) {
           try(Socket client =  server.accept()) {
               System.out.println("Подключился новый клиент " + client);



                    try (Scanner in = new Scanner(client.getInputStream());
                         PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                        out.println("Привет от сервера!");


                        while (true) {
                        String msgFromClient = in.nextLine();
                        if (Objects.equals("exit", msgFromClient)) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                        System.out.println("Клиент прислал сообщение: " + msgFromClient);

                        out.println("Получено сообщение: [" + msgFromClient + "]");

                    }
                }
           }
        } catch (IOException e)  {
            System.err.println("Произошла ошибка во время прослушивания порта " + SERVER_PORT + ": " + e.getMessage());
        }


    }
}

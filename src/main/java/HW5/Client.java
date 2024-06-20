package HW5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

import static HW5.Server.SERVER_PORT;

public class Client {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        try (Socket server = new Socket("localhost", SERVER_PORT)) {
            System.out.println("Подключение к серверу успешно");

            try (Scanner in = new Scanner(server.getInputStream());
                 PrintWriter out = new PrintWriter(server.getOutputStream(), true)) {
                String msgFromServer = in.nextLine();
                System.out.println("Сообщение от сервера: " + msgFromServer);

                while (true) {
                    String inputFromConsole = console.nextLine();
                    out.println(inputFromConsole);
                    if(Objects.equals("exit", inputFromConsole)) {
                        break;
                    }

                    msgFromServer = in.nextLine();
                    System.out.println("Сообщение от сервера: " + msgFromServer);

                }

            }

        }catch (IOException e) {
            System.err.println("Произошла ошибка во время TCP-соединения: " + e.getMessage());
        }

    }



}

 
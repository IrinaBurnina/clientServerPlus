import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8089;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server is started");
            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                while (!clientSocket.isClosed()) {
                    out.println("What is ur name?");
                    String userName = in.readLine();
                    Thread.sleep(7000);
                    out.println("Are u child?(yes/no)");
                    String answer = in.readLine();
                    Thread.sleep(7000);
                    if (answer.equalsIgnoreCase("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", userName));
                        Thread.sleep(7000);
                        break;
                    } else if (answer.equalsIgnoreCase("no")) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", userName));
                        Thread.sleep(7000);
                        break;
                    } else {
                        out.println("Please, yes or no");
                    }
                    in.close();
                    out.close();
                    clientSocket.close();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
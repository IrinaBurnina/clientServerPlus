import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8089;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!clientSocket.isClosed()) {
                String questionAboutName = in.readLine();
                System.out.println(questionAboutName);
                String name = reader.readLine();
                out.println(name);
                String questionAboutAdultOrChild = in.readLine();
                System.out.println(questionAboutAdultOrChild);
                String answer = reader.readLine();
                out.println(answer);
                String welcome = in.readLine();
                System.out.println(welcome);
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
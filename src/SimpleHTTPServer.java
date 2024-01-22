import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//http://localhost:8080

// HTTP servers usually listen on port 80, we'll be using port 8080 for this project
public class SimpleHTTPServer {

    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080...");
        //Keeps program running, program will shut down if false
        while (true) {
            //Start accepting connections, blocks until a client connects to the server
            Socket clientSocket = server.accept();
            // 1. Read HTTP request from the client socket
            // 2. Prepare an HTTP response
            // 3. Send HTTP response to the client
            // 4. Close the socket

            //You can read the content of the request using InputStream opened from the client socket
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            //It's better to use BufferedReader because the browser will send multiple lines
            BufferedReader reader = new BufferedReader(isr);

            String line = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
    }

}

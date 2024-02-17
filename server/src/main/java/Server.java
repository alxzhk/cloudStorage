






import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {


            while (true){
                Socket socket = server.accept();

                Handler handler = new Handler(socket);
                new Thread(handler).start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

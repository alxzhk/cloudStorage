import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Handler implements Runnable {
    private  Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        try(DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());)
        {
            while (true){
                String s = is.readUTF();
                os.writeUTF(s);
                os.flush();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

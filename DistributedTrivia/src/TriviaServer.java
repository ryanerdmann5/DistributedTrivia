
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TriviaServer {

	int port_number;
	ServerSocket server_socket;
	Socket client_socket;
	BufferedReader input;
	PrintWriter output;
	
	
	public TriviaServer(int port) throws IOException
	{
			port_number = port;
			server_socket = new ServerSocket(port_number);
			System.out.println(port_number);
			client_socket = server_socket.accept();
			input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			output = new PrintWriter(client_socket.getOutputStream(), true);
	}
	
	
	
	
	void close()
	{
		try
		{
			client_socket.close();
			System.out.print("**Closing Server**");
			server_socket.close();
		}
		catch(Exception e){}
	}
	
	
	
	
	
}

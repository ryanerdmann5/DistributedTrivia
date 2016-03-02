import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TriviaClient 
{
	int port_number;
	InetAddress address;
	Socket client_socket;
	PrintWriter output;
	BufferedReader input;
	String userResponse;
	
	public TriviaClient(int port) throws IOException
	{
		port_number = port;
		client_socket = new Socket(address, port_number);
		output = new PrintWriter(client_socket.getOutputStream(), true);
		input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
	}
	

	void close()
	{
		try
			{ 
			System.out.println("Closing Client");
			client_socket.close();
			}
		catch(Exception e){}
	}
	
}
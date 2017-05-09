import java.io.*;
import java.net.*;
import java.util.zip.CRC32;

// 32 * 5
public class Ipv4Client
{
	public static void main ( String[] args ) throws IOException
	{
		String serverIPaddress;
		String clientIPaddress = "172.217.4.142"; // using one of Google's IP's
		String serverOutput;
		long checkSum;
		byte[] datagram = new byte[20];
		CRC32 errorCode = new CRC32();
		datagram[0] = 0x40;
		datagram[1] = 0x50;
		datagram[2] = 5;
		try 
		{
			/* make a connection */
			Socket socket = new Socket ( "codebank.xyz", 38003 );
			if (socket.isConnected())
				System.out.println("Connected to server.");	
			/* get server's IP Address */
			serverIPaddress = ( socket.getInetAddress() ).getHostAddress();
			
			/* create a IPv4 Packet */
			IPv4 packet = new IPv4();
			packet.setVersion(4); 						// IP version 4
			packet.setHlen(5);							// Header length (# of 32 bit words)
			packet.setLength(4);						// Header + data length
			packet.setFlags(0);							// No fragmentation			
			packet.setTTL(50);							// Time to live
			packet.setProtocol(6);						// TCP assigned number = 6
			packet.setCheckSum();						// Calculated checkSum
			packet.setSourceAddr(clientIPaddress);		// My IP address
			packet.setDestinationAddr(serverIPaddress);	// Server's IP address
			packet.setData("00");						// Random data

			/* OutputStream to send bytes */
			PrintStream PS = new PrintStream (socket.getOutputStream());
			PS.write(datagram, 0, 2);

			/* InputStream to receive response */
			InputStreamReader IR = new InputStreamReader(socket.getInputStream()); // listen to server
			BufferedReader BR = new BufferedReader(IR);
			serverOutput = BR.readLine();
			System.out.println("Server's response: " + serverOutput);

			/* Calculate checksum */
			errorCode.update(datagram);
			checkSum = errorCode.getValue();
		}
		catch ( IOException e )
		{ e.printStackTrace(); }
	}
}
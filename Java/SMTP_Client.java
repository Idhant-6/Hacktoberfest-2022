import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Base64;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Client {
	
	private SSLSocket socket = null;
	private PrintWriter out = null;
	private InputStream in = null;
	
	private boolean connected = false;
	
	public boolean isConnected() {
		return connected;
	}

	public void connect(String host, int port) {
	    try {
	    	SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
	    	socket = (SSLSocket) factory.createSocket(host, port);
	    	
	    	out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
	    	in = socket.getInputStream();
	
	    	readResponse(220, false); // 220 - server ready
	
	    	doRequest("HELO localhost", 250, false);
	    	
	    	connected = true;
	    } catch (UnknownHostException e) {
	    	System.err.println("Unknown host: " + host);
	        cleanExit(1);
	    } catch (IOException e) {
	    	System.out.println(e.getMessage());
			e.printStackTrace();
	        cleanExit(2);
	    }
    }
	
	public boolean login(String username, String password) {
		boolean success = false;
		
    	try {
    		doRequest("AUTH LOGIN", 334, false);
    		
    		//encode username & password and send it to server
        	byte[] usernameEncoded = Base64.getEncoder().encode(username.getBytes());
        	byte[] passwordEncoded = Base64.getEncoder().encode(password.getBytes());
      
			doRequest(new String(usernameEncoded), 334, true);
			success = doRequest(new String(passwordEncoded), 235, true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    	
    	return success;
	}


	public void send(String from, String to, String subject, String message) {
		try {
			doRequest("MAIL FROM:<" + from + ">", 250, false);
			doRequest("RCPT TO:<" + to + ">", 250, false);
			doRequest("DATA", 354, false);

			out.println("From: " + from);
			out.println("Subject: " + subject);
			out.println("To: " + to);
			
			out.println(message);
			doRequest("\r\n.", 250, false);
			
			System.out.println("Email sent successfully!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			cleanExit(2);
		}
	}

	public void closeConnection() {
	    try {
	      doRequest("QUIT", 221, false);
	      
	      connected = false;
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
			e.printStackTrace();
	    }
	    
	    cleanExit(0);
	}

	private boolean doRequest(String req, int checkCode, boolean repeat) throws IOException {
	    out.println(req);
	    //System.out.println("Client: " + req);
	    return readResponse(checkCode, repeat);
	}

	private boolean readResponse(int checkCode, boolean repeat) throws IOException {
		byte[] readBytes = new byte[10000];
	    int num = in.read(readBytes);
	    
	    String response = new String(readBytes, 0, num);
	    //System.out.println("Server: " + response);
	    
	    if (!response.startsWith(String.valueOf(checkCode))) {
	    	if (repeat) {
	    		return false;
	    	} else {
	    		throw new IOException("Unexpected response from the server (code: " + response + ")");
	    	}
	    }
	    
	    return true;
	  }

	private void cleanExit(int code) {
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.exit(code);
	}
}

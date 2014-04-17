package share.g2.miage.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.concurrent.*;

public class pcServeur extends ServerSocket {
	private static final int SERVER_PORT = 2000;

	public pcServeur() throws IOException {
		super(SERVER_PORT);

		try {
			while (true) {
				Socket socket = accept();
				new CreateServerThread(socket);
			}
		} catch (IOException e) {
		} finally {
			close();
		}
	}

	

	public static void main(String[] args) throws IOException {
		new Server();
	}
}

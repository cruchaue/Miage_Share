package share.g2.miage.test;

import java.io.*;
import java.net.*;

//--- CreateServerThread
class CreateServerThread extends Thread {
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;

	public CreateServerThread(Socket s) throws IOException {
		client = s;

		in = new BufferedReader(new InputStreamReader(client.getInputStream(),
				"GB2312"));
		out = new PrintWriter(client.getOutputStream(), true);
		out.println("--- Welcome ---");
		start();
	}

	public void run() {
		try {
			String line = in.readLine();

			while (!client.isClosed()) {
				//String msg = createMessage(line);
				//out.println(msg);
				//line = in.readLine();
			}
			System.out.println("--- See you, bye! ---");
			out.println("--- See you, bye! ---");
			client.close();
		} catch (IOException e) {
		}
	}

	private String createMessage(String line) {
		return "hihihi";
	}
}

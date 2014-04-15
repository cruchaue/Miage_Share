package share.g2.miage.connectionServer;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class ServerTest {


	public static void main(String[] args) throws Exception {
		FonctionShareServer fss = new TCPMethodServer();
		fss.demarrerServer();
		
	}

}

package share.g2.miage.connectionClient;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class clientTest {


	public static void main(String[] args) throws Exception {
		FonctionShareClient fsc = new TCPMethodClient();
		fsc.uploadFichier("test.txt");
		
	}

}

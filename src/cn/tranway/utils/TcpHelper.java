package cn.tranway.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;

public class TcpHelper {
	public Socket connectToServer() {
		try {
			Socket socket = new Socket("192.168.9.63", 54323);
			OutputStream out = socket.getOutputStream();
			out.write("to123\r\n".getBytes());
			InputStream in = socket.getInputStream();
			Reader read = new InputStreamReader(in);
			int i= read.read();
			System.out.println("i:"+i);
			return socket;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
}

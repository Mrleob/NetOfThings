package cn.tranway.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import cn.tranway.utils.TcpHelper;

public class TcpService extends Service{

	private Socket mSocket;
	private TcpHelper mHelper;
	@Override
	public void onCreate(){
		super.onCreate();
		mHelper = new TcpHelper();
		log("onCreate()");
	}
	
	@Override
	public int onStartCommand(Intent intent,int flag,int startId){
		log("onstartCommand()");
		TcpThread thread = new TcpThread();
		thread.start();
		return startId;
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	class TcpThread extends Thread{
		@Override
		public void run(){
			mSocket = mHelper.connectToServer();
			login();
			while(true){
				int i = getMessage();
				if(i== -1){
					break;
				}
				sendHartbeat();
				try {
					new Thread().sleep(5*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/**
	 * tcp登陆
	 */
	public void login(){
		try {
			log("login()");
			OutputStream out = mSocket.getOutputStream();
			out.write("to123\r\n".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送心跳包
	 */
	public void sendHartbeat(){
		try {
			log("sendHartbeat()");
			OutputStream out = mSocket.getOutputStream();
			out.write("to789\r\n".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取消息
	 */
	public int getMessage(){
		try {
			log("getMessage()");
			InputStream input = mSocket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);
 			BufferedReader br = new BufferedReader(reader);
 			String str=br.readLine();
 			Log.e("tcpService-getmessage()","str->"+str);
 			
			Reader read = new InputStreamReader(input);
			int i= read.read();
			Log.e("tcpService-getmessage()","i->"+i);
			return i;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -10;
		}
	}
	
	private void log(String log){
		Log.e("libin","TcpService-->"+log);
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}
}

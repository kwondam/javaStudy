package chatProgram;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;

public class ClientPro extends Application{
	Socket socket;
	void startClient() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress("localhost", 5001));
					Platform.runLater(()-> {
						displayText("[연결 완료: "+socket.getRemoteSocketAddress()+"]");
						btnConn.setText("stop");
						btnSend.setDisplay(false);
					});
				} catch(Exception e){
					Platform.runLater(()->displayText("[서버 통신 안됨]"));
					if(!socket.isClosed()) {stopClient();}
					return;
				}
				receive();
			}
		};
		thread.start();
	}
	void stopClient() {
		try {
			Platform.runLater(()->{
				displayText("[연결 끊음]");
				btnConn.setText("start");
				btnSend.setDisable(true);
			});
			if(socket!=null&& !socket.isClosed()) { socket.close();}
		}catch(IOException e) {}
	}
	
	void receive() {
		while(true) {
			try {
				byte[] byteArr = new byte[100];
				InputStream inputStream = socket.getInputStream();
				int readByteCount = inputStream.read(byteArr);
				
				if(readByteCount ==-1) {throw new IOException();}
				
				String data = new String(byteArr, 0, readByteCount, "UTF-8");
				
				Platform.runLater(()->displayText("[받기완료] "+data));
			} catch(Exception e) {
				Platform.runLater(()->displayText("[서버 통신 안됨]"));
				stopClient();
				break;
			}
		}	
	}
	
	void send(String data) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					byte[] byteArr = data.getBytes("UTF-8");
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(byteArr);
					outputStream.flush();
					Platform.runLater(()->displayText("[보내기 완료]"));
					
				} catch(Exception e) {
					Platform.runLater(()->displayText("[서버 통신 안됨]"));
					stopClient();
				}
			}
		};
		thread.start();
	}
	
	//UI 생성 코드
	
	
	
}
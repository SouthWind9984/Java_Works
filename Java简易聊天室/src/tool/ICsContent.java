package tool;

import java.net.Socket;

public interface ICsContent {

	//发送消息
	public void sendMessage(Socket socket,String msg);
	
	//接收消息
	public String receiveMessage(Socket socket);
}

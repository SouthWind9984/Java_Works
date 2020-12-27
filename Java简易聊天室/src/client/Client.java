package client;

import java.net.Socket;

import tool.ReceiveThread;
import tool.SendThread;

public class Client {

	public static void main(String[] args) throws Exception {
		//创建客户端
		Socket clientSocket = new Socket("127.0.0.1",8888);
		
		//创建接收线程
		ReceiveThread rt = new ReceiveThread(clientSocket);
		rt.start();//启动线程
		//创建发送线程
		SendThread st = new SendThread(clientSocket);
		new Thread(st).start();//启动线程

	}
}

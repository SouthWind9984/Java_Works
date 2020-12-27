package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

//	static ArrayList<String> userList = new ArrayList<String>();
	//使用双列集合存客户端和用户
	static HashMap<Socket,String> socketStringHashMap = new HashMap<Socket,String>();
	public static void main(String[] args) throws Exception {
		//创建SeverSocket
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器启动成功，等待连接...");
		 int count=0;
		//创建监听线程，连接多用户
		while(true) {
			//监听
			Socket socket = server.accept();
//			String name = Login.users.get(count);
			System.out.println("第" + ++count + "个客户端连接成功！！");
			String Name ="用户"+count;
//			userList.add(Name);
			socketStringHashMap.put(socket,Name);
//			sockets.add(socket);
			//启动一个线程，和客户端交互
			MonitorThread mt = new MonitorThread(socket);
			mt.start();
		}
		 //不关闭server，永远监听
	}
	
	
}

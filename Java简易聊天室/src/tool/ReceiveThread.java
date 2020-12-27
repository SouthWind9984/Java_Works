package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{
/*
 * 	接收数据
 */
	Socket socket;

	CsContent csc = new CsContent();
	public ReceiveThread(Socket socket) {
		// TODO 自动生成的构造函数存根
		this.socket=socket;
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		super.run();
//
//		try {
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			while(true) {
//			 // 接收数据
//            String msg="";
//			while((msg=br.readLine())!=null) {
//				System.out.println(msg);
//			}
//		}
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			System.out.println("客户端关闭，暂无消息");
//		}
//		finally {
//			try {
//				//关闭客户端
//				socket.close();
//			} catch (IOException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//		}
		
		
		while(true) {
			csc.receiveMessage(socket);
		}
       
	}    

			
	
}

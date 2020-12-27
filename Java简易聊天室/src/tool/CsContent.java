package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class CsContent implements ICsContent{

	//发送数据
	
	@Override
	public void sendMessage(Socket socket, String msg) {
		// TODO 自动生成的方法存根

		//获取输出流，用来发送数据给服务器
        OutputStream out;
		try {
			out = socket.getOutputStream();
			 PrintStream ps = new PrintStream(out);
			 ps.println(msg);     
		            
	        //5、关闭socket，断开与服务器的连接
//	        socket.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("发送数据错误！");
		}

	}
	
	//接收数据

	@Override
	public String receiveMessage(Socket socket) {
		
		 String msg="";
		 BufferedReader br=null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 // 接收数据
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
				return msg;
			}
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("客户端关闭，暂无消息");
		}
		return "无消息！";
	}
	

}

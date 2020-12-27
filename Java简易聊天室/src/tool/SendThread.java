package tool;

import java.net.Socket;
import java.util.Scanner;

public class SendThread implements Runnable{
	/*
	 * 	发送数据
	 */
	Scanner in = new Scanner(System.in);
	Socket socket ;
CsContent csc = new CsContent();
	
	public SendThread(Socket socket) {
		// TODO 自动生成的构造函数存根
		this.socket=socket;
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
//		// 2、获取输出流，用来发送数据给服务器
//        OutputStream out;
//		try {
//			out = socket.getOutputStream();
//			 PrintStream ps = new PrintStream(out);
//			 while(true){
//		            System.out.println("输入发送的消息：");
//		            String message = in.nextLine();
//		            if(message.equals("stop")){
//		                socket.shutdownOutput();
//		                break;
//		            }
//		         // 4、 发送数据
//		            ps.println(message);
//			 }
//	        //5、关闭socket，断开与服务器的连接
//	        socket.close();
//		} catch (IOException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
       while(true) {
    	 
    	   csc.sendMessage(socket,in.nextLine());
       }
		
	}

}

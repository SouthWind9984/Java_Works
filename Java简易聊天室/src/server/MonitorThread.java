package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MonitorThread extends Thread{

	private Socket socket;
   
    public MonitorThread(Socket socket) {
        super();
        this.socket = socket;
    }
    /**
     * 	服务器同时连接多客户端，可以做到发送和接收
     *  	
     */
    @Override
    public void run(){
    	BufferedReader br = null ;
        try{
        	br = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            String str = null ;
            while((str = br.readLine()) != null) 
            {
                System.out.println(socket.getInetAddress()+"发消息");
                String user =socket.getInetAddress().toString();

            	for(Socket socket1:Server.socketStringHashMap.keySet()){
            	    if(socket1==socket)
            	        user=Server.socketStringHashMap.get(socket1);
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket1.getOutputStream())) ;
                    pw.println(str) ;
                    pw.flush();
                }
//            	for(Socket socket1:Server.sockets) {
//            		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket1.getOutputStream())) ;
//                    pw.println(user+"："+str) ;
//                    pw.flush();
//            	}
            }
        }catch(Exception  e){
            System.out.println("客户端关闭");;
        }
    }
}

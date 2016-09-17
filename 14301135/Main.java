import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws Exception{    //所有异常抛出
		ServerSocket server=null;                               //定义ServerSocket对象
		Socket Client=null;                                     //定义Socket对象，表示客户端
		server =new ServerSocket(3333);                         //此服务器在3333端口上监听
		boolean f=true;                                         //定义一个标记位
		while(f){
			System.out.println("服务器运行，等待客户端连接");    
		    Client=server.accept();                              //接受客户端连接
		    new Thread(new EchoThread(Client)).start();          //实例化并启动一个线程对象
		}
		
		server.close();                                          //关闭服务器端
	}

};

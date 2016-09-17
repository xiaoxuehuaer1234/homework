import java.net.Socket;
import java.io.*;
import java.net.*;


@SuppressWarnings("unused")
public class EchoThread implements Runnable{

	private Socket client=null;
	public EchoThread(Socket client) {
		// TODO Auto-generated constructor stub
		this.client=client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintStream out=null;                            //定义输出流
		BufferedReader buf = null;                       //定义输入流，用来接受客户端发来的信息
		try{
			buf = new BufferedReader(
					new InputStreamReader(
							client.getInputStream()));   //得到客户端的输入流
			out = new PrintStream(
					client.getOutputStream());           //实例化客户端的输出流
			boolean flag=true;                           //标志位，表示一个客户端是否操作完毕
			
			while(flag){
				String str=buf.readLine();               //在此处不断接受信息
				if(str==null||"".equals(str)){           //判断输入信息是否为空
					flag=false;                          //客户端操作结束
				}else{
					int length=str.length();             //得到输入信息长度
					char[] result=new char[length];      //新成立一个数组
					for(int i=0;i<length;i++){             
						result[i]=str.charAt(length-i-1); //逆转
					}
					String string=new String(result);     //转换类型
					out.println(string);                  //打印输出
				}
			}
			out.close();                                  //关闭输出流
			client.close();                               //关闭客户端
		}catch(Exception exception){
			
		}
		
		
	}

}

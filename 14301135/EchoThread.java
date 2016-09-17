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
		PrintStream out=null;                            //���������
		BufferedReader buf = null;                       //�������������������ܿͻ��˷�������Ϣ
		try{
			buf = new BufferedReader(
					new InputStreamReader(
							client.getInputStream()));   //�õ��ͻ��˵�������
			out = new PrintStream(
					client.getOutputStream());           //ʵ�����ͻ��˵������
			boolean flag=true;                           //��־λ����ʾһ���ͻ����Ƿ�������
			
			while(flag){
				String str=buf.readLine();               //�ڴ˴����Ͻ�����Ϣ
				if(str==null||"".equals(str)){           //�ж�������Ϣ�Ƿ�Ϊ��
					flag=false;                          //�ͻ��˲�������
				}else{
					int length=str.length();             //�õ�������Ϣ����
					char[] result=new char[length];      //�³���һ������
					for(int i=0;i<length;i++){             
						result[i]=str.charAt(length-i-1); //��ת
					}
					String string=new String(result);     //ת������
					out.println(string);                  //��ӡ���
				}
			}
			out.close();                                  //�ر������
			client.close();                               //�رտͻ���
		}catch(Exception exception){
			
		}
		
		
	}

}

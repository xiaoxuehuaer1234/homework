import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) throws Exception{    //�����쳣�׳�
		ServerSocket server=null;                               //����ServerSocket����
		Socket Client=null;                                     //����Socket���󣬱�ʾ�ͻ���
		server =new ServerSocket(3333);                         //�˷�������3333�˿��ϼ���
		boolean f=true;                                         //����һ�����λ
		while(f){
			System.out.println("���������У��ȴ��ͻ�������");    
		    Client=server.accept();                              //���ܿͻ�������
		    new Thread(new EchoThread(Client)).start();          //ʵ����������һ���̶߳���
		}
		
		server.close();                                          //�رշ�������
	}

};

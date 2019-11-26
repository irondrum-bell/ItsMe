package com.its.me.socket;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocket extends Thread {

//	private final String SAVE_PATH = "C:\\upload";
	private final String SAVE_PATH = "/home/rets/vixme/uploads";
	private Socket clientSocket = null;
	private String num = "";
	private String fileName = "";
	
	public ClientSocket(String num, String fileName) {
		try {
			this.num = "";
			this.num = num;
			this.fileName = fileName;
			clientSocket = new Socket("220.69.241.175", 11001);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			OutputStream os = clientSocket.getOutputStream();
            FileInputStream fin = new FileInputStream(SAVE_PATH + "/" + num + "/" + fileName);
//			DataOutputStream dos = new DataOutputStream(os);
			// 원격 소켓(remote socket)에 데이터를 보낸다.
            num = num.replace("\n", "");
            num = num.replace(" ", "");
			os.write(num.getBytes());
//			os.flush();
//			dos.writeChars(num);
			System.out.println("message send : " + num);
			
			// 이미지 학습서버로 전송
            byte[] buf = new byte[1024];
            int read = 0;
            while((read=fin.read(buf, 0, buf.length))!=-1) {
                os.write(buf, 0, read);
                
//                System.out.println("파일 전송----------------------------------------");
            }

			// 스트림과 소켓을 달아준다.
            fin.close();
//			dos.close();
            
            // 모델 파일 수신부(주석해제하면 이미지 전송도 오류발생)
//			InputStream is = clientSocket.getInputStream();
//			FileOutputStream fou = new FileOutputStream("C:\\model\\model.clf");
//			while ((read=is.read(buf))!=-1) {
//				fou.write(buf, 0, read);
//	        }
//			fou.flush();
			
//            fin.close();
//			fou.close();
            os.close();
//			is.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

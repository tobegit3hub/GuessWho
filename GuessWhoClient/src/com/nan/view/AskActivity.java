package com.nan.view;

import java.io.OutputStream;
import java.io.StringReader;
import java.net.Socket;
import com.nan.socket.ClientThread;
import com.nan.socket.StaticSocket;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AskActivity extends Activity {
	// ��������ϵ������ı���
	EditText input, show;
	// ��������ϵ�һ����ť
	Button send;

	Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ask);
		input = (EditText) findViewById(R.id.input);
		send = (Button) findViewById(R.id.send);
		show = (EditText) findViewById(R.id.show);

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// �����Ϣ���������߳�
				if (msg.what == 0x123) {
					// ����ȡ������׷����ʾ���ı�����
					show.append("\n" + msg.obj.toString());
				}
			}
		};
		
//		try {
//			StaticSocket.socket = new Socket("110.64.91.18", 30000);
			StaticSocket.clientThread.setHandler(handler);
//			// �ͻ�������ClientThread�̲߳��϶�ȡ���Է�����������
//			new Thread(new ClientThread(StaticSocket.socket, StaticSocket.handler)).start(); // ��
//			StaticSocket.os = StaticSocket.socket.getOutputStream();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		send.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// ���û����ı��������������д������
					// os.write((input.getText().toString() + "\r\n")
					// .getBytes("utf-8"));
					StaticSocket.os.write(("{\"method\":\"login\", \"paramOne\":\"wth\", \"paramTwo\":\"hell\", \"userId\":2, \"gameId\":20}"
							+ "\r\n").getBytes("utf-8"));

					// ���input�ı���
					input.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
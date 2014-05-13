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

public class AnswerActivity extends Activity {
	// 定义界面上的两个文本框
	EditText show;
	// 定义界面上的一个按钮
	Button yesButton;
	Button unknownButton;
	Button noButton;

	Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.answer);

		yesButton = (Button) findViewById(R.id.yesId);
		unknownButton = (Button) findViewById(R.id.unknownId);
		noButton = (Button) findViewById(R.id.noId);
		show = (EditText) findViewById(R.id.show);

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// 如果消息来自于子线程
				if (msg.what == 0x123) {
					// 将读取的内容追加显示在文本框中
					show.append("\n" + msg.obj.toString());
				}
			}
		};
		
//		try {
//			StaticSocket.socket = new Socket("110.64.91.18", 30000);
			StaticSocket.clientThread.setHandler(handler);
//			// 客户端启动ClientThread线程不断读取来自服务器的数据
//			new Thread(new ClientThread(StaticSocket.socket, StaticSocket.handler)).start(); // ①
//			StaticSocket.os = StaticSocket.socket.getOutputStream();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		yesButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// 将用户在文本框内输入的内容写入网络
					// os.write((input.getText().toString() + "\r\n")
					// .getBytes("utf-8"));
					StaticSocket.os.write(("{\"method\":\"login\", \"paramOne\":\"wth\", \"paramTwo\":\"hell\", \"userId\":2, \"gameId\":20}"
							+ "\r\n").getBytes("utf-8"));

					// 清空input文本框
					//input.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		unknownButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// 将用户在文本框内输入的内容写入网络
					// os.write((input.getText().toString() + "\r\n")
					// .getBytes("utf-8"));
					StaticSocket.os.write(("{\"method\":\"login\", \"paramOne\":\"wth\", \"paramTwo\":\"hell\", \"userId\":2, \"gameId\":20}"
							+ "\r\n").getBytes("utf-8"));

					// 清空input文本框
					//input.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		noButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// 将用户在文本框内输入的内容写入网络
					// os.write((input.getText().toString() + "\r\n")
					// .getBytes("utf-8"));
					StaticSocket.os.write(("{\"method\":\"login\", \"paramOne\":\"wth\", \"paramTwo\":\"hell\", \"userId\":2, \"gameId\":20}"
							+ "\r\n").getBytes("utf-8"));

					// 清空input文本框
					//input.setText("");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
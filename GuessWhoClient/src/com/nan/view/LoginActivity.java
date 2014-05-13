package com.nan.view;

import java.io.OutputStream;
import java.net.Socket;

import com.nan.socket.ClientThread;
import com.nan.socket.StaticSocket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	EditText nameText;
	EditText passwordText;
	Button signUpButton;
	Button signInButton;
	Button exitButton;

	Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		nameText = (EditText)findViewById(R.id.nameId);
		passwordText = (EditText)findViewById(R.id.passwordId);
		signUpButton = (Button)findViewById(R.id.signUpId);
		signInButton = (Button)findViewById(R.id.signInId);
		exitButton = (Button)findViewById(R.id.exitId);
		
		
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				// 如果消息来自于子线程
				if (msg.what == 0x123) {
					// 将读取的内容追加显示在文本框中
					passwordText.append("\n" + msg.obj.toString());
				}
			}
		};
		
		try {
			StaticSocket.socket = new Socket("110.64.91.18", 30000);
			StaticSocket.handler = handler;
			// 客户端启动ClientThread线程不断读取来自服务器的数据
			StaticSocket.run();
			StaticSocket.os = StaticSocket.socket.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

		
		
		
		signUpButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// 将用户在文本框内输入的内容写入网络
					// os.write((input.getText().toString() + "\r\n")
					// .getBytes("utf-8"));
					StaticSocket.os.write(("{\"method\":\"login\", \"paramOne\":\"wth\", \"paramTwo\":\"hell\", \"userId\":2, \"gameId\":20}"
							+ "\r\n").getBytes("utf-8"));

					// 清空input文本框
					nameText.setText("");
					
					Intent intent = new Intent();
					intent.setClass(LoginActivity.this, HallActivity.class);
					LoginActivity.this.startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		signInButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// 将用户在文本框内输入的内容写入网络
					// os.write((input.getText().toString() + "\r\n")
					// .getBytes("utf-8"));
					StaticSocket.os.write(("{\"method\":\"login\", \"paramOne\":\"wth\", \"paramTwo\":\"hell\", \"userId\":2, \"gameId\":20}"
							+ "\r\n").getBytes("utf-8"));

					// 清空input文本框
					nameText.setText("");
					
					Intent intent = new Intent();
					intent.setClass(LoginActivity.this, HallActivity.class);
					LoginActivity.this.startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		exitButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.exit(0);
			}
		});
		
		
	}
}
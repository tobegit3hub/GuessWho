package com.nan.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HallActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button answerButton;
	private Button oneButton;
	private Button twoButton;
	private Button threeButton;
	private Button exitButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall);
        
        answerButton = (Button)findViewById(R.id.answerId);
        oneButton = (Button)findViewById(R.id.oneId);
        twoButton = (Button)findViewById(R.id.twoId);
        threeButton = (Button)findViewById(R.id.threeId);
        exitButton = (Button)findViewById(R.id.exitId);
        
        answerButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HallActivity.this, AnswerActivity.class);
				HallActivity.this.startActivity(intent);
			}      	
        });
        
        oneButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HallActivity.this, AskActivity.class);
				HallActivity.this.startActivity(intent);
			}      	
        });
        
        twoButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HallActivity.this, AskActivity.class);
				HallActivity.this.startActivity(intent);
			}      	
        });
        
        threeButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(HallActivity.this, AskActivity.class);
				HallActivity.this.startActivity(intent);
			}      	
        });
        
        
        exitButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}      	
        });
    }
}
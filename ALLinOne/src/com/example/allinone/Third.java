package com.example.allinone;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Third extends Activity {
Button time;
ImageView iv;
Button r,t,s,a;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		s=(Button)findViewById(R.id.button4);
		a=(Button)findViewById(R.id.button3);
		t=(Button)findViewById(R.id.button2);
		r=(Button)findViewById(R.id.button1);
		time=(Button)findViewById(R.id.time);
		iv=(ImageView)findViewById(R.id.imageView1);
	Bundle b;
	b=getIntent().getExtras();
	Log.e("intent pachi" ,"pass");
	
	String n=b.getString("name").toString();
	String m=b.getString("mail").toString();
	String g=b.getString("gender").toString();
	String d=b.getString("date").toString();
	String t=b.getString("time").toString();
	String s=b.getString("stream").toString();
	String l=b.getString("lang").toString();
	
	time.setText("Name : " + n + " \n Gen : " + g+ " \n Mail : " + m + " \n Date : " +  d + " \n Time : " + t + " \n Stream : " + s + " \n Language : " + l + " \n ") ;
	
	
	}
	public void rotate(View v){
		Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.r);
		iv.startAnimation(anim);
	}
	public void translate(View v){
		Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.t);
		iv.startAnimation(anim);
	}
	public void alpha(View v){
		Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.a);
		iv.startAnimation(anim);
	}
	public void scale(View v){
		Animation anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.s);
		iv.startAnimation(anim);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_third, menu);
		return true;
	}

}

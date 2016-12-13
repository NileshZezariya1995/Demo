package com.example.allinone;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class Second extends Activity {
Button sbmt,clear;
EditText name,mail;
DatePicker dp;
TimePicker tp;
Spinner sp;
RadioGroup rg;
RadioButton m,f;
CheckBox g,h,e;
String nm,ml,dt,tt,str,gen,lang,tm;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		sbmt=(Button)findViewById(R.id.submit);
		clear=(Button)findViewById(R.id.Clear);
		name=(EditText)findViewById(R.id.name);
		mail=(EditText)findViewById(R.id.mail);
		dp=(DatePicker)findViewById(R.id.dp);
		tp=(TimePicker)findViewById(R.id.tp);
		sp=(Spinner)findViewById(R.id.Stream);
		rg=(RadioGroup)findViewById(R.id.rg);
		g=(CheckBox)findViewById(R.id.g);
		h=(CheckBox)findViewById(R.id.h);
		e=(CheckBox)findViewById(R.id.e);
		
		sbmt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			nm=name.getText().toString();
			ml=mail.getText().toString();
			dt=dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear();
			tp.setIs24HourView(false);
			tt=getTime();
			tp.setOnTimeChangedListener(new OnTimeChangedListener() {
				
				@Override
				public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
					// TODO Auto-generated method stub
						tt=getTime();
						Toast.makeText(getApplicationContext(), ""+tt, 50).show();
				}	
				
			});
			
			
			
			int id=rg.getCheckedRadioButtonId();
			if(id == R.id.m)
				gen="Male";
			else
				gen="Female";
			Toast.makeText(getApplicationContext(), "Gen : " + gen, 50).show();
			str=sp.getSelectedItem().toString();
			
			if(g.isChecked() && h.isChecked() && e.isChecked()){
				lang=g.getText()+","+h.getText()+","+e.getText();	
			}else if(  h.isChecked() && e.isChecked())
				{
				lang=h.getText()+","+e.getText();	
				}
			else if(g.isChecked() &&  h.isChecked() ){
				lang=g.getText()+","+h.getText();	
			
			}
			else if(g.isChecked() &&  e.isChecked() ){
				lang=g.getText()+","+e.getText();	
			
			}	
			else if(g.isChecked() ){
				lang=g.getText().toString();	
			}	
			else if(e.isChecked() ){
				lang=e.getText().toString();	
			}else if(h.isChecked() ){
				lang=h.getText().toString();	
			}		
			else{
				lang="Un Educated";
			}
			Log.e("intent pahela" ,"pass");
			Intent i=new Intent(getApplicationContext(),Third.class);
			i.putExtra("name", nm);
			i.putExtra("mail", ml);
			
			i.putExtra("date", dt);
			i.putExtra("time", tt);
			i.putExtra("gender",gen);
			
			i.putExtra("stream",str);
			i.putExtra("lang",lang);
			startActivity(i);
			
			
		}
		public String getTime(){
			tm=tp.getCurrentHour()+":"+tp.getCurrentMinute();
			return tm;
		}
			
			
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second, menu);
		return true;
	}

}

package com.example.a318;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	ArrayList<Client> clients;
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 1) {
			Client client = (Client) data.getSerializableExtra("client");
			Toast t =
					Toast.makeText(this.getApplicationContext(),
							"got client:" + client,
							Toast.LENGTH_LONG);
			t.show();
			this.clients.add(client);
			t =
					Toast.makeText(this.getApplicationContext(),
							"our clients:" + this.clients,
							Toast.LENGTH_LONG);
			t.show();
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		Button add = (Button) this.findViewById(R.id.buttonAdd);
		Button show = (Button) this.findViewById(R.id.buttonShow);
		SharedPreferences sp = this.getSharedPreferences("myprefs", MODE_PRIVATE);
		if (sp.contains("isCreated")) {
			this.clients = new ArrayList<>();
			try {
				FileInputStream fis = this.openFileInput("array.ser");
				ObjectInputStream dis = new ObjectInputStream(fis);
				while (dis.read() != -1) {
					
					this.clients.add((Client) dis.readObject());
					
				}
				dis.close();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		} else {
			this.clients = new ArrayList<>();
		}
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddActivity.class);
				MainActivity.this.startActivityForResult(intent, 1);
			}
		});
		
		show.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ShowActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		try {
			this.getSharedPreferences("myprefs", MODE_PRIVATE)
					.edit()
					.putInt("isCreated", 0)
					.commit();
			FileOutputStream fos = this.openFileOutput("array.ser", MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Client c : this.clients) {
				oos.writeObject(c);
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

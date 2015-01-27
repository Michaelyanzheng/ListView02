package com.zheng;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView lv = null;
	private ArrayAdapter<User> adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new ArrayAdapter<User>(this,android.R.layout.simple_list_item_1);
	//	adapter = new ArrayAdapter<String>(this,R.layout.list_cell);

		lv = (ListView) findViewById(R.id.listView);
		lv.setAdapter(adapter);
		
		adapter.add(new User("zheng", "man", 24));
		adapter.add(new User("li","女",21));
		
		lv.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		User user = adapter.getItem(position);
		Toast.makeText(this, String.format("userName is %s， sex is %s，age is %d", user.getUserName(),
				user.getSex(),user.getAge()), Toast.LENGTH_SHORT).show();
	}



}

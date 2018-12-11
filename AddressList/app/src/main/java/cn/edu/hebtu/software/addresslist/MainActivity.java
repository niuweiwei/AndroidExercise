package cn.edu.hebtu.software.addresslist;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btn_add;
    private ContentResolver contentResolver;
    private String []  names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();

        //为按钮绑定添加联系人页面
        btn_add = findViewById(R.id.btn_insert);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddContactsActivity.class);
                startActivity(intent);
            }
        });

        //获取数据库中所有联系人
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,
                null,null,null);
        names = new String [cursor.getCount()];
        int i=0;
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("display_name"));
                names [i] = name;
                i++;
            }while(cursor.moveToNext());
        }

        //创建Adapter并绑定
        ListView listView = findViewById(R.id.lv_container);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,names);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ContactsDetailsActivity.class);
                intent.putExtra("name",names[position]);
                startActivity(intent);
            }
        });

    }
}

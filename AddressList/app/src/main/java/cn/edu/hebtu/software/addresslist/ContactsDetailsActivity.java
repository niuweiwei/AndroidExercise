package cn.edu.hebtu.software.addresslist;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactsDetailsActivity extends AppCompatActivity {

    private ContentResolver contentResolver;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_return;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        contentResolver = getContentResolver();
        findViews();
        name = getIntent().getStringExtra("name");
        etName.setText(name);
        queryDetails();
        btn_update.setOnClickListener(new ButtonOnclickListener());
        btn_delete.setOnClickListener(new ButtonOnclickListener());
        btn_return.setOnClickListener(new ButtonOnclickListener());
    }

    //获取布局中的控件
    private void findViews(){
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        btn_return = findViewById(R.id.btn_return);
    }

    //内部类 按钮点击监听器
    private class ButtonOnclickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_update:
                    update();
                    break;
                case R.id.btn_delete:
                    delete();
                    break;
                case R.id.btn_return:
                    Intent intent = new Intent(ContactsDetailsActivity.this,MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    //通过数据库查询出联系人详细信息
    private void queryDetails(){
        //查询联系人电话
        Cursor cursorPhone = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,"display_name=? and mimetype=?",
                new String[] {name,"vnd.android.cursor.item/phone_v2"},null);
        if(cursorPhone.moveToFirst()){
            //data1 是电话所在的列
            String phone = cursorPhone.getString(cursorPhone.getColumnIndex("data1"));
            etPhone.setText(phone);
        }

        //查询联系人邮件
        Cursor cursorMail = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                null,"display_name=? and mimetype=?",
                new String[]{name,"vnd.android.cursor.item/email_v2"},null);
        if(cursorMail.moveToFirst()){
            String mail = cursorMail.getString(cursorMail.getColumnIndex("data1"));
            etEmail.setText(mail);
        }
    }

    // 对联系人进行修改 根据id
    private void update(){
        //查询到该联系人所对应的id
        Cursor cursor  = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI,null,
                "display_name=?",new String[]{name},null);
        String id = null;
        if (cursor.moveToFirst()){
            id = cursor.getString(cursor.getColumnIndex("_id"));
        }
        //根据id值对联系人的姓名进行更改
        ContentValues contentName = new ContentValues();
        contentName.put("display_name",etName.getText().toString());
        contentResolver.update(ContactsContract.RawContacts.CONTENT_URI,contentName,
                "_id=? ",new String[]{id});

        //根据id值对联系人的电话号码进行更改
        ContentValues contentPhone = new ContentValues();
        contentPhone.put("data1",etPhone.getText().toString());
        contentResolver.update(ContactsContract.Data.CONTENT_URI,
                contentPhone,"raw_contact_id=? and mimetype=?",
                new String[]{id,"vnd.android.cursor.item/phone_v2"});

        //根据id值对联系人的邮箱进行更改
        ContentValues contentEmail = new ContentValues();
        contentEmail.put("data1",etEmail.getText().toString());
        contentResolver.update(ContactsContract.Data.CONTENT_URI,
                contentEmail,"raw_contact_id=? and mimetype=?",
                new String[]{id,"vnd.android.cursor.item/email_v2"});
    }

    //根据联系人姓名删除该联系人
    private void delete(){
        contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI,
                "display_name=?",new String[]{name});
    }
}

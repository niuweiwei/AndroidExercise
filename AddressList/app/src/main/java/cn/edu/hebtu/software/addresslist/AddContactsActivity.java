package cn.edu.hebtu.software.addresslist;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactsActivity extends AppCompatActivity {

    private Button btnConfirm;
    private Button btnCancel;
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        findViews();
        btnConfirm.setOnClickListener(new ButtonClickListener());
        btnCancel.setOnClickListener(new ButtonClickListener());
    }

    private void findViews(){
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnCancel = findViewById(R.id.btn_cancel);
    }

    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_confirm:
                    insert();
                    break;
                case R.id.btn_cancel:
                    break;
            }
            Intent intent = new Intent(AddContactsActivity.this,
                    MainActivity.class);
            startActivity(intent);
        }

        //添加联系人
        private void insert(){
            contentResolver = getContentResolver();
            //在rawContacts表中插入display_name 得到uri对象
            ContentValues contentValues = new ContentValues();
            contentValues.put("display_name",etName.getText().toString());
            Uri uri = contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI,contentValues);
            //通过uri对象得到id
            long id = ContentUris.parseId(uri);
            contentValues.clear();
            //通过得到id 指定mimetype 在data表中插入姓名 电话和邮箱
            contentValues.put("data1",etName.getText().toString());
            contentValues.put("mimetype","vnd.android.cursor.item/name");
            contentValues.put("raw_contact_id",id);
            contentResolver.insert(ContactsContract.Data.CONTENT_URI,contentValues);
            contentValues.clear();

            //在插入电话时 要指明data2列的值为2 因为一个联系人可以有多个电话
            contentValues.put("data1",etPhone.getText().toString());
            contentValues.put("mimetype","vnd.android.cursor.item/phone_v2");
            contentValues.put("raw_contact_id",id);
            contentValues.put("data2",2);
            contentResolver.insert(ContactsContract.Data.CONTENT_URI,contentValues);
            contentValues.clear();

            contentValues.put("data1",etEmail.getText().toString());
            contentValues.put("mimetype","vnd.android.cursor.item/email_v2");
            contentValues.put("raw_contact_id",id);
            contentResolver.insert(ContactsContract.Data.CONTENT_URI,contentValues);
        }
    }
}

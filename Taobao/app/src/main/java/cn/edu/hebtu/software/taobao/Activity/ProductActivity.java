package cn.edu.hebtu.software.taobao.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.taobao.Bean.Good;
import cn.edu.hebtu.software.taobao.R;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        //对原价进行删除线的设置
        TextView tv=findViewById(R.id.price);
         tv.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
         //接收intent
        Intent intent=getIntent();
        Good good=(Good)intent.getSerializableExtra("product");
        //对相应的控件进行设置
        ImageView iv=findViewById(R.id.product_img);
        iv.setImageResource(good.getImageId());
        TextView price=findViewById(R.id.product_price);
        price.setText(good.getPrice());
        TextView name=findViewById(R.id.product_name);
        name.setText(good.getProduct());
        TextView sell=findViewById(R.id.product_sell);
        sell.setText(good.getSell());
        TextView city=findViewById(R.id.product_city);
        city.setText(good.getCity());
        TextView customer=findViewById(R.id.customer);
        customer.setText(good.getUser());
        TextView comment=findViewById(R.id.comment);
        comment.setText(good.getComment());
    }
}

package cn.edu.hebtu.software.taobao.Activity;


import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import cn.edu.hebtu.software.taobao.R;
import cn.edu.hebtu.software.taobao.fragment.IndexFragment;
import cn.edu.hebtu.software.taobao.fragment.ListFragment;
import cn.edu.hebtu.software.taobao.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {
    //为了将选项卡的tag和选项卡绑定在一起
    private Map<String,View> tabspecMap=new HashMap<>();
    //当选中某个选项时 该选项的图片会发生改变
    private Map<String,ImageView>imageMap=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost=findViewById(android.R.id.tabhost);
        //用setup方法对FragmentTabHost进行初始化
        fragmentTabHost.setup(this,getSupportFragmentManager(),android.R.id.tabhost);
        //创建选项卡对象
        TabHost.TabSpec tabSpec1=fragmentTabHost.newTabSpec("tag1")
                .setIndicator(getTabSpecView("首页",R.drawable.index,"tag1"));
        //添加选项卡
        fragmentTabHost.addTab(tabSpec1, IndexFragment.class,null);

        TabHost.TabSpec tabSpec2=fragmentTabHost.newTabSpec("tag2")
                .setIndicator(getTabSpecView("商品",R.drawable.list,"tag2"));
        fragmentTabHost.addTab(tabSpec2, ListFragment.class,null);
        TabHost.TabSpec tabSpec3=fragmentTabHost.newTabSpec("tag3")
                .setIndicator(getTabSpecView("我的",R.drawable.login,"tag3"));
        fragmentTabHost.addTab(tabSpec3, MyFragment.class,null);
        //默认选中主页
        fragmentTabHost.setCurrentTab(0);
        //改变主页的样式 使得主页为选中状态 通过Map中的key (tag1) 找到对应的imageView
        final ImageView imageView=imageMap.get("tag1");
        imageView.setImageResource(R.drawable.index2);
        //为选项卡添加点击事件
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                if(tabId.equals("tag1")){
                    ImageView imageView1=imageMap.get("tag1");
                    imageView1.setImageResource(R.drawable.index2);
                    ImageView imageView2=imageMap.get("tag2");
                    imageView2.setImageResource(R.drawable.list);
                    ImageView imageView3=imageMap.get("tag3");
                    imageView3.setImageResource(R.drawable.login);
                }else if(tabId.equals("tag2")){
                    ImageView imageView1=imageMap.get("tag1");
                    imageView1.setImageResource(R.drawable.index);
                    ImageView imageView2=imageMap.get("tag2");
                    imageView2.setImageResource(R.drawable.list2);
                    ImageView imageView3=imageMap.get("tag3");
                    imageView3.setImageResource(R.drawable.login);
                }else if(tabId.equals("tag3")){
                    ImageView imageView1=imageMap.get("tag1");
                    imageView1.setImageResource(R.drawable.index);
                    ImageView imageView2=imageMap.get("tag2");
                    imageView2.setImageResource(R.drawable.list);
                    ImageView imageView3=imageMap.get("tag3");
                    imageView3.setImageResource(R.drawable.login2);
                }
            }
        });
    }
    private View getTabSpecView(String text,int imgId,String specTag){
        LayoutInflater layoutInflater=getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.tabspec_layout,null);
        ImageView imageView=view.findViewById(R.id.image);
        imageView.setImageResource(imgId);
        TextView textView=view.findViewById(R.id.text);
        textView.setText(text);
        tabspecMap.put(specTag,view);
        imageMap.put(specTag,imageView);
        return view;
    }
}

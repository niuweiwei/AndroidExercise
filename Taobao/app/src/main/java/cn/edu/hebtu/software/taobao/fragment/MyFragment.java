package cn.edu.hebtu.software.taobao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.hebtu.software.taobao.Activity.LoginActivity;
import cn.edu.hebtu.software.taobao.Activity.MainActivity;
import cn.edu.hebtu.software.taobao.Adapter.MyGridCustomerAdapterI;
import cn.edu.hebtu.software.taobao.Adapter.MyGridCustomerAdapterII;
import cn.edu.hebtu.software.taobao.Adapter.MyGridCustomerAdapterIII;
import cn.edu.hebtu.software.taobao.Bean.BuyButton;
import cn.edu.hebtu.software.taobao.Bean.Info;
import cn.edu.hebtu.software.taobao.Bean.Tool;
import cn.edu.hebtu.software.taobao.Bean.User;
import cn.edu.hebtu.software.taobao.GridViewForScrollView;
import cn.edu.hebtu.software.taobao.R;

public class MyFragment extends Fragment {
    private  List<User> users=new ArrayList<>();
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       //整体的页面布局
        if(rootView==null) {
                rootView = inflater.inflate(R.layout.my_layout, container, false);
                Info info1 = new Info("329", "收藏夹");
                Info info2 = new Info("299", "关注店铺");
                Info info3 = new Info("623", "足迹");
                Info info4 = new Info("9", "卡券");
                List<Info> userInfo = new ArrayList<>();
                userInfo.add(info1);
                userInfo.add(info2);
                userInfo.add(info3);
                userInfo.add(info4);
                MyGridCustomerAdapterI myGridCustomerAdapterI = new MyGridCustomerAdapterI(userInfo, getActivity(), R.layout.my_griditem1);
                GridView gridView = rootView.findViewById(R.id.user);
                gridView.setAdapter(myGridCustomerAdapterI);
                BuyButton buyButton1 = new BuyButton(R.drawable.money1, "待付款");
                BuyButton buyButton2 = new BuyButton(R.drawable.money2, "待发货");
                BuyButton buyButton3 = new BuyButton(R.drawable.money3, "待收货");
                BuyButton buyButton4 = new BuyButton(R.drawable.money4, "评价");
                BuyButton buyButton5 = new BuyButton(R.drawable.money5, "退款/售后");
                List<BuyButton> buyButtons = new ArrayList<>();
                buyButtons.add(buyButton1);
                buyButtons.add(buyButton2);
                buyButtons.add(buyButton3);
                buyButtons.add(buyButton4);
                buyButtons.add(buyButton5);
                MyGridCustomerAdapterII myGridCustomerAdapterII = new MyGridCustomerAdapterII(buyButtons, getActivity(), R.layout.my_griditem2);
                GridViewForScrollView gridView1 = (GridViewForScrollView) rootView.findViewById(R.id.order);
                gridView1.setAdapter(myGridCustomerAdapterII);
                Tool tool1 = new Tool(R.drawable.button1, "野生小伙伴");
                Tool tool2 = new Tool(R.drawable.button2, "领券中心");
                Tool tool3 = new Tool(R.drawable.button3, "闲置换钱");
                Tool tool4 = new Tool(R.drawable.button4, "客服小蜜");
                Tool tool5 = new Tool(R.drawable.button5, "花呗");
                Tool tool6 = new Tool(R.drawable.button6, "阿里宝卡");
                Tool tool7 = new Tool(R.drawable.button7, "我的评价");
                Tool tool8 = new Tool(R.drawable.button8, "主题换肤");
                List<Tool> tools = new ArrayList<>();
                tools.add(tool1);
                tools.add(tool2);
                tools.add(tool3);
                tools.add(tool4);
                tools.add(tool5);
                tools.add(tool6);
                tools.add(tool7);
                tools.add(tool8);
                MyGridCustomerAdapterIII myGridCustomerAdapterIII = new MyGridCustomerAdapterIII(tools, getActivity(), R.layout.my_griditem2);
                GridViewForScrollView gridView2 = (GridViewForScrollView) rootView.findViewById(R.id.tools);
                gridView2.setAdapter(myGridCustomerAdapterIII);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        User user1=new User(R.drawable.niuweiwei,"niuweiwei");
        User user2=new User(R.drawable.mengfeifei,"mengfeifei");
        User user3=new User(R.drawable.sunliying,"sunliying");
        User user4=new User(R.drawable.wangzhao,"wangzhao");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    //实现页面跳转
        TextView gotoLog=rootView.findViewById(R.id.gotoLog);
        gotoLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), LoginActivity.class);
                startActivityForResult(intent,1);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1&&resultCode==200){
            String name=data.getStringExtra("userName");
            TextView textView=getActivity().findViewById(R.id.gotoLog);
            textView.setText(name);
            ImageView imageView=getActivity().findViewById(R.id.iv_user);
            int i=0;
            for(;i<users.size();i++){
               User user=(User)users.get(i);
                if(name.equals(user.getUserName())){
                    imageView.setImageResource(user.getPortraitId());
                    break;
                }
            }
            if(i==users.size()){
                imageView.setImageResource(R.drawable.portrait);
            }
        }
    }
}

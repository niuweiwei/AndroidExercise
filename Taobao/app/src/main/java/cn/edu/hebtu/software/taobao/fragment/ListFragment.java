package cn.edu.hebtu.software.taobao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.taobao.Activity.ProductActivity;
import cn.edu.hebtu.software.taobao.Adapter.ListCustomAdapter;
import cn.edu.hebtu.software.taobao.Bean.Good;
import cn.edu.hebtu.software.taobao.R;

public class ListFragment extends Fragment {
    List<Good> goods =new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.list_layout,container,false);
        Good good1=new Good(R.drawable.good1,"Apple/苹果 iPhoneX","7000元",
                "北京","1327","s**t","很好用，拍照效果很清晰，信赖苏宁易购，优惠多质量好");
        Good good2=new Good(R.drawable.good2,
                "【抢12期免息券 最快当天送达】Apple/苹果 iPhone Xs","9599元",
                "广东深圳","7785","n**w","原装全新的IphoneXS手机，感觉不错，还送了充电器和数据线");
        Good good3=new Good(R.drawable.good3,
                "【稀缺货源】 Apple/苹果 iPhone 8 Plus 64G","5588元",
                "南京","4413","该**3","屏幕色彩清晰都很好，是正品手机。运行速度分快，拍照效果好");
        Good good4=new Good(R.drawable.good4,
                "分期免息Apple/苹果 iPhone 8 Plus","3980元","杭州",
                "3273","h**3","五星好评。手机用了半个月没有什么问题，打游戏速度很快");
        Good good5=new Good(R.drawable.good5,
                "【3期免息 送壳膜 享6折 保值回购】Apple/苹果 iPhone XS","8699元",
                "上海","2403","y**0","屏幕真的很棒,建议入手，运行速度是真的很快");
        goods.add(good1);
        goods.add(good2);
        goods.add(good3);
        goods.add(good4);
        goods.add(good5);
        ListCustomAdapter customAdapter=new ListCustomAdapter(getActivity(),R.layout.list_item, goods);
        ListView listView=view.findViewById(R.id.lv);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Good good=goods.get(position);
                Intent intent=new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("product",good);
                startActivity(intent);
            }
        });
        return view;
    }
}

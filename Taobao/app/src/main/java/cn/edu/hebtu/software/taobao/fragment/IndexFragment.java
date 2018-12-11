package cn.edu.hebtu.software.taobao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.taobao.Adapter.IndexCustomerAdapter;
import cn.edu.hebtu.software.taobao.Bean.Logo;
import cn.edu.hebtu.software.taobao.GridViewForScrollView;
import cn.edu.hebtu.software.taobao.R;

public class IndexFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.index_layout,container,false);
        List<Logo> logos=new ArrayList<>();
        Logo logo1=new Logo(R.drawable.logo1,"天猫");
        Logo logo2=new Logo(R.drawable.logo2,"聚划算");
        Logo logo3=new Logo(R.drawable.logo3,"天猫国际");
        Logo logo4=new Logo(R.drawable.logo4,"饿了么");
        Logo logo5=new Logo(R.drawable.logo5,"天猫超市");
        Logo logo6=new Logo(R.drawable.logo6,"充值中心");
        Logo logo7=new Logo(R.drawable.logo7,"飞猪旅行");
        Logo logo8=new Logo(R.drawable.logo8,"领金币");
        Logo logo9=new Logo(R.drawable.logo9,"拍卖");
        Logo logo10=new Logo(R.drawable.logo10,"分类");
        logos.add(logo1);
        logos.add(logo2);
        logos.add(logo3);
        logos.add(logo4);
        logos.add(logo5);
        logos.add(logo6);
        logos.add(logo7);
        logos.add(logo8);
        logos.add(logo9);
        logos.add(logo10);
        IndexCustomerAdapter customerAdapter=new IndexCustomerAdapter(getActivity(),logos,R.layout.index_griditem);
        GridViewForScrollView gridView=(GridViewForScrollView)view.findViewById(R.id.gridview);
        gridView.setAdapter(customerAdapter);
        return view;
    }
}

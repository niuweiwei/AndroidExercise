package cn.edu.hebtu.software.taobao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.taobao.R;
import cn.edu.hebtu.software.taobao.Bean.Logo;


public class IndexCustomerAdapter extends BaseAdapter {
    private Context context;
    private List<Logo> logos=new ArrayList<>();
    private int itemLayout;

    public IndexCustomerAdapter(Context context, List<Logo> logos, int itemLayout) {
        this.context = context;
        this.logos = logos;
        this.itemLayout = itemLayout;
    }

    @Override
    public int getCount() {
        return logos.size();
    }

    @Override
    public Object getItem(int position) {
        return logos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(itemLayout,null);
        }
        ImageView imageView=convertView.findViewById(R.id.logo);
        imageView.setImageResource(logos.get(position).getImageId());
        TextView textView=convertView.findViewById(R.id.tv);
        textView.setText(logos.get(position).getText());
        return convertView;
    }
}

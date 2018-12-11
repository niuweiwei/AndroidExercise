package cn.edu.hebtu.software.taobao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.taobao.Bean.Info;
import cn.edu.hebtu.software.taobao.R;

public class MyGridCustomerAdapterI extends BaseAdapter {
    private List<Info> userInfo=new ArrayList<>();
    private Context context;
    private int item;

    public MyGridCustomerAdapterI(List<Info> userInfo, Context context, int item) {
        this.userInfo = userInfo;
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return userInfo.size();
    }

    @Override
    public Object getItem(int position) {
        return userInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView) {
            convertView = LayoutInflater.from(context).inflate(item, null);
        }
        TextView count=convertView.findViewById(R.id.tv_count);
        count.setText(userInfo.get(position).getCount());
        TextView name=convertView.findViewById(R.id.tv_name);
        name.setText(userInfo.get(position).getInfoName());
        return convertView;
    }
}

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

import cn.edu.hebtu.software.taobao.Bean.Tool;
import cn.edu.hebtu.software.taobao.R;

public class MyGridCustomerAdapterIII extends BaseAdapter {
    private List<Tool> tools=new ArrayList<>();
    private Context context;
    private int item_layout;

    public MyGridCustomerAdapterIII(List<Tool> tools, Context context, int item_layout) {
        this.tools = tools;
        this.context = context;
        this.item_layout = item_layout;
    }

    @Override
    public int getCount() {
        return tools.size();
    }

    @Override
    public Object getItem(int position) {
        return tools.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            convertView= LayoutInflater.from(context).inflate(item_layout,null);
        }
        ImageView imageView=convertView.findViewById(R.id.iv_button1);
        imageView.setImageResource(tools.get(position).getImage_id());
        TextView textView=convertView.findViewById(R.id.tv_button1);
        textView.setText(tools.get(position).getName());
        return convertView;
    }
}

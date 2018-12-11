package cn.edu.hebtu.software.taobao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.taobao.Bean.BuyButton;
import cn.edu.hebtu.software.taobao.R;

public class MyGridCustomerAdapterII extends BaseAdapter {
    private List<BuyButton> buyButtons=new ArrayList<>();
    private Context context;
    private int item_layout;

    public MyGridCustomerAdapterII(List<BuyButton> buyButtons, Context context, int item_layout) {
        this.buyButtons = buyButtons;
        this.context = context;
        this.item_layout = item_layout;
    }

    public MyGridCustomerAdapterII() {
        super();
    }

    @Override
    public int getCount() {
        return buyButtons.size();
    }

    @Override
    public Object getItem(int position) {
        return buyButtons.get(position);
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
        imageView.setImageResource(buyButtons.get(position).getImageId());
        TextView textView=convertView.findViewById(R.id.tv_button1);
        textView.setText(buyButtons.get(position).getName());
        return convertView;
    }
}

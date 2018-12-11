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
import cn.edu.hebtu.software.taobao.Bean.Good;

public class ListCustomAdapter extends BaseAdapter {
    private Context context;
    private int item_layout;
    private List<Good> Goods =new ArrayList<>();

    public ListCustomAdapter(Context context, int item_layout, List<Good> Goods) {
        this.context = context;
        this.item_layout = item_layout;
        this.Goods = Goods;
    }

    @Override
    public int getCount() {
        return Goods.size();
    }
    @Override
    public Object getItem(int position) {
        return Goods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(item_layout,null);
        }
        ImageView imageView=convertView.findViewById(R.id.iv_product);
        imageView.setImageResource(Goods.get(position).getImageId());
        TextView product=convertView.findViewById(R.id.tv_product);
        product.setText(Goods.get(position).getProduct());
        TextView price=convertView.findViewById(R.id.tv_price);
        price.setText(Goods.get(position).getPrice());
        TextView city=convertView.findViewById(R.id.tv_city);
        city.setText(Goods.get(position).getCity());
        return convertView;
    }
}

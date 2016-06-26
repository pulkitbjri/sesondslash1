package secondslash.secondslash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    String items[],item[];
    LayoutInflater mInflater;

    public Adapter(Context context, String[] items) {
        mInflater = LayoutInflater.from(context);
        this.items = items;
        this.item=item;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView ==null)
        {
            convertView = mInflater.inflate(R.layout.list_news,parent,false);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.title);
            holder.iv = (ImageView) convertView.findViewById(R.id.icon);
            //holder.desc=(TextView)convertView.findViewById(R.id.desc);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(items[position]);

        //holder.tv.setText(item[position]);
        // use holder.iv to set whatever image you want according to the position
        return convertView;
    }

    static class ViewHolder
    {
        ImageView iv;
        TextView tv,desc;
    }
}
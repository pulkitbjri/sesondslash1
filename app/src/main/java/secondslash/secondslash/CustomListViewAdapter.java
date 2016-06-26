package secondslash.secondslash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class CustomListViewAdapter extends ArrayAdapter {

    List list=new ArrayList();

    public CustomListViewAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(newsDetails object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.list_news,parent,false);
            contactHolder=new ContactHolder();
            contactHolder.title=(TextView)row.findViewById(R.id.title);
            contactHolder.desc=(TextView)row.findViewById(R.id.desc);
            contactHolder.icon=(ImageView)row.findViewById(R.id.icon);
            row.setTag(contactHolder);
        }
        else {
            contactHolder=(ContactHolder)row.getTag();
        }

        newsDetails contacts=(newsDetails)this.getItem(position);
        contactHolder.title.setText(contacts.getheadline());
        contactHolder.desc.setText(contacts.gettopicId());
        contactHolder.icon.setImageBitmap(contacts.getImage());

        return row;
    }

    static class ContactHolder{
        TextView title,desc;
        ImageView icon;
    }
}



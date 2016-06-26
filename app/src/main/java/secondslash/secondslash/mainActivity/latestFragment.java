package secondslash.secondslash.mainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import secondslash.secondslash.Adapter;
import secondslash.secondslash.R;
import secondslash.secondslash.feedsActivity;

/**
 * Created by Ratan on 7/29/2015.
 */
public class latestFragment extends Fragment {
    final String[] items = new String[] { "news", "news1", "news2",
            "news4", "news4", "news4", "news4", "news4",
            "news4", "news4", "news4", "news4", "news4" };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.latest_layout, container, false);
        ListView list = (ListView)view.findViewById(R.id.list1);
        Adapter cus = new Adapter(getActivity(),items);
        list.setAdapter(cus);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Log.v("TAG", "CLICKED row number: " + arg2);

                Intent myIntent = new Intent(getActivity(), feedsActivity.class);
                myIntent.putExtra("welkerij", arg2);
                startActivity(myIntent);

            }

        });

        return view;

    }
}
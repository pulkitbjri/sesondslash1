package secondslash.secondslash.mainActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import secondslash.secondslash.Adapter;
import secondslash.secondslash.CustomListViewAdapter;
import secondslash.secondslash.JP;
import secondslash.secondslash.MainActivity;
import secondslash.secondslash.R;
import secondslash.secondslash.RowItem;
import secondslash.secondslash.feedsActivity;
import secondslash.secondslash.newsDetails;

/**
 * Created by alokit nigam on 7/29/2015.
 */
public class topnewsFragment extends Fragment {
Bitmap bmp;

    ListView list;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topnews_layout, null);



         list = (ListView) view.findViewById(R.id.list);
       CustomListViewAdapter cus = new CustomListViewAdapter(this.getActivity(), R.layout.list_news);
        list.setAdapter(cus);
       //JP jp =new JP();

       //jp.getJSON();






       /* if(json_string==null){
            Toast.makeText(this.getContext(),"First get JSON",Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                JSONObject jsonObject=new JSONObject(json_string);
                JSONArray jsonArray=jsonObject.getJSONArray("server_response");
                int count=0;
                String articleId,topicId,headline,article,image;

                while(count<jsonArray.length()){

                    JSONObject JO=jsonArray.getJSONObject(count);
                    articleId=JO.getString("article_id");
                    topicId=JO.getString("topic_id");
                    headline=JO.getString("headline");
                    article=JO.getString("article");
                    image=JO.getString("image");
                    byte[] qrimage = Base64.decode(image.getBytes(), count);
                    bmp = BitmapFactory.decodeByteArray(qrimage, 0, qrimage.length);
                    newsDetails nd=new newsDetails(articleId,topicId,headline,article,bmp);
                    cus.add(nd);
                    count++;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
*/


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                    long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(getContext(), "You clicked on position : " + pos + " and id : " + arg3, Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(getActivity(), feedsActivity.class);

                startActivity(myIntent);
            }

        });

        return view;

    }
}


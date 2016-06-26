package secondslash.secondslash;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by alokit nigam on 12/5/2015.
 */
public class JP extends Activity {

    String JSON_STRING,json_string;
    public Bitmap bmp;

    CustomListViewAdapter customListViewAdapter=new CustomListViewAdapter(this,R.layout.list_news);
    public void getJSON(){
        Toast.makeText(this,"here",Toast.LENGTH_SHORT).show();
        new BackgroundTask1().execute();
        Toast.makeText(this,"here",Toast.LENGTH_SHORT).show();
    }


    class BackgroundTask1 extends AsyncTask<Void,Void,String>
    {

        String json_url;
        @Override
        protected void onPreExecute() {
            json_url="http://secondslash.site88.net/json_get_data.php";

        }

        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((JSON_STRING=bufferedReader.readLine())!=null){
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            json_string=result;
            display();
        }
    }

    public void display(){
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
                customListViewAdapter.add(nd);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

package secondslash.secondslash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;

import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {
    Button login, sign_up;
    TextView welcome, welcome2,error;
    EditText loginid, password;
    String email, pwd, pwd1;
    String JSON_STRING,json_string;
    public final static boolean validation(CharSequence ch)
    {
    if(TextUtils.isEmpty(ch))
    {
        return false;
    }
        else
        {
        return Patterns.EMAIL_ADDRESS.matcher(ch).matches();
        }
    }
    public static boolean isValidEmail(String target)
    {
        return target.contains("@");
      //  return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (Button) findViewById(R.id.login);
        welcome = (TextView) findViewById(R.id.textView);
        welcome2 = (TextView) findViewById(R.id.textView2);
        sign_up = (Button) findViewById(R.id.signup);
        loginid = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        error= (TextView) findViewById(R.id.error);
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isConnected()){
            error.setVisibility(View.INVISIBLE);
        }
        else {
            login.setEnabled(false);
            sign_up.setEnabled(false);
            loginid.setEnabled(false);
            password.setEnabled(false);
        }
    }


        public void login(View view) {

                email=loginid.getText().toString();
                pwd=password.getText().toString();
                String method = "Login";
               BackgroundTask backgroundTask= new BackgroundTask(this);
                backgroundTask.execute(method,email,pwd);
            Thread timer = new Thread(){
                public void run(){
                    try{
                        sleep(3000);

                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {

                        Intent i1 = new Intent(login.this,secondslash.secondslash.MainActivity.class);
                        startActivity(i1);
                    }

                }
            };
            timer.start();
        }




        public void signup(View view)
        {
            startActivity(new Intent(this, signup.class));
        }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

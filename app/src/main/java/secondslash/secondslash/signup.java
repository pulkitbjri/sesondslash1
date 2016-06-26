package secondslash.secondslash;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class signup extends AppCompatActivity {
    Button next;
   public TextView Email,Pwd,Pwd1,Fname,Lname;


    String email,pwd,fname,lname,pwd1;
    String stringarray[];
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Pwd1 = (TextView) findViewById(R.id.SUpwdconf);
        Fname = (TextView) findViewById(R.id.SUfname);
        Lname = (TextView) findViewById(R.id.SUlname);
        next = (Button) findViewById(R.id.SUnext);
        Email = (TextView) findViewById(R.id.SUemail_id);
        Pwd = (TextView) findViewById(R.id.SUpwd);
        login = (TextView) findViewById(R.id.tvlogin);}


    public void register(View view) {

        email = Email.getText().toString();
        pwd = Pwd.getText().toString();
        fname = Fname.getText().toString();
        lname = Lname.getText().toString();
        pwd1 = Pwd1.getText().toString();
        String method = "signup";
        BackgroundTask bTask = new BackgroundTask(this);
        bTask.execute(method,fname, lname, email, pwd);
        finish();
    }


    public void login1(View view) {

        startActivity(new Intent(this, login.class));
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
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

package secondslash.secondslash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;

import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class signup1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner DateSpinner,MonthSpinner,YearSpinner;
    private static final String[] pathDate={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
            "20","21","22","23","24","25","26","27","28","29","30","31"};
    private static final String[] pathMonth={"January","February","March","April","june","July","August","September","October",
            "November","December"};
    private static final String[] pathYear={"1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
            "1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
            "2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
            "2011","2012","2013","2014","2015","2016",};
    RadioButton sex;
    Button register;
    RadioGroup sexgrp;
    DBhelper myDb;
    String data[]=new String[4];
    String datepick,monthpick,yearpick,genderselected,dob;
    String setemail,setpwd,setfname,setlname;
    public void getdata()
    {
        setemail=data[0];
        setfname=data[1];
        setlname=data[2];
        setpwd=data[3];
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup1);
        register= (Button) findViewById(R.id.registerbutton);
        DateSpinner= (Spinner) findViewById(R.id.DateDrop);
        MonthSpinner= (Spinner) findViewById(R.id.MonthDrop);
        YearSpinner= (Spinner) findViewById(R.id.YearDrop);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,pathDate);
        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,pathMonth);
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,pathYear);
        DateSpinner.setAdapter(adapter);
        DateSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        MonthSpinner.setAdapter(adapter1);
        MonthSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        YearSpinner.setAdapter(adapter2);
        YearSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        myDb=new DBhelper(this);
        data=getIntent().getStringArrayExtra("key");
        signup1 get=new signup1();
        get.getdata();
        datepick= (String) DateSpinner.getSelectedItem();
        monthpick= (String) MonthSpinner.getSelectedItem();
        yearpick= (String) YearSpinner.getSelectedItem();
        dob=datepick+"/"+monthpick+"/"+yearpick;
       // sexgrp= (RadioGroup) findViewById(R.id.radiosexgrp);
        /*int selectedid=sexgrp.getCheckedRadioButtonId();
       // sex= (RadioButton) findViewById(selectedid);
        if (selectedid==R.id.malebutton)
                genderselected="male";
        if (selectedid==R.id.femalebutton)
                genderselected="female";


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isTnserted=myDb.insertdata(setemail, setfname, setlname, setpwd);
                if(isTnserted==true)
                    Toast.makeText(signup1.this,"You have been registered",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(signup1.this,"You have not been registered",Toast.LENGTH_LONG).show();
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup1, menu);
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



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

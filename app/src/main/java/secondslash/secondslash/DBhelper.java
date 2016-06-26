package secondslash.secondslash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alokit nigam on 10/8/2015.
 */
public class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="secondslash.db";
    public static final String TABLE_NAME="User_details";
    public static final String Email="email_id";
    public static final String password="password";
    public static final String Firstname="first_name";
    public static final String lastname="last_name";
   // public static final String dob="dob";
 //  public static final String gender="gender";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(email_id text primary key ,first_name text,last_name text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists"+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertdata(String email,String Fname,String Lname,String pwd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Email,email);
        cv.put(Firstname,Fname);
        cv.put(lastname,Lname);
        cv.put(password,pwd);
       // cv.put(gender,gen);
      //  cv.put(dob,Dob);
        long res =db.insert(TABLE_NAME,null,cv);
        if (res==-1)
            return false;
        else
            return true;
     }
    public String getdata(String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.query(TABLE_NAME,null,"email_id=?",new String[]{email},null,null,null);
        if (c.getCount()<0)
        {
            c.close();
            return "not exist";
        }
        c.moveToFirst();
        String pwd=c.getString(c.getColumnIndex("password"));
        c.close();
        return pwd;
    }
}

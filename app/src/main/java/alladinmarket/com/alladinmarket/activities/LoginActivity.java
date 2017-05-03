package alladinmarket.com.alladinmarket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.utils.MyApplication;

public class LoginActivity extends AppCompatActivity {

    private EditText email ;
    private EditText password ;


    Toolbar mToolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        email = (EditText) findViewById(R.id.edit_text_email);
        password = (EditText) findViewById(R.id.edit_text_passowrd);
        setSupportActionBar(mToolbar);
    }


    public void login(View v){
        Log.v("reachhere",email.getText().toString()+"correct");
        if (email.getText().toString().compareToIgnoreCase("shopkeeper@gmail.com")==0/*&& password.getText().toString()=="12345678"*/)
        {
            MyApplication.sShopkeeper_flag =true ;
        }

            Log.v("reachhere","yesagain");
            Intent i = new Intent(this, DrawerActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);



    }
}

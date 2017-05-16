package alladinmarket.com.alladinmarket.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.utils.MyApplication;

public class SignUpActivity extends AppCompatActivity {

    Toolbar mToolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }


    public void login(View v){


        Log.v("reachhere","yesagain");
        Intent i = new Intent(this, DrawerActivity.class);
      /*  i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);*/
        startActivity(i);



    }
}

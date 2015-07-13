package com.example.vinif_000.ilikemyheadphone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RecoverActivity extends ActionBarActivity {

    EditText textemail;
    String email;
    static String Extramessage = "ilike.head";
    private String message = "Sua nova senha foi enviado para email informado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover);

        textemail = (EditText) findViewById(R.id.edittext_emailrecover);
        Intent intent = getIntent();
        email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL);

        // if the user put his email on the edittext of login activity we are reusing his email
        settextview(email);

    }

    private void settextview (String mail){
        if(mail.length()!=0){
            textemail.setText(mail);
        }

    }

    public void backtologinactivity (View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void generateanewpassword(View v){
        // method to generat a new user password
         Toast.makeText(getApplicationContext(),"it will do something soon", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recover, menu);
        getSupportActionBar().hide();
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

package com.example.vinif_000.ilikemyheadphone;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {

    EditText nome, email, password, passawordtwo;
    static  String Extra_message = "vini.nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nome = (EditText) findViewById(R.id.edittext_nomeregister);
        email = (EditText) findViewById(R.id.edittext_emailregister);
        password = (EditText) findViewById(R.id.edittext_passwordregister);
        passawordtwo = (EditText) findViewById(R.id.edittext_passwordtworegister);
    }

    public void registeruser (View view){
        if(nome.getText().length() >0 && email.getText().length() > 0 &&
                password.getText().toString().equals(passawordtwo.getText().toString()) ){
            String name = nome.getText().toString();
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra(Extra_message, name);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,R.string.registerdatawrong,Toast.LENGTH_SHORT).show();
        }

    }

    public void backtologinactivity(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

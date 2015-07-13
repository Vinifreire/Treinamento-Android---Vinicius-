package com.example.vinif_000.ilikemyheadphone;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    private String email = "";
    private String password = "";

    public final String user = "Vini";
    public static String EXTRA_EMAIL = "com.email";
    public static String EXTRA_USER = "com.email";

    EditText useremail, userpassword;
    CheckBox check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // it is necessary to use and to set both as underline
        TextView textviewpassword = (TextView) findViewById(R.id.textView_signIn);
        TextView textviewsingin = (TextView) findViewById(R.id.textView_password);

        // method to underline two TextView (Singin, Forget the password)
        setunderline(textviewpassword,textviewsingin);


        useremail = (EditText) findViewById(R.id.edittext_email) ;
        userpassword = (EditText) findViewById(R.id.edittext_password);
        check = (CheckBox) findViewById(R.id.mostrarsenha);

        // method to change the type of checkBox : checked - show password  / not checked - hide the password
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changetype();
            }
        });


    }


    public void mainwindow(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(EXTRA_USER,user);
        startActivity(intent);
    }

    public void forgetmypassword(View view){
        Intent intent = new Intent(this,RecoverActivity.class);
        intent.putExtra(EXTRA_EMAIL,useremail.getText().toString());
        startActivity(intent);
    }

    public void register(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }


    public void  changetype(){
        String pass;

        if(check.isChecked()){
            userpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//
//            pass = userpassword.getText().toString();
//            userpassword.setInputType(InputType.TYPE_CLASS_TEXT);
//            userpassword.setText(pass);
        } else {
            userpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
//            pass = userpassword.getText().toString();
//            userpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
//            userpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//            userpassword.setText(pass);
        }
    }

    public void Systemlogin(View view){
        int controle = 2;

        if(email.equals(useremail.getText().toString())){
         controle --;
        }else{
            controle = controle+10;
        }

        if (password.equals(userpassword.getText().toString())){
         controle --;
        }else {
            controle = controle - 10;
        }

        verificapassword(controle);


    }

    private void verificapassword(int control){
        switch (control){
            case 0:
                //make login
                mainwindow();
            break;

            case 2:
                // email e password is not correct
                Toast.makeText(getApplicationContext(),R.string.allwrong,Toast.LENGTH_SHORT).show();
            break;

            case 11:
                //email is not correct
                Toast.makeText(getApplicationContext(),R.string.emailwrong,Toast.LENGTH_SHORT).show();
            break;

            case (-9):
                //password is not correct
                Toast.makeText(getApplicationContext(),R.string.paasswordwrong,Toast.LENGTH_SHORT).show();
            break;


        }
    }


    private void setunderline(TextView password, TextView singin){

        // textView "esqueceu a senha " set underline
        String forgetpassword = password.getText().toString();
        SpannableString content = new SpannableString(forgetpassword);
        content.setSpan(new UnderlineSpan(), 0, forgetpassword.length(), 0);
        password.setText(content);

        // textView " registra-se " set underline
        String singinaux = singin.getText().toString();
        SpannableString contentsing = new SpannableString(singinaux);
        contentsing.setSpan(new UnderlineSpan(), 0, singinaux.length(), 0);
        singin.setText(contentsing);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

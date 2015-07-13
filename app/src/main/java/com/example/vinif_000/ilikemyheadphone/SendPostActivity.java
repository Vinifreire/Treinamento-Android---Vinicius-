package com.example.vinif_000.ilikemyheadphone;


import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;




public class SendPostActivity extends ActionBarActivity {


    private int REQUEST_IMAGE_CAPTURE = 100;
    EditText marca,modelo,avaliacao;
    Bitmap imageBitmap;
    ImageView profile;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_post);
        marca = (EditText) findViewById(R.id.sendmarca);
        modelo = (EditText) findViewById(R.id.sendmodelo);
        avaliacao = (EditText) findViewById(R.id.sendaval);
        profile = (ImageView) findViewById(R.id.profile_photo);
        rating = (RatingBar) findViewById(R.id.ratingsend);
    }

    public void backmain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void takepicture(View view){
        // method to acess the camera ...

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
             this.imageBitmap = (Bitmap) extras.get("data");
            profile.setImageBitmap(imageBitmap);
        }
    }

    public void buttonpost (View view){

        Intent intent = new Intent(this,MainActivity.class);
        MainActivity.user.add(new User(imageBitmap,avaliacao.getText().toString(),rating.getRating(),
                marca.getText().toString(),modelo.getText().toString()));
        startActivity(intent);
        finish();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_send_post, menu);
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

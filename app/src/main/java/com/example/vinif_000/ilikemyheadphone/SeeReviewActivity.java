package com.example.vinif_000.ilikemyheadphone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class SeeReviewActivity extends ActionBarActivity {


    TextView marca,modelo,aval;
    ImageView profilepicture;
    RatingBar rat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_review);

        profilepicture = (ImageView) findViewById(R.id.profile_photosee);
        marca = (TextView) findViewById(R.id.profilemarcasee);
        modelo = (TextView) findViewById(R.id.profilemodelosee);
        aval = (TextView) findViewById(R.id.profileavalsee);
        rat = (RatingBar) findViewById(R.id.ratingsee);

        byte[] byteArray = getIntent().getByteArrayExtra(MyCustomAdapter.MESSAGEPROFILE);
        Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        profilepicture.setImageBitmap(image);
        marca.setText(getIntent().getStringExtra(MyCustomAdapter.MESSAGEMARCA));
        modelo.setText(getIntent().getStringExtra(MyCustomAdapter.MESSAGEMODELO));
        aval.setText(getIntent().getStringExtra(MyCustomAdapter.MESSAGEDESCRIPTION));
        rat.setRating(getIntent().getFloatExtra(MyCustomAdapter.MESAGERATING,3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_see_review, menu);
        getSupportActionBar().hide();
        return true;
    }

    public  void seetobackmain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
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

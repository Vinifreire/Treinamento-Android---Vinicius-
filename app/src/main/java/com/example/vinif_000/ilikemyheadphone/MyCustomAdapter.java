package com.example.vinif_000.ilikemyheadphone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by vinif_000 on 10/07/2015.
 */
public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<User> profile;
    static String MESSAGEDESCRIPTION = "profile.descrition";
    static String MESSAGEMODELO = "profile.modelo";
    static String MESSAGEMARCA = "profile.marca";
    static String MESAGERATING ="profile.rating";
    static String MESSAGEPROFILE = "profile.picture";


    public MyCustomAdapter(Context context, List<User> user){
        this.context = context;
        this.profile = user;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return this.profile.size();
    }

    @Override
    public Object getItem(int position) {
        return this.profile.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final User profile = this.profile.get(position);

        myViewHold viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_my_custom_list,parent,false);
            viewHolder = new myViewHold(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (myViewHold) convertView.getTag();
        }

        // Here set every tha my custom list has ...



        //Convert to byte array
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        profile.getProfilepicture().compress(Bitmap.CompressFormat.PNG, 100, stream);
        final byte[] byteArray = stream.toByteArray();



        viewHolder.description.setText(profile.getDescription());
        viewHolder.headphone.setText(profile.getHeadphone() + profile.getMarca());
        viewHolder.rating.setRating(profile.getRating());
        viewHolder.imageprofile.setImageBitmap(profile.getProfilepicture());


        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SeeReviewActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(MESSAGEPROFILE,byteArray);
                intent.putExtra(MESSAGEDESCRIPTION,profile.getDescription());
                intent.putExtra(MESAGERATING,profile.getRating());
                intent.putExtra(MESSAGEMARCA,profile.getHeadphone());
                intent.putExtra(MESSAGEMODELO,profile.getMarca());
                context.startActivity(intent);

            }
        });

        viewHolder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(context, SeeReviewActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(MESSAGEPROFILE,byteArray);
                intent.putExtra(MESSAGEDESCRIPTION,profile.getDescription());
                intent.putExtra(MESAGERATING,profile.getRating());
                intent.putExtra(MESSAGEMARCA,profile.getHeadphone());
                intent.putExtra(MESSAGEMODELO,profile.getMarca());
                context.startActivity(intent);

            }
        });

        return convertView;
    }



    private class  myViewHold{
        ImageView imageprofile;
        TextView description,headphone;
        RatingBar rating;
        ImageButton button;


        public myViewHold(View view){
            imageprofile = (ImageView) view.findViewById(R.id.image_profile);
            description = (TextView) view.findViewById(R.id.textView_profile);
            headphone = (TextView) view.findViewById(R.id.textView_marca);
            rating = (RatingBar) view.findViewById(R.id.ratinglist);
            button = (ImageButton) view.findViewById(R.id.buttonset);

        }

    }


}

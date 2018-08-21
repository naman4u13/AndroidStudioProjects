package com.example.hp.firstapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hp on 16-05-2018.
 */

public class customadapt extends ArrayAdapter<word> {

    private MediaPlayer mediaPlayer;
    public customadapt(@NonNull Context context,  @NonNull List objects) {
        super(context,0,objects);  }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Viewholder holder;
         View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout1, parent, false);
            holder = new Viewholder();

            holder.ENG = (TextView) listItemView.findViewById(R.id.eng);


            holder.HIN = (TextView) listItemView.findViewById(R.id.hin);

            holder.BUT = (Button) listItemView.findViewById(R.id.but);


            listItemView.setTag(holder);

        }
        else {

            holder = (Viewholder) listItemView.getTag();

        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final word currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView engTextView = holder.ENG;
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        engTextView.setText(currentword.getEnglish());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView hinTextView = holder.HIN;
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        hinTextView.setText(currentword.getHindi());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        Button bview =  holder.BUT;
        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(getContext(), currentword.getAudio());
                mediaPlayer.start();

            }
        });


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

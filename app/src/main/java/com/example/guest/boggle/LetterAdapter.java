package com.example.guest.boggle;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.guest.boggle.R.id.grid_item_letter;
import static com.example.guest.boggle.R.layout.letter_grid_item;


public class LetterAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mLetters;


    @Override
    public int getCount() {
        return mLetters.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    public LetterAdapter (Context context, ArrayList<String> letters) {
        this.mContext = context;
        this.mLetters = letters;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            gridView = inflater.inflate(letter_grid_item, null);

            TextView letterView = (TextView) gridView
                    .findViewById(grid_item_letter);

            letterView.setText(mLetters.get(position));
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}

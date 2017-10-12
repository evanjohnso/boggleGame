package com.example.guest.boggle;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;


public class WordAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<String> mWords;
    private Bundle mBundle;

    public WordAdapter(Context mContext, int resource, ArrayList<String> mWords) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mWords = mWords;
    }

    @Override
    public Object getItem(int position) {
        String word = mWords.get(position);
        return String.format("%s \n", word);
    }

    @Override
    public int getCount() {return mWords.size(); }


}

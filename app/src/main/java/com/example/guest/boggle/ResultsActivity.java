package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {
    ArrayList<String> ourData;

    @Bind(R.id.display_correct_words)
    ListView displayCorrectWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        ButterKnife.bind(this);
//        ourData = getData();
        Bundle b = this.getIntent().getExtras();
        ourData = b.getStringArrayList("correctAnswers");
        WordAdapter adapter = new WordAdapter(this, android.R.layout.simple_list_item_1, ourData);
        displayCorrectWords.setAdapter(adapter);
    }

//    private ArrayList<String> getData() {
//
//    }
}

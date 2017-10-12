package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private final String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private final String[] vowels = new String[]{"a", "e", "i", "o", "u"};
    private final String[] gameLetters = new String[] {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }


    private ArrayList<String> checkForVowelsInRandomLetterArray(ArrayList<String> randomLetterArray) {

        int vowelCount = 0;

        for (int i = 0; i < randomLetterArray.size(); i ++ ) {

            for (int j = 0; j < vowels.length ;i ++ ) {

                if (randomLetterArray.get(i) == vowels[j]) {
                    vowelCount+=1;
                }
            }

        }
    }


    private ArrayList<String> createGameOfEightRandomLetters() {
        ArrayList<String> gameArray = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            gameArray.add(randomLetter(letters));
        }



        return gameArray;


    }



    private String randomLetter(String[] array) {
        return array[ randomNumber(array.length) ];
    }

    private int randomNumber(int number) {
        Random rand = new Random();
        return rand.nextInt(number);
    }



}

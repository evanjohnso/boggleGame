package com.example.guest.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private final String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private final String[] vowels = new String[]{"a", "e", "i", "o", "u"};
    private ArrayList<String> gameArray;
    GridView gridView;

    @Bind(R.id.submit_word_button) Button mUserSubmitButton;
    @Bind(R.id.user_input_edit_text_field) EditText mUserEditTextField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        gameArray = createGameOfEightRandomLetters();

        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new LetterAdapter(this, gameArray));

        mUserSubmitButton.setOnClickListener(this);
    }


    private int checkForVowelsInRandomLetterArray(ArrayList<String> randomLetterArray) {

        int vowelCount = 0;
        for (int i = 0; i < randomLetterArray.size(); i ++ ) {
            for (int j = 0; j < vowels.length ;j ++ ) {
                if (randomLetterArray.get(i) == vowels[j]) {
                    vowelCount+=1;
                }
            }
        }
        return vowelCount;
    }


    private ArrayList<String> createGameOfEightRandomLetters() {
        ArrayList<String> gameArray = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            gameArray.add(randomLetter(letters));
        }
        if (checkForVowelsInRandomLetterArray(gameArray) == 0) {
            gameArray.add(randomLetter(vowels));
            gameArray.add(randomLetter(vowels));
        } else if (checkForVowelsInRandomLetterArray(gameArray) == 1) {
            gameArray.add(randomLetter(letters));
            if (checkForVowelsInRandomLetterArray(gameArray) == 1 && gameArray.size() == 7) {
                gameArray.add(randomLetter(vowels));
            }
        } else {
            gameArray.add(randomLetter(letters));
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

    private ArrayList<String> createCloneOfGameArrayToLoopThrough() {
        ArrayList<String> clone = new ArrayList<String>();
        clone.addAll(gameArray);
        return clone;
    }

    private boolean verifyInput(String input) {
        ArrayList<String> cloneGameArray = createCloneOfGameArrayToLoopThrough();
        if (input.length() < 3) return false;

        boolean validInput = true;

        for (int i =0; i < input.length(); i++) {
            int indexOfMatchingNumber = cloneGameArray.indexOf(Character.toString(input.charAt(i)));
            System.out.println(indexOfMatchingNumber);
            if (indexOfMatchingNumber > -1) {
                cloneGameArray.remove(indexOfMatchingNumber);
            } else {
                System.out.println("why are you happening");
                validInput = false;
                return validInput;
            }
        }
        return validInput;
    }

    private Toast makeToast(String message) {
        return Toast.makeText(GameActivity.this, message, Toast.LENGTH_LONG);
    }


    @Override
    public void onClick(View view) {
        String userInput = mUserEditTextField.getText().toString();
        if (verifyInput(userInput)) {
            makeToast("Great word!").show();
        } else {
            makeToast("Please enter a valid input, scoundrel!").show();
        }

    }
}

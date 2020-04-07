package com.owl.minervacode;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.enter_message_tv)
    TextView enterMessage;

    @BindView(R.id.message_et)
    EditText inputMessageET;

    @BindView(R.id.encrypt_btn)
    Button encryptButton;

    CircleTextView circleTextView;

    int cx = 270;
    int cy = 270;
    ArrayList arcs;
    ArrayList dots;
    String morseMessage;
    private ArrayList<String> separatedWords;
    // a simple hashMap declaration with default size and load factor
    HashMap<String, String> morse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        arcs = new ArrayList();
        dots = new ArrayList();
        morse = new HashMap<>();
        setupMorseMap();
    }

    @OnClick(R.id.encrypt_btn)
    public void encrypt(View view){

        String messageToEncrypt = inputMessageET.getText().toString();

        // remove all special characters and numbers.
        messageToEncrypt = messageToEncrypt.replaceAll("\\P{L}", " ");
        separatedWords = stringToMorse(messageToEncrypt);

        for (String word : separatedWords)
        {
            Log.wtf("WORDS ARE", word);
        }

        circleTextView = findViewById(R.id.circle_TextView);
        circleTextView.setVisibility(View.VISIBLE);
        circleTextView.setSeparatedWords(separatedWords);

    }

//    public voidf setup() {
//        createCanvas(cx*2,cy*2);
//        background(255);
//        angleMode(DEGREES);
//        ellipseMode(RADIUS);
//    }

    public ArrayList<String> stringToMorse(String string){
        string = string.toLowerCase();

        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(string.split("\\W+")));
        ArrayList<String> morseWords = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++)
        {
            morseWords = new ArrayList<>();
            String[] words = wordsList.get(i).split("(?!^)");
            String morseWord = "";

            for (String letter: words) {
                if (morse.containsKey(letter))
                {
                   morseWord += morse.get(letter)+ " ";
                }

            }
            Log.wtf("TEST", morseWord);
            morseWords.add(morseWord);
        }
        return morseWords;
    }

    public void setupMorseMap(){
        morse.put("a", ". -");
        morse.put("b", "- . . .");
        morse.put("c", "- . - .");
        morse.put("d", "- . .");
        morse.put("e", ".");
        morse.put("f", ". . - .");
        morse.put("g", "- - .");
        morse.put("h", ". . . .");
        morse.put("i", ". .");
        morse.put("j", ". - - -");
        morse.put("k", "- . -");
        morse.put("l", ". - . .");
        morse.put("m", "- -");
        morse.put("n", "- .");
        morse.put("o", "- - -");
        morse.put("p", ". - - .");
        morse.put("q", "- - . -");
        morse.put("r", ". - .");
        morse.put("s", ". . .");
        morse.put("t", "-");
        morse.put("u", ". . -");
        morse.put("v", ". . . -");
        morse.put("w", ". - -");
        morse.put("x", "- . . -");
        morse.put("y", "- . - -");
        morse.put("z", "- - . .");
    }
}

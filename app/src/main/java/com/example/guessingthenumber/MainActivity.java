package com.example.guessingthenumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int replay=0;
    int numberofguesses=0;
    TextView text;
    EditText editText;
    TextView textView;
    ImageView imageView;
    TextView submit;
    TextView guess;
    int userInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.bottomtext);
        imageView=findViewById(R.id.imageView);
        submit=findViewById(R.id.submit);
        guess=findViewById(R.id.guess);
        text=findViewById(R.id.textView);

        sub();

        }

        private void sub(){
            Random random=new Random();
            int rand=random.nextInt(100);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        userInput = Integer.parseInt(editText.getText().toString());
                    }
                    catch (Exception e){
                        guess.setText("");
                    }
                    logic(rand, userInput);
                }
            });
        }

    private void logic(int rand, int userInput) {
            if (rand == userInput) {
                imageView.setImageResource(R.drawable.trophy);
                textView.setText("You Won!!!!");
                numberofguesses++;
                guess.setText("Total Guesses :" + numberofguesses);
                sub();
                numberofguesses = 0;


            } else if (rand > userInput) {
                imageView.setImageResource(R.drawable.ic_baseline_arrow_downward_24);
                textView.setText("Lower");
                numberofguesses++;
                guess.setText("Total Guesses :" + numberofguesses);
            } else {
                imageView.setImageResource(R.drawable.ic_baseline_arrow_upward_24);
                textView.setText("Upper");
                numberofguesses++;
                guess.setText("Total Guesses :" + numberofguesses);
            }
    }
}
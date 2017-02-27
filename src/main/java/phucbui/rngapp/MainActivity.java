/*

Author: Phuc Bui
Project: Simple RNG app
Date: 2/24/2017

 */
package phucbui.rngapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //references objects between xml and this class
         final EditText minEdit =  (EditText) findViewById(R.id.minEditText);
         final EditText maxEdit = (EditText) findViewById(R.id.maxEditText);
         final TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        Button generate = (Button) findViewById(R.id.button);


        //Onclick will ouput a random number between the user's choice of value between min - max
        generate.setOnClickListener(new View.OnClickListener() {

            //initialize the java.util.Random;
            Random random = new Random();

            // initialize these local variables to store and display
            int min, max, rngnum, defaultMin, defaultMax;


            @Override
            public void onClick(View v) {

                try {

                min = Integer.parseInt(minEdit.getText().toString());
                max = Integer.parseInt(maxEdit.getText().toString());

                    if (min >= max) {
                        Toast.makeText(getApplicationContext(), "Min value cannot be equal or greater than Max.", Toast.LENGTH_SHORT).show();
                        resultTextView.setText("");
                    } else {
                        rngnum = random.nextInt((max - min) + 1) + min;
                        resultTextView.setText("You generated " + rngnum + "!");
                    }
                } catch (NumberFormatException e){  // catch this exception make sure the input is an int within Integer.MIN_VALUE or Integer.MAX_VALUE void crashing the app;
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Your inputs are either too large or too small!", Toast.LENGTH_SHORT).show();
                    resultTextView.setText("");
                }
            }
        });

    }


}

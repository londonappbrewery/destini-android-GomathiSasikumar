package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button buttonTop;
    private Button buttonBottom;

    int index;

    int[] Story = {R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End};
    int[] Ans1 = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};
    int[] Ans2 = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = findViewById(R.id.storyTextView);
        buttonTop = findViewById(R.id.buttonTop);
        buttonBottom = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0 || index == 1) {
                    index = 2;
                } else if (index == 2) {
                    index = 5;
                }
                updateStory(index);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == 0) {
                    index = 1;
                } else if (index == 1) {
                    index = 3;
                } else if (index == 2) {
                    index = 4;
                }
                updateStory(index);
            }
        });

    }

    private void updateStory(int indexAns) {
        storyTextView.setText(Story[indexAns]);
        if (indexAns < 3) {
            buttonTop.setText(Ans1[indexAns]);
            buttonBottom.setText(Ans2[indexAns]);
        } else {
            buttonTop.setVisibility(View.INVISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
        }
    }

}
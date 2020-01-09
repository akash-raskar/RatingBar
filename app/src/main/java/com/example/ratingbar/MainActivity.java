package com.example.ratingbar;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;
    Button submit;
    EditText e1;
    ProgressBar p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar=(RatingBar)findViewById(R.id.ratingbar);
        textView=(TextView)findViewById(R.id.textview);
        submit=(Button)findViewById(R.id.submit);
        e1= (EditText)findViewById(R.id.edittext);
        p1=(ProgressBar)findViewById(R.id.progressBar);

        ratingBar.setNumStars(5);
        ratingBar.setStepSize(1);
        ratingBar.setRating(0);

        //textView.setText("Rating:" + ratingBar.getProgress());
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
              //  textView.setText("Rating: " + ratingBar.getProgress());
                Toast.makeText(MainActivity.this, "Thanku For Your Valuable Rating", Toast.LENGTH_SHORT).show();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a= e1.getText().toString().trim();
                AlertDialog.Builder b1 = new AlertDialog.Builder(MainActivity.this);
                b1.setIcon(R.drawable.thumb);
                b1.setTitle(Html.fromHtml("<b>"+"Feedback"+"</b>"));
                b1.setMessage(Html.fromHtml("<b>"+"Feedback is Submitted Succesfully. "+ "<br>" + "Thank You..."+"</b>"));
                b1.show();
                p1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Activity Done", Toast.LENGTH_SHORT).show();
                        p1.setVisibility(View.INVISIBLE);
                    }

                },3000);

            }
        });
    }
}

package sg.edu.rp.webservices.bmiandbmrcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MaleActivity extends AppCompatActivity {
    EditText eth,etw,eta;
    Button btn;

    Integer age,weight;
    Double bmr,height,bmi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male);
        eth = (EditText)findViewById(R.id.eth);
        etw = (EditText)findViewById(R.id.etw);
        eta = (EditText)findViewById(R.id.eta);
        btn = (Button)findViewById(R.id.btnCal);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //height = eth.getText().toString();
                //weight = etw.getText().toString();
                String h = eth.getText().toString();
                String w = etw.getText().toString();
                String a = eta.getText().toString();
                height = Double.valueOf(h).doubleValue();

                weight = Integer.valueOf(w).intValue();
                age = Integer.valueOf(a).intValue();
                Double him = height / 100;


                System.out.print(him);

                //age = eta.getText().toString();
                bmi = weight /((him * him));
                bmr = (10 * weight)+(6.25 * height) - (5 * age) + 5;

                Intent i = new Intent(MaleActivity.this,ResultActivity.class);
                i.putExtra("bmi",bmi);
                i.putExtra("bmr",bmr);
                startActivity(i);

            }
        });


    }
}

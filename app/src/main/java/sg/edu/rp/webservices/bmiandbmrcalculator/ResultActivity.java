package sg.edu.rp.webservices.bmiandbmrcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    TextView tvbmi,tvbmr,tvbmis;
    private static DecimalFormat df2 = new DecimalFormat("#0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        LinearLayout li = (LinearLayout)findViewById(R.id.li);
        Intent i = getIntent();
        tvbmr = (TextView)findViewById(R.id.tvbmr);
        tvbmi = (TextView)findViewById(R.id.tvbmi);
        tvbmis = (TextView)findViewById(R.id.tvbmis);
        String stbmi = i.getSerializableExtra("bmi").toString();
        double dbmi = Double.parseDouble(stbmi);
        String strbmi = df2.format(dbmi);

        if (dbmi >= 30.0){
            li.setBackgroundColor(Color.parseColor("#ff0000"));
            tvbmis.setText("You are obese. You need to watch your diet.");

        }else if(dbmi <= 29.9 && dbmi >= 25){

            li.setBackgroundColor(Color.parseColor("#ff7423"));
            tvbmis.setText("You are overweight.");

        }else if(dbmi <= 24.9 && dbmi >= 18.5){
            li.setBackgroundColor(Color.parseColor("#fffb23"));
            tvbmis.setText("You are at average weight.");
        }else{
            li.setBackgroundColor(Color.parseColor("#35ff23"));
            tvbmis.setText("You are underweight.");
        }

//
        tvbmr.setText(i.getSerializableExtra("bmr").toString());
        tvbmi.setText(strbmi);
    }
}

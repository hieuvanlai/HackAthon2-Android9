package tabian.com.actionbartest;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Button start;
    Spinner spinner;
    private CheckBox cbwhite, cbgreen, cbblue,cbred,cbrgb;
    int option[] = new  int[3];
    EditText etPrice;

    EditText pricetext;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        option[0]=0;
        pricetext= (EditText) findViewById(R.id.et_price);
        cbwhite= (CheckBox) findViewById(R.id.checkBox);
        cbgreen= (CheckBox) findViewById(R.id.checkBox1);
        cbblue= (CheckBox) findViewById(R.id.checkBox2);
        cbred= (CheckBox) findViewById(R.id.checkBox3);
        cbrgb= (CheckBox) findViewById(R.id.checkBox4);
        pricetext= (EditText) findViewById(R.id.et_price);
        pricetext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                pricetext.removeTextChangedListener(this);

                try {
                    String originalString = s.toString();

                    Long longval;
                    if (originalString.contains(",")) {
                        originalString = originalString.replaceAll(",", "");
                    }
                    longval = Long.parseLong(originalString);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longval);

                    //setting text after format to EditText
                    pricetext.setText(formattedString);
                    pricetext.setSelection(pricetext.getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
                pricetext.addTextChangedListener(this);
            }
        });

        if (cbwhite.isChecked()) {
            cbgreen.setChecked(false);
        }
        else if(cbgreen.isChecked()){
            cbgreen.setChecked(false);
        }
        else if (cbblue.isChecked()){
            cbblue.setChecked(false);
        }else if (cbred.isChecked()) {
            cbred.setChecked(false);
        }else {
            cbrgb.setChecked(false);
        }
        cbred.setOnClickListener(this);
        cbrgb.setOnClickListener(this);
        cbgreen.setOnClickListener(this);
        cbwhite.setOnClickListener(this);
        cbblue.setOnClickListener(this);

        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData("Gaming",R.drawable.gamepad));
        list.add(new ItemData("Multimedia",R.drawable.videoplayer));
        list.add(new ItemData("Workstation",R.drawable.workstation));
        list.add(new ItemData("Office",R.drawable.fax));

        SpinnerAdapter adapter=new SpinnerAdapter(this,R.layout.spinner_layout,R.id.txt,list);

        spinner = (Spinner) findViewById(R.id.spinner1);
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
//// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//// Apply the adapter to the spinner


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                option[1]=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        start = (Button) findViewById(R.id.bt_startReading);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startReading();
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_startReading:
                startReading();
                break;
            case R.id.checkBox:
                cbwhite.setChecked(true);
                cbred.setChecked(false);
                cbblue.setChecked(false);
                cbrgb.setChecked(false);
                cbgreen.setChecked(false);
                option[2]=1;
                break;
            case R.id.checkBox1:
                cbwhite.setChecked(false);
                cbred.setChecked(false);
                cbblue.setChecked(false);
                cbrgb.setChecked(false);
                cbgreen.setChecked(true);
                option[2]=2;
                break;
            case R.id.checkBox2:
                cbwhite.setChecked(false);
                cbred.setChecked(false);
                cbblue.setChecked(true);
                cbrgb.setChecked(false);
                cbgreen.setChecked(false);
                option[2]=3;
                break;
            case R.id.checkBox3:
                cbwhite.setChecked(false);
                cbred.setChecked(true);
                cbblue.setChecked(false);
                cbrgb.setChecked(false);
                cbgreen.setChecked(false);
                option[2]=4;
                break;
            case R.id.checkBox4:
                cbwhite.setChecked(false);
                cbred.setChecked(false);
                cbblue.setChecked(false);
                cbrgb.setChecked(true);
                cbgreen.setChecked(false);
                option[2]=5;
                break;

        }

    }

    private void startReading() {
        if (String.valueOf(pricetext.getText()).equals("")){
            Toast.makeText(this,"Mời Nhập Số Tiền",Toast.LENGTH_LONG).show();
        }else {
            Intent intent  = new Intent(this,MainActivity2.class);
            option[0] = 10 ;
            intent.putExtra("option",option);
            startActivity(intent);
        }
    }

}

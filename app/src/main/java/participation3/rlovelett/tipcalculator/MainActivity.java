package participation3.rlovelett.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billTotal;
    RadioButton oneButton;
    RadioButton twoButton;
    RadioButton threeButton;
    RadioButton fourButton;
    CheckBox outstandingServ;
    RadioGroup groupButtons;
    EditText textViewResult;
    EditText textViewResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        billTotal = (EditText) findViewById(R.id.billAmountText);
        oneButton = (RadioButton) findViewById(R.id.oneButton);
        twoButton = (RadioButton) findViewById(R.id.twoButton);
        threeButton = (RadioButton) findViewById(R.id.threeButton);
        fourButton = (RadioButton) findViewById(R.id.fourButton);
        outstandingServ = (CheckBox) findViewById(R.id.outstandingCheck);
        groupButtons = (RadioGroup) findViewById(R.id.radioGroup1);//connects the GUI components to variables
        textViewResult = (EditText) findViewById(R.id.editTextResult);
        textViewResult2 = (EditText) findViewById(R.id.editTextResult2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onButtonClick(View view) {
        Double totalBill = 0.0;
        Double totalTip = 0.0;
        Double tipPerPerson = 0.0;
        Double BASIC_TIP = 0.1;
        Double OUTSTANDING_TIP = 0.2;

        totalBill = Double.parseDouble(billTotal.getText().toString());

        if (outstandingServ.isChecked()) {
            totalTip = totalBill * OUTSTANDING_TIP;
        }
        else {
            totalTip = totalBill * BASIC_TIP;
        }

        if(oneButton.isChecked()) {
            tipPerPerson = totalTip / 1;
        }
        else if (twoButton.isChecked()) {
            tipPerPerson = totalTip / 2;
        }
        else if(threeButton.isChecked()) {
            tipPerPerson = totalTip / 3;
        }
        else if(fourButton.isChecked()) {
            tipPerPerson = totalTip / 4;
        }

        textViewResult.setText("Total Tip: " + totalTip.toString());
        textViewResult2.setText("Tip Per Person: " + tipPerPerson.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

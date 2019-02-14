package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracostacollege.cs134.costalattacars.R;
import edu.miracostacollege.cs134.costalattacars.model.CarLoan;

public class MainActivity extends AppCompatActivity {

    //create references to two edit texts and 1 radio group
    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioGroup loanTermRadioGroup;

    //reference to model (CarLoan)
    private CarLoan loan;

    //Formatters for currency and percentage
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //link controller variable to view
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentEditText = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);

        //instantiate new CarLoan object
        loan = new CarLoan();
    }

    public void switchToLoanSummary(View v)
    {
        // 1) Extract data from 2 edit texts and radio group
        double carPrice;
        double downPayment;
        if(carPriceEditText.getText().toString().equals(""))
        {
            carPrice = 0.0;
        }
        else
        {
            carPrice = Double.parseDouble(carPriceEditText.getText().toString());
        }
        if(downPaymentEditText.getText().toString().equals(""))
        {
            downPayment = 0.0;
        }
        else
        {
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        //switch statement used to determine radio button checked in radio group
        int loanTerm;
        switch(loanTermRadioGroup.getCheckedRadioButtonId())
        {
            case R.id.threeYearsRadioButton:
                loanTerm = 3;
                break;
            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;
            case R.id.fiveYearsRadioButton:
                loanTerm = 5;
                break;
            default:
                loanTerm = 3;
                break;
        }


        // 2) update model CarLoan (object: loan)
        loan.setPrice(carPrice);
        loan.setDownPayment(downPayment);
        loan.setLoanTerm(loanTerm);

        // 3) Create new intent to share data
        //     Intent something = new Intent(start activity, destination activity)
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        //share the data!!!
        loanSummaryIntent.putExtra("monthlyPayment", currency.format(loan.monthlyPayment()));
        loanSummaryIntent.putExtra("carPrice", currency.format(loan.getPrice()));
        loanSummaryIntent.putExtra("salesTaxRate", "7.75");
        loanSummaryIntent.putExtra("taxAmountRate", currency.format(loan.taxAmount()));
        loanSummaryIntent.putExtra("downPayment", currency.format(loan.getDownPayment()));
        loanSummaryIntent.putExtra("totalCost", currency.format(loan.totalCost()));
        loanSummaryIntent.putExtra("borrowedAmount", currency.format(loan.borrowedAmount()));
        loanSummaryIntent.putExtra("interestAmount", currency.format(loan.interestAmount()));
        loanSummaryIntent.putExtra("loanTerm", String.valueOf(loan.getLoanTerm()));



        // 4) Start new activity
        startActivity(loanSummaryIntent);
    }
}

package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    private TextView monthlyPaymentTextView;
    private TextView carPriceTextView;
    private TextView salesTaxRateTextView;
    private TextView taxAmountTextView;
    private TextView downPaymentTextView;
    private TextView totalCostTextView;
    private TextView borrowedAmountTextView;
    private TextView interestAmountTextView;
    private TextView loanTermTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        carPriceTextView = findViewById(R.id.carPriceTextView);
        salesTaxRateTextView = findViewById(R.id.salesTaxRateTextView);
        taxAmountTextView = findViewById(R.id.taxAmountTextView);
        downPaymentTextView = findViewById(R.id.downPaymentTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);
        borrowedAmountTextView = findViewById(R.id.borrowedAmountTextView);
        interestAmountTextView = findViewById(R.id.interestAmountTextView);
        loanTermTextView = findViewById(R.id.loanTermTextView);
        //receive intent from MainActivity
        Intent intent = getIntent();

        //Populate text views
        monthlyPaymentTextView.setText(intent.getStringExtra("monthlyPayment"));
        carPriceTextView.setText(intent.getStringExtra("carPrice"));

        salesTaxRateTextView.setText(intent.getStringExtra("salesTaxRate") + "%");
        taxAmountTextView.setText(intent.getStringExtra("taxAmountRate"));
        downPaymentTextView.setText(intent.getStringExtra("downPayment"));
        totalCostTextView.setText(intent.getStringExtra("totalCost"));
        borrowedAmountTextView.setText(intent.getStringExtra("borrowedAmount"));
        interestAmountTextView.setText(intent.getStringExtra("interestAmount"));
        loanTermTextView.setText(intent.getStringExtra("loanTerm") + " years");

    }

    public void closeActivity(View v)
    {
        this.finish();
    }
}

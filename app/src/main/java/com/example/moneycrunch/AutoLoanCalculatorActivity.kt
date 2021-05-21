package com.example.moneycrunch

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moneycrunch.databinding.ActivityAutoLoanCalculatorBinding
import java.text.DecimalFormat


class AutoLoanCalculatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityAutoLoanCalculatorBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutoLoanCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.autoButton.setOnClickListener { calcLoans() }



    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.mi_refresh -> {
                calcLoans()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    fun calcLoans() {


        var loan = binding.autoAmountEdit.text.toString().toDouble()
        val intRate = binding.autoAprEdit.text.toString().toDouble()
        val payment = binding.autoPaymentEdit.text.toString().toDouble()
        val monthRadio = binding.radioMonths.isChecked
        val yearRadio = binding.radioYears.isChecked
        val currency = DecimalFormat("$###,###")


        val rate = (intRate/100.0)
        val cal = Calculator()
        val aRate = cal.getInterest(loan, rate, payment)
        val aMonths = cal.getMonths(loan, rate, payment)
        val aYears = cal.getYears(loan, rate, payment)
        val aPayoff = cal.getTotalAmount(loan, rate, payment)
        val aDate = cal.getDate(loan, rate, payment)
        val aminPayment = cal.getMinPayment(loan, intRate)

        if(TextUtils.isEmpty(intRate.toString())&& TextUtils.isEmpty(loan.toString()) && TextUtils.isEmpty(payment.toString())) {
            Toast.makeText(applicationContext, "Please enter the required values", Toast.LENGTH_SHORT).show()
        }


        if ( monthRadio && aMonths != 1) {
            binding.myDurationView.text = "Months"
            binding.myDurationResult.text = aMonths.toString()
        }
         if (yearRadio && (aMonths % 2.0 == 0.0)) {
            binding.myDurationView.text = "Years"
            binding.myDurationResult.text =  String.format("%.0f", aYears)
        }
         if (monthRadio && aMonths == 1){
            binding.myDurationView.text = "Month"
            binding.myDurationResult.text = aMonths.toString()

        }
         if (yearRadio && aYears == 1.0){
            binding.myDurationView.text = "Year"
            binding.myDurationResult.text = String.format("%.0f", aYears)

        }
        if (yearRadio && aYears < 1.0) {
            binding.myDurationView.text = "Years"
            binding.myDurationResult.text = "0"
        }
        binding.durationView.text = getString(R.string.duration_text)
        binding.aTotalAmount.text = getString(R.string.auto_total_amount)
        binding.durationDebt.text = getString(R.string.auto_debt_text)
        binding.interestView.text = getString(R.string.interest_text)
        binding.interestResultView.text = getString(R.string.interest_view_text)
        binding.finalPayoff.text = getString(R.string.auto_payoff_date)
        binding.interestResult.text = currency.format(aRate).toString()
        binding.autoTotalAmount.text = currency.format(aPayoff).toString()
        binding.autoPayoffDate.text = aDate.toString()




        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}
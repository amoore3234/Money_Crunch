package com.example.moneycrunch

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.moneycrunch.databinding.ActivityAutoLoanCalculatorBinding
import java.text.DecimalFormat


class AutoLoanCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAutoLoanCalculatorBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutoLoanCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.autoButton.setOnClickListener { calcLoans() }


    }


    private fun calcLoans() {


        val loan = binding.autoAmountEdit.text.toString().toDouble()
        val intRate = binding.autoAprEdit.text.toString().toDouble()
        val payment = binding.autoPaymentEdit.text.toString().toDouble()
        val monthRadio = binding.radioMonths.isChecked
        val yearRadio = binding.radioYears.isChecked
        val currency = DecimalFormat("$###,###")






            val rate = (intRate / 100.0)
            val cal = Calculator()
            val aRate = cal.getInterest(loan, rate, payment)
            val aMonths = cal.getMonths(loan, rate, payment)
            val aYears = cal.getYears(loan, rate, payment)
            val aPayoff = cal.getTotalAmount(loan, rate, payment)
            val aDate = cal.getDate(loan, rate, payment)
            val minPay = cal.getMinPayment(loan, intRate)





            if (monthRadio && aMonths != 1) {
                binding.myDurationView.text = getString(R.string.auto_months)
                binding.myDurationResult.text = aMonths.toString()
            }
            if (yearRadio && (aMonths % 2.0 == 0.0)) {
                binding.myDurationView.text = getString(R.string.auto_year)
                binding.myDurationResult.text = String.format("%.0f", aYears)
            }
            if (monthRadio && aMonths == 1) {
                binding.myDurationView.text = getString(R.string.auto_month)
                binding.myDurationResult.text = aMonths.toString()

            }
            if (yearRadio && aYears != 1.0) {
                binding.myDurationView.text = getString(R.string.auto_year)
                binding.myDurationResult.text = String.format("%.0f", aYears)

            }
            if (yearRadio && aYears < 1.0) {
                binding.myDurationView.text = getString(R.string.auto_years)
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
            binding.autoPayoffDate.text = aDate

            if (loan == 0.00 && intRate == 0.00 && payment == 0.00) {
                error()
            }
            if (loan == 0.00 || intRate == 0.00 ||  payment == 0.00) {
                error()
            }

            if (payment < minPay) {
                Toast.makeText(applicationContext, "Please enter values between ${currency.format(minPay)} and $$loan.", Toast.LENGTH_SHORT).show()

                binding.durationView.text = " "
                binding.aTotalAmount.text = " "
                binding.durationDebt.text = " "
                binding.interestView.text = " "
                binding.interestResultView.text = " "
                binding.finalPayoff.text = " "
                binding.interestResult.text = " "
                binding.autoTotalAmount.text = " "
                binding.autoPayoffDate.text = " "
                binding.myDurationView.text = " "
                binding.myDurationResult.text = " "
            }
        if (loan > 200000.00) {
            Toast.makeText(applicationContext, "Please enter values between ${currency.format(minPay)} and $200,000", Toast.LENGTH_SHORT).show()


            binding.durationView.text = " "
            binding.aTotalAmount.text = " "
            binding.durationDebt.text = " "
            binding.interestView.text = " "
            binding.interestResultView.text = " "
            binding.finalPayoff.text = " "
            binding.interestResult.text = " "
            binding.autoTotalAmount.text = " "
            binding.autoPayoffDate.text = " "
            binding.myDurationView.text = " "
            binding.myDurationResult.text = " "

        }

            val view = this.currentFocus
            if (view != null) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }

        }
    private fun error() {
        binding.durationView.text = " "
        binding.aTotalAmount.text = " "
        binding.durationDebt.text = " "
        binding.interestView.text = " "
        binding.interestResultView.text = " "
        binding.finalPayoff.text = " "
        binding.interestResult.text = " "
        binding.autoTotalAmount.text = " "
        binding.autoPayoffDate.text = " "
        binding.myDurationView.text = " "
        binding.myDurationResult.text = " "

        Toast.makeText(applicationContext, "Please enter the required values", Toast.LENGTH_SHORT).show()
    }

    }




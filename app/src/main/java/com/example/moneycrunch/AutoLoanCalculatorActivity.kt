package com.example.moneycrunch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
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

        val actionBar = supportActionBar


        actionBar!!.title = "Auto Loan Calculator"
        actionBar.setDisplayHomeAsUpEnabled(true)


        //Listening to text inputs.
        binding.autoAmountEdit.addTextChangedListener(textWatcher)
        binding.autoAprEdit.addTextChangedListener(maxInterest)
        binding.autoPaymentEdit.addTextChangedListener(minPayment)

        //Button to fire the calculator.
        binding.autoButton.setOnClickListener { calcLoans() }


    }

    //Inflator to create the options menu.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Menu where items can be selected.
    //Added the refresh and back buttons.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mi_refresh -> {
                autoLoanActivity()
                this.finish()
                return true
            }
            android.R.id.home -> {
                this.finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //Method to to use the calculator.
    private fun calcLoans() {

        //Initializes the inputs within the app.
        val loan = binding.autoAmountEdit.text.toString().toDouble()
        val intRate = binding.autoAprEdit.text.toString().toDouble()
        val payment = binding.autoPaymentEdit.text.toString().toDouble()
        val monthRadio = binding.radioMonths.isChecked
        val yearRadio = binding.radioYears.isChecked
        val currency = DecimalFormat("$###,###.##")

        //Initializes methods within the Calculator class.
        val rate = (intRate / 100.0)
        val cal = Calculator()
        val aRate = cal.getInterest(loan, rate, payment)
        val aMonths = cal.getMonths(loan, rate, payment)
        val aYears = cal.getYears(loan, rate, payment)
        val aPayoff = cal.getTotalAmount(loan, rate, payment)
        val aDate = cal.getDate(loan, rate, payment)




        //Check if the user selected months or years.
        if (monthRadio && aMonths != 1) {
            binding.myDurationView.text = getString(R.string.auto_months)
            binding.myDurationResult.text = aMonths.toString()
        }
        if (yearRadio && (aMonths % 2.0 == 0.0)) {
            binding.myDurationView.text = getString(R.string.auto_years)
            binding.myDurationResult.text = String.format("%.1f", aYears)
        }
        if (monthRadio && aMonths == 1) {
            binding.myDurationView.text = getString(R.string.auto_month)
            binding.myDurationResult.text = aMonths.toString()

        }
        if (yearRadio && aYears != 1.0) {
            binding.myDurationView.text = getString(R.string.auto_years)
            binding.myDurationResult.text = String.format("%.1f", aYears)

        }
        if (yearRadio && aYears == 1.0) {
            binding.myDurationView.text = getString(R.string.auto_year)
            binding.myDurationResult.text = String.format("%.0f", aYears)
        }
        if (yearRadio && aYears < 1.0) {
            binding.myDurationView.text = getString(R.string.auto_years)
            binding.myDurationResult.text = "0"
        }

        //Prints the results within Text Views
        binding.durationView.text = getString(R.string.duration_text)
        binding.aTotalAmount.text = getString(R.string.auto_total_amount)
        binding.durationDebt.text = getString(R.string.auto_debt_text)
        binding.interestView.text = getString(R.string.interest_text)
        binding.interestResultView.text = getString(R.string.interest_view_text)
        binding.finalPayoff.text = getString(R.string.auto_payoff_date)
        binding.interestResult.text = currency.format(aRate).toString()
        binding.autoTotalAmount.text = currency.format(aPayoff).toString()
        binding.autoPayoffDate.text = aDate

        //Checks if the user enters zeros in the input fields.
        if (loan == 0.00 && intRate == 0.00 && payment == 0.00) {
            error()
        }
        if (loan == 0.00 || intRate == 0.00 || payment == 0.00) {
            error()
        }

        //Hides keypad once button is clicked.
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

    //A method to display null results.
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

    //TextWatchers were implemented to validate user inputs. Disables button when inputs are empty.
    /*TextWatcher object that checks if the loan amount is less than 200,000
    * then places a zero in the input.*/
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

            val number = s.toString().toIntOrNull()

            if (number != null) {
                if (number > 80000) {
                    if (s != null) {
                        s.replace(0, s.length, "0")
                        Toast.makeText(applicationContext, "Please enter values between $0 and $200,000", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }


        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val loanString = binding.autoAmountEdit.text.toString()
            val intString = binding.autoAprEdit.text.toString()
            val paymentString = binding.autoPaymentEdit.text.toString()

            binding.autoPaymentEdit.isEnabled = !TextUtils.isEmpty(loanString) && loanString != "0"

            binding.autoButton.isEnabled = !TextUtils.isEmpty(loanString) && !TextUtils.isEmpty(intString) && !TextUtils.isEmpty(paymentString)
        }

    }

    /*TextWatcher that checks if the interest rate is less than 15
    * then places a zero in the input.*/
    private val maxInterest = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

            val number = s.toString().toIntOrNull()

            if (number != null) {
                if (number > 15) {
                    if (s != null) {
                        s.replace(0, s.length, "0")
                        Toast.makeText(applicationContext, "Please enter values between 0 and 15", Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }


        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val loanString = binding.autoAmountEdit.text.toString()
            val intString = binding.autoAprEdit.text.toString()
            val paymentString = binding.autoPaymentEdit.text.toString()


            binding.autoButton.isEnabled = !TextUtils.isEmpty(loanString) && !TextUtils.isEmpty(intString) && !TextUtils.isEmpty(paymentString)
        }

    }

    /*TextWatcher that checks if the payment amount is less than the
    * minimum payment. Button remains disabled until minimum amount is satisfied.*/
    private val minPayment = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            val loan = binding.autoAmountEdit.text.toString().toDouble()
            val intRate = binding.autoAprEdit.text.toString().toDouble()
            val cal = Calculator()
            val pay = cal.getMinPayment(loan, intRate)
            val currency = DecimalFormat("$###,###.##")

            val number = s.toString().toIntOrNull()

            if (number != null) {
                if (number < pay) {
                    binding.autoButton.isEnabled = false
                    if (s != null && s.length < 3) {
                        Toast.makeText(applicationContext, "Please enter values between ${currency.format(pay)}  and ${currency.format(loan)}.", Toast.LENGTH_SHORT).show()
                        binding.autoButton.isEnabled = false
                    }

                }

            }


        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }


        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val loanString = binding.autoAmountEdit.text.toString()
            val intString = binding.autoAprEdit.text.toString()
            val paymentString = binding.autoPaymentEdit.text.toString()


            binding.autoButton.isEnabled = !TextUtils.isEmpty(loanString) && !TextUtils.isEmpty(intString) && !TextUtils.isEmpty(paymentString)
        }

    }

    //Method to restart the app.
    private fun autoLoanActivity() {
        val intent = Intent(this, AutoLoanCalculatorActivity::class.java)

        startActivity(intent)
    }


}




package com.example.moneycrunch

//Calculator class to access methods for calculation purposes.
class Calculator {


    private var stringDate:String = "Date"

    //Method to calculate the life of the loan.
    fun getDate(loan:Double, intRate:Double, payment:Double): String {
            val dpr = ((intRate / 365) * 30.417)
            var monthlyInterest: Double
            var months = 0
            var interest = 0.0
            var finalBalance: Double
            var principle = 0.0
            var balance = loan

            while (principle < payment) {
                monthlyInterest = (balance * dpr)
                principle = payment - monthlyInterest
                finalBalance = balance - principle
                balance = finalBalance
                interest += monthlyInterest
                if (principle > payment) {
                    val date = GetDate(months)
                    stringDate = date.payOffDate()
                    break
                }
                months++
            }
        return stringDate
    }


    //Method to calculate the total interest accumulated.
    fun getInterest(loan:Double, intRate:Double, payment:Double): Double {
        val dpr = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest = 0.00
        var finalBalance: Double
        var principle = 0.0
        var balance = loan

        while (principle < payment) {
            monthlyInterest = (balance * dpr)
            principle = payment - monthlyInterest
            finalBalance = balance - principle
            balance = finalBalance
            interest += monthlyInterest
            if (principle > payment) {
                val date = GetDate(months)
                stringDate = date.payOffDate()
                break
            }
            months++
        }
        return interest
    }


    //Method that returns the number of months till payoff.
    fun getMonths(loan:Double, intRate:Double, payment:Double): Int {
        val dpr = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest  = 0.00
        var finalBalance: Double
        var principle  = 0.0
        var balance = loan

        while (principle < payment) {
            monthlyInterest = (balance * dpr)
            principle = payment - monthlyInterest
            finalBalance = balance - principle
            balance = finalBalance
            interest += monthlyInterest
            if (principle > payment) {
                val date = GetDate(months)
                stringDate = date.payOffDate()
                break
            }

            months++
        }
        return months
    }


    //Method that calculates the number of years till payoff.
    fun getYears(loan:Double, intRate:Double, payment:Double): Double {
        val dpr = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest = 0.00
        var finalBalance: Double
        var principle = 0.0
        var balance = loan

        while (principle < payment) {
            monthlyInterest = (balance * dpr)
            principle = payment - monthlyInterest
            finalBalance = balance - principle
            balance = finalBalance
            interest += monthlyInterest
            if (principle > payment) {
                val date = GetDate(months)
                stringDate = date.payOffDate()
                break
            }
            months++
        }
        return (months/12.0)
    }


    //Method to calculate the total interest accumulated plus the loan amount.
    fun getTotalAmount(loan:Double, intRate:Double, payment:Double): Double {
        val dpr = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest  = 0.00
        var finalBalance: Double
        var principle = 0.0
        var balance = loan

        while (principle < payment) {
            monthlyInterest = (balance * dpr)
            principle = payment - monthlyInterest
            finalBalance = balance - principle
            balance = finalBalance
            interest += monthlyInterest
            if (principle > payment) {
                val date = GetDate(months)
                stringDate = date.payOffDate()
                break
            }
            months++
        }
        return interest + loan
    }

    //Calculates the minimum payment.
    fun getMinPayment(loan: Double, intRate: Double): Double {
        val monthlyRate = (intRate/365) * 30.417
        val interest: Double
        val finalPay: Double

        val minPayment: Double = loan * .01

        interest = minPayment * monthlyRate

        finalPay = minPayment + interest

        return finalPay
    }

}
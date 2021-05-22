package com.example.moneycrunch

class Calculator (

) {

    private var stringDate:String = "Date"

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
        return (months/12.0).toDouble()
    }

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

    fun getMinPayment(loan: Double, intRate: Double): Double {
        val monthlyRate = ((intRate/365) * 30.417)
        var minPayment = 0.0

        minPayment = (loan * .01) + monthlyRate

        return minPayment
    }

}
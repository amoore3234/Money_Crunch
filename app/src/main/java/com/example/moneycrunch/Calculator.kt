package com.example.moneycrunch

class Calculator (

) {

    private var stringDate:String = "Date"

    fun getDate(loan:Double, intRate:Double, payment:Double): String {
            var dpr: Double = ((intRate / 365) * 30.417)
            var monthlyInterest: Double
            var months = 0
            var interest: Double = 0.00
            var finalBalance: Double = 0.0
            var principle: Double = 0.0
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
                    balance = 0.0
                    break
                }
                months++
            }
        return stringDate
    }

    fun getInterest(loan:Double, intRate:Double, payment:Double): Double {
        var dpr: Double = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest: Double = 0.00
        var finalBalance: Double = 0.0
        var principle: Double = 0.0
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
                balance = 0.0
                break
            }
            months++
        }
        return interest
    }
    fun getMonths(loan:Double, intRate:Double, payment:Double): Int {
        var dpr: Double = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest: Double = 0.00
        var finalBalance: Double = 0.0
        var principle: Double = 0.0
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
                balance = 0.0
                break
            }
            months++
        }
        return months
    }

    fun getYears(loan:Double, intRate:Double, payment:Double): Double {
        var dpr: Double = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest: Double = 0.00
        var finalBalance: Double = 0.0
        var principle: Double = 0.0
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
                balance = 0.0
                break
            }
            months++
        }
        return (months/12.0).toDouble()
    }

    fun getTotalAmount(loan:Double, intRate:Double, payment:Double): Double {
        var dpr: Double = ((intRate / 365) * 30.417)
        var monthlyInterest: Double
        var months = 0
        var interest: Double = 0.00
        var finalBalance: Double = 0.0
        var principle: Double = 0.0
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
                balance = 0.0
                break
            }
            months++
        }
        return interest + loan
    }

    fun getMinPayment(loan: Double, intRate: Double): Double {
        var monthlyRate = ((intRate/365) * 30.417)
        var minPayment = 0.0

        minPayment = (loan * .01) + monthlyRate

        return minPayment
    }

}
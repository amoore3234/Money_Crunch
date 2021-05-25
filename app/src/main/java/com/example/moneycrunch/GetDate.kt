package com.example.moneycrunch

import java.text.DateFormat
import java.util.*

//Class that calculates the current date.
class GetDate(private val getMonth: Int) {

    private lateinit var formatFuture: String

    fun payOffDate() : String {

        val finalDate = getMonth
        val calendar: Calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, finalDate + 1)
        calendar.add(Calendar.YEAR, 0)
        val future: Date = calendar.time
         formatFuture = DateFormat.getDateInstance().format(future)

        return formatFuture
    }

}
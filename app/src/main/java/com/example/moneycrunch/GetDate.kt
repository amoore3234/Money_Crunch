package com.example.moneycrunch

import java.text.DateFormat
import java.util.*

class GetDate(private val getMonth: Int) {

    lateinit var formatFuture:String

    fun payOffDate() : String {

        val finalDate = getMonth
        val calendar: Calendar = Calendar.getInstance()
        val dateTime: Date = calendar.getTime()
        calendar.add(Calendar.MONTH, finalDate + 1)
        calendar.add(Calendar.YEAR, 0)
        val future: Date = calendar.getTime()
         formatFuture = DateFormat.getDateInstance().format(future)

        return formatFuture
    }

}
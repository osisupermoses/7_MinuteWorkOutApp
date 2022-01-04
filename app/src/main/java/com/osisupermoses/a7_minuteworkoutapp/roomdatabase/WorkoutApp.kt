package com.osisupermoses.a7_minuteworkoutapp.roomdatabase

import android.app.Application

class WorkoutApp : Application() {
    val db by lazy {
        HistoryDatabase.getInstance(this)
    }
}
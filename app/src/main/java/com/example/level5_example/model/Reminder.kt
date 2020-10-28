package com.example.level5_example.model

import androidx.room.*

/** Data class called Reminder which has a String representing the reminder **/
@Entity(tableName = "reminderTable")
data class Reminder(

    @ColumnInfo(name = "reminder")
    var reminderText: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)

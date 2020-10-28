package com.example.level5_task1.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.level5_task1.model.Note
import com.example.level5_task1.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotepadViewModel(application: Application): AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val reminderRepository = NoteRepository(application.applicationContext)

    val reminders: LiveData<List<Note>> = reminderRepository.getAllReminders()

    fun insertReminder(reminder: Note) {
        ioScope.launch {
            reminderRepository.insertReminder(reminder)
        }
    }

    fun deleteReminder(reminder: Note) {
        ioScope.launch {
            reminderRepository.deleteReminder(reminder)
        }
    }
}
package com.yasinsenel.jetnote.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.yasinsenel.jetnote.data.NoteData
import com.yasinsenel.jetnote.model.Note

class NotesViewModel : ViewModel() {
    private var noteList = mutableStateListOf<Note>()

    init{
        noteList.addAll(NoteData().loadNotes())
    }

    fun addNote(note : Note){
        noteList.add(note)
    }

    fun removeNote(note : Note){
        noteList.remove(note)
    }

    fun getAllNotes() : List<Note>{
        return noteList
    }
}
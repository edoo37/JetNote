package com.yasinsenel.jetnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yasinsenel.jetnote.model.Note
import com.yasinsenel.jetnote.screens.NoteScreen
import com.yasinsenel.jetnote.screens.NotesViewModel
import com.yasinsenel.jetnote.ui.theme.JetNoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNoteTheme {

                Surface(color = MaterialTheme.colors.background) {
                    NotesApp()
                }
            }
        }
    }
}

@Composable
fun NotesApp(notesViewModel: NotesViewModel = viewModel()) {
    val notes = notesViewModel.getAllNotes()
    NoteScreen(notes = notes,
        onAddNote = {
            notesViewModel.addNote(it)
        },
        onRemoveNote = {
            notesViewModel.removeNote(it)
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNoteTheme {
        val notes = remember{
            mutableListOf<Note>()
        }
        NoteScreen(notes,
            onAddNote = {notes.add(it)},
            onRemoveNote = {notes.remove(it)})
    }
}
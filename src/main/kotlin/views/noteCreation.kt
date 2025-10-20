package views
import model.archiveModel
import model.noteModel
import utils.utils

class noteCreation () {
    private val notes = mutableListOf<noteModel>()
    private var idx: Int = 1

    fun createNote() {
        println("Укажите название заметки:")
        val noteTitle = utils().userInputText()
        println("Укажите содержание заметки:")
        val noteBody = utils().userInputText()
        notes.add(noteModel(noteTitle, noteBody))
        println ("Заметка ${noteTitle} добавлена.")
    }
    fun showNotesList() {
        if (notes.isEmpty()) {
            println("Заметок не найдено")
        } else {
            println("Список заметки:")
            notes.forEachIndexed { index, notesModel -> println("${index + 1}. ${notesModel.title}") }
            idx = notes.size + 1
            println("${idx}. Назад")
            showNote(notes[utils().menuUserInput() - 1])
        }
    }

    fun showNote(note: noteModel) {
        while(true) {
            println("Заметка: ${note.title}")
            println("${note.body}")
            println("0. Изменить текст заметки")
            println("1. Назад")

            when(utils().menuUserInput()){
                0 -> changeNoteBody(note)
                1 -> showNotesList()
            }
        }
    }
    private fun changeNoteBody(note: noteModel){
        note.body = utils().userInputText()
    }
}
import model.archiveModel
import kotlin.system.exitProcess
import utils.utils
import views.noteCreation

class SelectArchive() {
    private val archives = mutableListOf<archiveModel>()

    private var idx: Int = 1
    fun showMenu(){
        while (true) {
            println("Список Архивов:")
            println("0. Создать архив")
            println("1. Вывести список архивов")
            println("2. Выход")

            while (true){
                when (utils().menuUserInput()){
                    0 -> createArch()
                    1 -> showArchList()
                    2 -> exitProcess(0)
                    else -> println("Введите корректное значение")
                }
            }

        }
    }
    private fun createArch(){
        println("Введите имя для архива:")
        val archTitle = utils().userInputText()
        if (archTitle.isBlank()) {
            println("Имя архива не может быть пустым")
        } else {
           archives.add(archiveModel(archTitle))
            println("Архив ${archTitle} успешно создан")
            showMenu()
        }
    }
    private fun showArchList() {
        if (archives.isEmpty()) {
            println("Список архивов пуст")
        } else {
            println("Список архивов:")
            archives.forEachIndexed { index, archiveModel -> println("${index + 1}. ${archiveModel.title}") }
            idx = archives.size + 1
            println("${idx}. Назад")
            println("Выберите архив...:")
            viewArch(archives[utils().menuUserInput() - 1])

        }
    }

    private fun viewArch(archive: archiveModel){
        while (true){
            println("Архив: ${archive.title}")
            println("0. Создать заметку")
            println("1. Просмтотр заметок")
            println("2. Назад")

            when(utils().menuUserInput()){
                0 -> noteCreation().createNote()
                1 -> noteCreation().showNotesList()
                2 -> showArchList()
                else -> println("Введите корректное значение")
            }
        }
    }

}
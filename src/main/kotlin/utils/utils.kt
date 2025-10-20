package utils
import java.util.Scanner

class utils {
    val scanner = Scanner(System.`in`)

    fun menuUserInput(): Int {
        var userInput = scanner.nextLine().toIntOrNull()
        while (userInput == null) {
            println("Введите число")
            userInput = readLine()?.toIntOrNull()
        }
        return userInput
    }

    fun userInputText(): String{
        val userInput = readlnOrNull()?:""
        if (userInput.isBlank()){
            println("Значение не может быть пустым")
        }
        return  userInput
    }
}

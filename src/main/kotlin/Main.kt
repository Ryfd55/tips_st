fun main() {
    var bill: Double? = null
    var numberOfGuests: Int? = null
    var tipAsPercent: Double? = null
    var input: String?

    while (bill == null) {
        println("Какая сумма в чеке?")
        input = readlnOrNull()
        bill = try {
            input?.toDouble()
        } catch (e: NumberFormatException) {
            println("Некорректный ввод. Попробуйте еще раз")
            null
        }
        if (bill != null) {
            if (bill <= 0.0) {
                println("Счет должен быть больше нуля")
                bill = null
            }
        }
    }

    while (numberOfGuests == null) {
        println("2. Введите количество гостей?")
        input = readlnOrNull()
        numberOfGuests = try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            println("Некорректный ввод. Попробуйте еще раз")
            null
        }
        if (numberOfGuests != null) {
            if (numberOfGuests <= 1) {
                println("Количество гостей не может быть меньше одного")
                numberOfGuests = null
            }
        }
    }

    while (tipAsPercent == null) {
        println("3. Сколько оставляем чаевые (в процентах)?")
        input = readlnOrNull()
        tipAsPercent = try {
            input?.toDouble()
        } catch (e: NumberFormatException) {
            println("Некорректный ввод. Попробуйте еще раз")
            null
        }
        if (tipAsPercent != null) {
            if (tipAsPercent < 0.0) {
                println("Размер чаевых не может быть меньше нуля")
                tipAsPercent = null
            }
        }
    }
    if (tipAsPercent == 0.0) {
        println("Жаль, что Вам не понравилось наше обслуживание!")
    } else {
        if (tipAsPercent > 10) {
            println("Мы рады, что Вам понравилось наше обслуживание!")
        } else {
            println("Спасибо! Будем рады видеть Вас снова!")
        }
    }

    val tips = bill * tipAsPercent.toFloat()   // размер чаевых в евроцентах
    val totalToPay = bill * 100 + tips // счет + чаевые в евроцентах
    // вклад с человека в евроцентах. Привожу к toInt, чтобы лишние знаки после запятой не получились:
    val eachPersonsContributionInCent = totalToPay.toInt() / numberOfGuests
    val eachPersonsContributionInEuro = eachPersonsContributionInCent.toFloat() / 100  // приведение в евро
    println("А пока с каждого по $eachPersonsContributionInEuro евро")
}R
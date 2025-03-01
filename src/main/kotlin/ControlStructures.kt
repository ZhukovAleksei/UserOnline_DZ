fun main() {
    println(agoToText(60 + 1))
}

fun agoToText(seconds: Int): String {
    when (seconds) {
        in 0..60 -> return "был(а) только что"
        in 61..(60 * 60) -> return "был(а) " + minutes(seconds)
        in ((60 * 60) + 1)..((60 * 60) * 24) -> return "был(а) " + hours(seconds)
        in ((60 * 60) * 24)..((60 * 60) * 48) -> return "был(а) вчера"
        in ((60 * 60) * 48)..((60 * 60) * 72) -> return "был(а) позавчера"
        else -> return "был(а) давно"
    }
}

fun minutes(seconds: Int): String {
    var minutes = seconds / 60

    return when {
        minutes == 11 || minutes == 12 || minutes == 13 || minutes == 14 || minutes == 15 || minutes == 16 || minutes == 17 || minutes == 18 || minutes == 19 -> {
            "$minutes минут назад"
        }

        minutes % 10 == 1 -> {
            "$minutes минуту назад"
        }

        minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4 -> {
            "$minutes минуты назад"
        }

        minutes == 60 -> {
            "час назад"
        }

        minutes % 10 == 5 || minutes % 10 == 6 || minutes % 10 == 7 || minutes % 10 == 8 || minutes % 10 == 9 || minutes % 10 == 0 -> {
            "$minutes минут назад"
        }

        else -> {
            ""
        }
    }
}

fun hours(seconds: Int): String {
    var hours = seconds / (60 * 60)
    return when (hours) {
        1, 21 -> "$hours час назад"
        2, 3, 4, 22, 23, 24 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

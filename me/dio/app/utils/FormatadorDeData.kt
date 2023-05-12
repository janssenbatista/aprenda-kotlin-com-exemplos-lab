package me.dio.app.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object FormatadorDeData {
    fun formatarData(padrao: String = "dd/MM/yyyy", data: LocalDate): String {
        return data.format(DateTimeFormatter.ofPattern(padrao))
    }
}

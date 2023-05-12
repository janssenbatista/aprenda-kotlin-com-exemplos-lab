package me.dio.app.models

import me.dio.app.utils.FormatadorDeData
import java.time.Duration
import java.time.LocalDate

data class ConteudoEducacional(
    val nome: String,
    val duration: Duration = Duration.ofMinutes(60)
) {

    val dataDeCriacao: LocalDate = LocalDate.now()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ConteudoEducacional
        return nome == other.nome
    }

    override fun hashCode(): Int {
        return nome.hashCode()
    }

    override fun toString(): String {
        return "ConteudoEducacional(" +
                "nome='$nome', " +
                "duração=${duration.toMinutes()} minutos, " +
                "dataDeCriacao=${FormatadorDeData.formatarData(data = dataDeCriacao)}" +
                ")"
    }


}

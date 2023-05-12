package me.dio.app.models

import me.dio.app.utils.FormatadorDeData
import java.time.LocalDate

data class Usuario(private val nome: String, private val idade: Byte) {
    private val numeroDaMatricula = contador++
    private val dataInscricao: LocalDate = LocalDate.now()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Usuario
        return nome == other.nome
    }

    override fun hashCode(): Int {
        return nome.hashCode()
    }

    override fun toString(): String {
        return "Usuario(nome='$nome', idade='$idade', numeroDaMatricula=$numeroDaMatricula, " +
                "dataInscricao=${FormatadorDeData.formatarData(data = this.dataInscricao)})"
    }

    companion object {
        var contador = 0
    }
}

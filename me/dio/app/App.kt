package me.dio.app

import me.dio.app.exceptions.UsuarioJaInscritoException
import me.dio.app.models.ConteudoEducacional
import me.dio.app.models.Formacao
import me.dio.app.models.Usuario
import java.time.Duration

fun main() {
    val usuario1 = Usuario("Usuário 1", 42)
    val usuario2 = Usuario("Usuário 2", 38)
    val usuario3 = Usuario("Usuário 3", 16)

    val conteudoEducacional1 = ConteudoEducacional("Conteudo Educacional 1", Duration.ofMinutes(15))
    val conteudoEducacional2 = ConteudoEducacional("Conteudo Educacional 2", Duration.ofMinutes(22))
    val conteudoEducacional3 = ConteudoEducacional("Conteudo Educacional 3", Duration.ofMinutes(10))
    val conteudoEducacional4 = ConteudoEducacional("Conteudo Educacional 4", Duration.ofMinutes(30))
    val conteudoEducacional5 = ConteudoEducacional("Conteudo Educacional 5")

    val formacao1 = Formacao("Formação 1", listOf(conteudoEducacional1, conteudoEducacional3))
    val formacao2 = Formacao(
        "Formação 2",
        listOf(conteudoEducacional2, conteudoEducacional4, conteudoEducacional5)
    )

    try {
        formacao1.matricularUsuarios(usuario1, usuario2)
    } catch (e: UsuarioJaInscritoException) {
        System.err.println(e.message)
    }

    // Simulando um erro ao tentar inserir usuários já matriculados na formação
    try {
        formacao1.matricularUsuarios(usuario1, usuario2)
    } catch (e: UsuarioJaInscritoException) {
        System.err.println(e.message)
    }

    try {
        formacao2.matricularUsuarios(usuario1, usuario3)
    } catch (e: UsuarioJaInscritoException) {
        System.err.println(e.message)
    }

    println(formacao1)
    println(formacao2)
}
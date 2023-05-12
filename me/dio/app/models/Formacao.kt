package me.dio.app.models

import me.dio.app.exceptions.UsuarioJaInscritoException

data class Formacao(
    private val nome: String,
    private val conteudos: Collection<ConteudoEducacional>
) {

    private val inscritos = mutableListOf<Usuario>()


    override fun toString(): String {
        return """Nome da Formação: $nome
            Conteúdos: $conteudos
            Usuários Inscritos: $inscritos
        """.trimIndent()
    }

    @Throws(UsuarioJaInscritoException::class)
    fun matricularUsuarios(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            if (inscritos.contains(usuario))
                throw UsuarioJaInscritoException("Usuário ${usuario}já inscrito na Formação.")
            else
                inscritos.add(usuario)
        }
    }

}

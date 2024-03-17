package one.digitalinovation.avengers.avengers.api.application.web.request

import jakarta.validation.constraints.NotNull
import one.digitalinovation.avengers.avengers.api.dominio.avenger.Avenger

data class AvengerRequest(
        @field:NotNull
        @field:NotNull
        val id: String,
        val name: String
){

    fun to() = Avenger(
            id.toLong(),name
    )
    companion object{
       fun to(id: Long,request: AvengerRequest) = Avenger(
                id = id,
               name = request.name
        )
    }
}


package one.digitalinovation.avengers.avengers.api.application.web.response
import one.digitalinovation.avengers.avengers.api.dominio.avenger.Avenger
data class AvengerResponse(
        val id: String,
        val name: String
){
    companion object {


        fun from(avenger: Avenger) = AvengerResponse(
                id = avenger.id.toString(), name = avenger.name
        )
    }
}

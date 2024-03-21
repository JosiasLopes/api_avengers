package one.digitalinovation.avengers.avengers.api.resources.avenger

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import one.digitalinovation.avengers.avengers.api.dominio.avenger.Avenger

@Entity(name="Avenger")
data class AvengerEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Long?=null,

        @Column(nullable = false, name="name", length = 35)
        val name:String
){
    fun toAvenger() = Avenger(
            id, name
    )
    companion object{
        fun from(avenger:Avenger) = AvengerEntity(
                id = avenger.id,
            name = avenger.name
        )
    }
}

package one.digitalinovation.avengers.avengers.api.application.web.resource


import jakarta.validation.Valid
import one.digitalinovation.avengers.avengers.api.application.web.request.AvengerRequest
import one.digitalinovation.avengers.avengers.api.application.web.response.AvengerResponse
import one.digitalinovation.avengers.avengers.api.dominio.avenger.AvengerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping(value = ["/v1/api/avengers"])
class AvengerResource (
        @Autowired private val repository:AvengerRepository
){

    //Essa classe faz a relação com o recurso Avenger
    //basicamente é a classe controller

    @GetMapping
    fun getAvengers()= repository.getAvengers().map{
        AvengerResponse.from(it)

    }.  let{
        ResponseEntity.ok().body(it)
    }


    @GetMapping("{id}")
    fun getAvenger(@PathVariable(value ="id") id:Long) =
            repository.getDetail(id)?.let {
                ResponseEntity.ok().body(it.let { it1 -> AvengerResponse.from(it1) })
            }?:ResponseEntity.notFound().build<Void>()





    //requestBody é u corpo da requisicao e ele faz um parse com avengerRequest
    @PostMapping
    fun createAvenger(@Valid @RequestBody request: AvengerRequest) =
            request.to().run {
                repository.createAvenger(this)
            }.let {
                ResponseEntity.created(URI("/v1/api/avengers/${it.id}")).body(AvengerResponse.from(it))
            }

    @PutMapping("{id")
    fun updateAvenger(@Valid @RequestBody request: AvengerRequest, @PathVariable(value ="id") id:Long) =
            repository.getDetail(id)?.let {
                it.id?.let { it1 ->
                    AvengerRequest.to(it1,request).apply {
                        repository.update(this)
                    }.let { avenger->
                    ResponseEntity.ok().body(AvengerResponse.from(avenger))
                    }
                }
            }?:ResponseEntity.notFound().build<Void>()

    @DeleteMapping("{id}")
    fun deleteAvenger(@PathVariable(value ="id") id: Long)=
            repository.delete(id).let{
                ResponseEntity.accepted().build<Void>()
            }

}
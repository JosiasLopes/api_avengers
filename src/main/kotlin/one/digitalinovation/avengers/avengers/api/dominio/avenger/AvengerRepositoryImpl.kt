package one.digitalinovation.avengers.avengers.api.dominio.avenger

import one.digitalinovation.avengers.avengers.api.resources.avenger.AvengerEntity
import one.digitalinovation.avengers.avengers.api.resources.avenger.AvengerEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component


@Component
//Essa classe é a implementação dos metodos listados na interface AvengerRepository
//Na arctetura Hexagonal utilizamos o conceito de portas de entrada e saida
//na camada de dominio criamos a interface
//ja na camada de infraestrutura nos implementamos essa interface
class AvengerRepositoryImpl(
        @Autowired private val avRepo: AvengerEntityRepository

) :AvengerRepository{
    override fun getDetail(id: Long): Avenger?  =
            avRepo.findByIdOrNull(id)?.copy(id)

    override fun getAvengers(): List<Avenger> =
            avRepo.findAll().map { it.copy()}.let { it }

    override fun createAvenger(avenger: Avenger): Avenger {
        val tmp = avenger
        val toAvenger = avRepo.save(AvengerEntity.from(tmp).toAvenger())
        return toAvenger
    }

    override fun delete(id: Long) = avRepo.deleteById(id)

    override fun update(avenger: Avenger): Avenger {
        val tmp = avenger
        val toAvenger = avRepo.save(AvengerEntity.from(tmp).toAvenger())
        return toAvenger
    }

}


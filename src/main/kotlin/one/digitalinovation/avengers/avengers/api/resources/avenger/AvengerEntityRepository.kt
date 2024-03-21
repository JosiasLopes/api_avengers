package one.digitalinovation.avengers.avengers.api.resources.avenger

import one.digitalinovation.avengers.avengers.api.dominio.avenger.Avenger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AvengerEntityRepository : JpaRepository<Avenger,Long>{
}
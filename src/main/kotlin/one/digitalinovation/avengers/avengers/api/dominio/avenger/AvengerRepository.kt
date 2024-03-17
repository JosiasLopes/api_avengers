package one.digitalinovation.avengers.avengers.api.dominio.avenger

interface AvengerRepository {

    fun getDetail(id:Long):Avenger?
    fun getAvengers():List<Avenger>

    fun createAvenger(avenger: Avenger):Avenger

    fun delete(id:Long)

    fun update(avenger: Avenger):Avenger
}
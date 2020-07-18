package ar.edu.unahur.obj2.vendedores

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VendedorTest {
  val misiones = Provincia(1300000)
  val cordoba = Provincia(2000000)
  val sanIgnacio = Ciudad(misiones)
  val obera = Ciudad(misiones)
  val villaDolores = Ciudad(cordoba)
  val vendedorFijo = VendedorFijo(obera)
  val viajante = Viajante(listOf(misiones))

  @Test
  fun `Puede trabajar en su ciudad de origen`() {
    assertTrue(vendedorFijo.puedeTrabajarEn(obera))
  }
  @Test
  fun `No puede trabajar en una ciudad donde no vive`() {
    assertFalse(vendedorFijo.puedeTrabajarEn(sanIgnacio))
  }

  @Test
  fun `Puede trabajar en una ciudad que pertenece a una provincia habilitada`() {
    assertTrue(viajante.puedeTrabajarEn(sanIgnacio))
    assertTrue(viajante.puedeTrabajarEn(obera))
  }
  @Test
  fun `No puede trabajar en una ciudad que no pertenece a una provincia habilitada`() {
    assertFalse(viajante.puedeTrabajarEn(villaDolores))
  }
}

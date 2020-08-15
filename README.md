# Vendedores y centros de distribución

Este ejercicio es un recorte de un [ejercicio de la materia Programación con Objetos 1](https://github.com/obj1-unahur/vendedores_2019s2), puede consultarse el enunciado completo en ese link.

Como el objetivo es familiarizarse con Kotlin, vale _inspirarse_ de la versión Wollok. Si no lo encuentran o no lo tienen, pueden buscar inspiración entre [los repos de estudiantes del segundo cuatrimestre 2019](https://github.com/obj1-unahur-2019s2?q=vendedores)... o pueden pensarlo de nuevo, tampoco es tan difícil. :smirk:

Se pide resolver el enunciado que está a continuación, incluyendo los tests (como salgan). Les dejamos una pequeña parte resuelta para que no les sea tan complicado familiarizarse con Kotlin. 

## Enunciado

López y López es una empresa de distribución de productos de consumo masivo, que se distribuyen en ciudades repartidas por toda la geografía nacional. 

Su organización está basada en **centros de distribución**. Cada centro trabaja con distintos **vendedores**.

Se nos pide desarrollar un modelo de los centros, los vendedores, y la relación entre ellos.


### Vendedores
López y López recluta vendedores de tres tipos:
- **Vendedor fijo**: se sabe en qué ciudad vive.
- **Viajante**: cada viajante está habilitado para trabajar en algunas provincias, se sabe cuáles son.
- **Comercio corresponsal**: son comercios que tienen sucursales en distintas ciudades. Se sabe, para cada comercio corresponsal, en qué ciudades tiene sucursales.

De cada ciudad debemos registrar en qué provincia está, y de cada provincia, la población.

De cada vendedor, se tiene detalle de las **certificaciones** que posee.
Cada certificación otorga una cantidad de _puntos_. Algunas certificaciones son sobre productos, otras no. 

Desarrollar un modelo de vendedores que permita consultar:
- dada una ciudad, si un vendedor _puede trabajar_ en esa ciudad. La condición depende del tipo de vendedor, como se indica a continuación
	- _vendedor fijo_: debe ser la ciudad en la que vive.
	- _viajante_: la ciudad debe estar en una provincia en la que está habilitado.
	- _comercio corresponsal_: debe ser una ciudad en la que tiene sucursal.
- si un vendedor _es versátil_. Las condiciones son: que tenga al menos tres certificaciones, que tenga al menos una sobre productos, y al menos una que no sea sobre productos.
- si un vendedor _es firme_. La condición es que el puntaje total que le otorgan sus certificaciones sea mayor o igual a 30.

### Vendedor influyente
Agregar al modelo la capacidad de indicar si un vendedor _es influyente_. La condición depende del tipo de vendedor:
- _vendedor fijo_: ningún vendedor fijo es influyente.
- _viajante_: la población total sumando todas las provincias donde está habilitado, debe ser de 10 millones o superior.
- _comercio corresponsal_: debe tener sucursales en al menos 5 ciudades, o bien en al menos 3 provincias considerando la provincia de cada ciudad donde tiene sucursal.

P.ej. un comercio corresponsal que tenga sucursales en
- Chivilcoy, Bragado, Lobos, Pergamino y Zárate: es influyente, se cumple la condición de 5 ciudades.
- Rosario (Santa Fe), Rafaela (Santa Fe), San Francisco (Córdoba), y Diamante (Entre Ríos): es infuyente, se cumple la condición de 3 provincias.
- Rosario, Rafaela, Amstrong (Santa Fe) y Diamante: no es influyente, son 4 ciudades y 2 provincias, no cumple ninguna de las condiciones.
 
### Centros de distribución
Agregar al modelo los **centros de distribución**, de cada uno se sabe en qué ciudad está, y con qué vendedores trabaja.

Debe poder _agregarse_ un vendedor a un centro. Si el vendedor ya está registrado para el centro, debe generarse un error.

Debe poder consultarse, para un centro de distribución:
- el _vendedor estrella_, que es el que tiene mayor puntaje total por certificaciones.
- si _puede cubrir_, o no, una ciudad dada. La condición es que al menos uno de los vendedores registrados pueda trabajar en esa ciudad.
- la colección de _vendedores genéricos_ registrados. Un vendedor se considera genérico si tiene al menos una certificación que no es de productos.
- si _es robusto_, la condición es que al menos 3 de sus vendedores registrados sea firme.

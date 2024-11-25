package utilidades


fun calcularPorcentajeTotal(totalCuenta: Double, valorPorcentaje: Int): Double{
    return if(totalCuenta>1 && totalCuenta.toString().isNotEmpty())
        (totalCuenta*valorPorcentaje)/100 else 0.0
}
fun calcularTotalPorPersona(
    totalCuenta: Double,
    personas: Int,
    valorPorcentaje: Int
): Double {
    // Calculate the total including the tip
    val facturaConPropina = calcularPorcentajeTotal(totalCuenta, valorPorcentaje) + totalCuenta
    return facturaConPropina / personas // Returning Double to maintain precision
}


object IbuCalculator {
  def ibusTinseth(recipe: Recipe): Double = {
    recipe.hopAdditions.map(
      ibusTinseth(recipe.averageBoilGravity, recipe.batchVolume, _)
    ).sum
  }

  private def ibusTinseth(averageBoilGravity: Gravity, batchVolume: Volume, hopAddition: HopAddition): Double = {
    val alphaAcidUnits = hopAddition.alphaAcid * hopAddition.ounces
    val utilization = hopUtilizationTinseth(averageBoilGravity, hopAddition)
    alphaAcidUnits * utilization * 75 / batchVolume.inGallons
  }

  private def hopUtilizationTinseth(averageBoilGravity: Gravity, hopAddition: HopAddition): Double = {
    val gravityFactor = 1.65 * Math.pow(0.000125, (averageBoilGravity.amount - 1))
    val timeFactor = (1 - Math.pow(Math.E, -0.04 * hopAddition.boilMinutes)) / 4.15
    val result = gravityFactor * timeFactor
    result
  }
}

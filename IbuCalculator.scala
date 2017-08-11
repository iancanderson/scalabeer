object IbuCalculator {
  def ibusTinseth(recipe: Recipe): Double = {
    recipe.hopAdditions.map(
      ibusTinseth(recipe.boilGravity, recipe.batchVolume, _)
    ).sum
  }

  private def ibusTinseth(boilGravity: Double, batchVolume: Volume, hopAddition: HopAddition): Double = {
    val alphaAcidUnits = hopAddition.alphaAcid * hopAddition.ounces
    val utilization = hopUtilizationTinseth(boilGravity, hopAddition)
    alphaAcidUnits * utilization * 75 / batchVolume.inGallons
  }

  private def hopUtilizationTinseth(boilGravity: Double, hopAddition: HopAddition): Double = {
    val gravityFactor = 1.65 * Math.pow(0.000125, (boilGravity - 1))
    val timeFactor = (1 - Math.pow(Math.E, -0.04 * hopAddition.boilMinutes)) / 4.15
    val result = gravityFactor * timeFactor
    result
  }
}

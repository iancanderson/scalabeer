object Calculations {
  def ibus(recipe: Recipe): Double = {
    recipe.hopAdditions.map(ibus(recipe.batchVolume, _)).sum
  }

  private def hopUtilization(hopAddition: HopAddition): Double = {
    val boilGravity = 1.05
    val gravityFactor = 1.65 * Math.pow(0.000125, (boilGravity - 1))
    val timeFactor = (1 - Math.pow(Math.E, -0.04 * hopAddition.boilMinutes)) / 4.15
    val result = gravityFactor * timeFactor
    result
  }

  private def ibus(batchVolume: Volume, hopAddition: HopAddition): Double = {
    val alphaAcidUnits = hopAddition.alphaAcid * hopAddition.ounces
    val utilization = hopUtilization(hopAddition)
    alphaAcidUnits * utilization * 75 / batchVolume.inGallons()
  }
}

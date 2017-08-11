object OriginalGravityCalculator {
  def originalGravity(recipe: Recipe): Double = {
    val potentialPoints = recipe.grainAdditions.map(_.potentialPoints).reduce(_ + _)
    val convertedPoints = potentialPoints * recipe.brewhouseEfficiency
    1 + (convertedPoints / recipe.batchVolume.inGallons) / 1000
  }
}

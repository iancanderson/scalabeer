object OriginalGravityCalculator {
  def originalGravity(recipe: Recipe): Gravity = {
    val potentialPoints = recipe.grainAdditions.map(_.potentialPoints).reduce(_ + _)
    val convertedPoints = potentialPoints * recipe.brewhouseEfficiency
    Gravity(1 + (convertedPoints / recipe.batchVolume.inGallons) / 1000)
  }
}

case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)
case class GrainAddition(potential: Double, weight: Weight) {
  def potentialPoints = (potential - 1) * 1000 * weight.inPounds
}

case class Recipe(
  batchVolume: Volume,
  boilOffRate: VolumePerTime,
  brewhouseEfficiency: Double,
  hopAdditions: List[HopAddition],
  grainAdditions: List[GrainAddition],
  boilDuration: Time,
) {

  val originalGravityPoints = (originalGravity - 1) * 1000
  val preBoilGravityPoints = originalGravityPoints * (batchVolume / preBoilVolume)
  val preBoilGravity = preBoilGravityPoints / 1000 + 1
  val averageBoilGravity = (preBoilGravity + originalGravity) / 2

  def originalGravity = OriginalGravityCalculator.originalGravity(this)
  def preBoilVolume: Volume = {
    boilOffRate * boilDuration + batchVolume
  }
}


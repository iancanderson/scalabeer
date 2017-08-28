case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)
case class GrainAddition(potential: Double, weight: Weight) {
  def potentialPoints = (potential - 1) * 1000 * weight.inPounds
}
case class Yeast(attenuation: Double)

case class Recipe(
  batchVolume: Volume,
  boilOffRate: VolumePerTime,
  brewhouseEfficiency: Double,
  hopAdditions: List[HopAddition],
  grainAdditions: List[GrainAddition],
  boilDuration: Time,
  yeast: Yeast,
) {

  val preBoilGravityPoints = originalGravity.points * (batchVolume / preBoilVolume)
  val preBoilGravity = preBoilGravityPoints.gravity
  val averageBoilGravity = preBoilGravity.average(originalGravity)

  def finalGravity = (originalGravity.points * (1 - yeast.attenuation)).gravity
  def originalGravity = OriginalGravityCalculator.originalGravity(this)
  def preBoilVolume: Volume = {
    boilOffRate * boilDuration + batchVolume
  }
  def abv: Double = {
    (76.08 * (originalGravity.amount - finalGravity.amount) /
      (1.775 - originalGravity.amount)) * (finalGravity.amount / 0.794)
  }
}


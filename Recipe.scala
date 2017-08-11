case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)
case class GrainAddition(potential: BigDecimal, weight: Weight) {
  def potentialPoints = (potential - 1) * 1000 * weight.inPounds
}

case class Recipe(
  batchVolume: Volume,
  boilGravity: Double,
  brewhouseEfficiency: Double,
  hopAdditions: List[HopAddition],
  grainAdditions: List[GrainAddition]
)


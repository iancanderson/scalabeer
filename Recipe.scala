case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)

case class Recipe(
  batchVolume: Volume,
  boilGravity: Double,
  hopAdditions: List[HopAddition]
)

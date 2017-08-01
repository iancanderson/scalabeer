case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)

case class Recipe(
  batchVolume: Volume,
  hopAdditions: List[HopAddition]
)

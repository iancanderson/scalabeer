case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)
case class Recipe(hopAdditions: List[HopAddition])



object Main {
  val gallons = 5

  def hopUtilization(hopAddition: HopAddition): Double = {
    val boilGravity = 1.05
    val gravityFactor = 1.65 * Math.pow(0.000125, (boilGravity - 1))
    val timeFactor = (1 - Math.pow(Math.E, -0.04 * hopAddition.boilMinutes)) / 4.15
    val result = gravityFactor * timeFactor
    result
  }

  def ibus(hopAddition: HopAddition): Double = {
    val alphaAcidUnits = hopAddition.alphaAcid * hopAddition.ounces
    val utilization = hopUtilization(hopAddition)
    val result = alphaAcidUnits * utilization * 75 / gallons
    result
  }

  def ibus(recipe: Recipe): Double = {
    val result = recipe.hopAdditions.map(ibus).sum
    result
  }

  def main(args: Array[String]) {
    val hopAdditions = List(
      HopAddition(7.0, 1, 60),
      HopAddition(7.0, 1, 20),
      HopAddition(7.0, 1, 0)
    )
    val sierraNevadaPaleAle = Recipe(hopAdditions)
    val snIbus = ibus(sierraNevadaPaleAle)

    println(f"IBUs: $snIbus%3.2f")
  }
}

case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)
case class Recipe(hopAdditions: List[HopAddition])

object Calculations {
  val gallons = 5

  def ibus(recipe: Recipe): Double = {
    recipe.hopAdditions.map(ibus).sum
  }

  private def hopUtilization(hopAddition: HopAddition): Double = {
    val boilGravity = 1.05
    val gravityFactor = 1.65 * Math.pow(0.000125, (boilGravity - 1))
    val timeFactor = (1 - Math.pow(Math.E, -0.04 * hopAddition.boilMinutes)) / 4.15
    val result = gravityFactor * timeFactor
    result
  }

  private def ibus(hopAddition: HopAddition): Double = {
    val alphaAcidUnits = hopAddition.alphaAcid * hopAddition.ounces
    val utilization = hopUtilization(hopAddition)
    val result = alphaAcidUnits * utilization * 75 / gallons
    result
  }
}

object Main {
  def main(args: Array[String]) {
    val hopAdditions = List(
      HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=60),
      HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=20),
      HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=0),
    )
    val sierraNevadaPaleAle = Recipe(hopAdditions)
    val snIbus = Calculations.ibus(sierraNevadaPaleAle)

    println(f"IBUs: $snIbus%3.2f")
  }
}

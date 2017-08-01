case class HopAddition(alphaAcid: Double, ounces: Double, boilMinutes: Double)

sealed trait VolumeUnit
case object Gallon extends VolumeUnit
case object Liter extends VolumeUnit

case class Volume(amount: Double, unit: VolumeUnit) {
  def inGallons(): Double = {
    unit match {
      case Gallon => amount
      case Liter => amount / 3.78541
    }
  }
}

case class Recipe(
  batchVolume: Volume,
  hopAdditions: List[HopAddition]
)

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

object Main {
  def main(args: Array[String]) {
    val hopAdditions = List(
      HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=60),
      HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=20),
      HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=0),
    )
    val sierraNevadaPaleAle = Recipe(
      batchVolume=Volume(5, Gallon),
      hopAdditions=hopAdditions
    )
    val snIbus = Calculations.ibus(sierraNevadaPaleAle)

    println(f"IBUs: $snIbus%3.2f")
  }
}

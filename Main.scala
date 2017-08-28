object Main {
  def main(args: Array[String]) {
    val sierraNevadaPaleAle = Recipe(
      batchVolume = Volume(5.5, Gallon),
      hopAdditions = List(
        HopAddition(alphaAcid = 14, ounces = 0.6, boilMinutes = 60),
        HopAddition(alphaAcid = 5.5, ounces = 0.25, boilMinutes = 60),
      ),
      grainAdditions = List(
        GrainAddition(potential = 1.036, weight = Weight(10, Pound)),
        GrainAddition(potential = 1.037, weight = Weight(1, Pound)),
        GrainAddition(potential = 1.034, weight = Weight(0.5, Pound)),
        GrainAddition(potential = 1.036, weight = Weight(0.5, Pound)),
      ),
      brewhouseEfficiency = 0.73,
      boilOffRate = VolumePerTime(Volume(0.66, Gallon), Hour),
      boilDuration = Time(1, Hour),
      yeast = Yeast(attenuation = 0.73),
    )
    val snIbus = IbuCalculator.ibusTinseth(sierraNevadaPaleAle)
    val originalGravity = sierraNevadaPaleAle.originalGravity
    val finalGravity = sierraNevadaPaleAle.finalGravity

    println(f"IBUs: $snIbus%3.2f")
    println(f"Original Gravity: ${originalGravity.amount}%3.3f")
    println(f"Final Gravity: ${finalGravity.amount}%3.3f")
  }
}

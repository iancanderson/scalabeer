object Main {
  def main(args: Array[String]) {
    val sierraNevadaPaleAle = Recipe(
      batchVolume = Volume(5.5, Gallon),
      hopAdditions = List(
        HopAddition(alphaAcid = 7.0, ounces = 1, boilMinutes = 60),
        HopAddition(alphaAcid = 7.0, ounces = 1, boilMinutes = 20),
        HopAddition(alphaAcid = 7.0, ounces = 1, boilMinutes = 0),
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
    )
    val snIbus = IbuCalculator.ibusTinseth(sierraNevadaPaleAle)
    val originalGravity = OriginalGravityCalculator.originalGravity(sierraNevadaPaleAle)

    println(f"IBUs: $snIbus%3.2f")
    println(f"Original Gravity: $originalGravity%3.3f")
  }
}

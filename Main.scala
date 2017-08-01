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

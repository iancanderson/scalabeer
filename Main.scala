object Main {
  def main(args: Array[String]) {
    val sierraNevadaPaleAle = Recipe(
      batchVolume=Volume(5, Gallon),
      hopAdditions=List(
        HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=60),
        HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=20),
        HopAddition(alphaAcid=7.0, ounces=1, boilMinutes=0),
      ),
      boilGravity=1.050
    )
    val snIbus = Calculations.ibusTinseth(sierraNevadaPaleAle)

    println(f"IBUs: $snIbus%3.2f")
  }
}

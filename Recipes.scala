object Recipes {
  val marzen = Recipe(
    batchVolume = Volume(5.5, Gallon),
    hopAdditions = List(
      HopAddition(alphaAcid = 4.9, ounces = 2, boilMinutes = 60),
      HopAddition(alphaAcid = 2, ounces = 0.5, boilMinutes = 15),
      HopAddition(alphaAcid = 2, ounces = 0.5, boilMinutes = 5),
    ),
    grainAdditions = List(
      GrainAddition(potential = 1.038, weight = Weight(11, Pound)),
      GrainAddition(potential = 1.038, weight = Weight(1, Pound)),
      GrainAddition(potential = 1.036, weight = Weight(0.5, Pound)),
    ),
    brewhouseEfficiency = 0.60,
    boilOffRate = VolumePerTime(Volume(0.66, Gallon), Hour),
    boilDuration = Time(1, Hour),
    yeast = Yeast(attenuation = 0.78),
  )
}

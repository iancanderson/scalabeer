object OriginalGravityCalculator {
  def originalGravity(recipe: Recipe): BigDecimal = {
    val potentialPoints = recipe.grainAdditions.map(_.potentialPoints).reduce(_ + _)
    val convertedPoints = potentialPoints * recipe.brewhouseEfficiency
    1 + (convertedPoints / recipe.batchVolume.inGallons) / 1000
  }
}

// Recall that points are simply the fractional part of the potential – so an
// extract with a potential of 1.046 is simply 46 points. So for a simple stout
// with 8 lbs of pale malt (1.036 potential) and 1 lb of roast barley (1.025
// potential) would give us:
//
// 36 points * 8 lbs = 288 points
// 25 points * 1 lb = 25 points
// Total = 313 points.
//
// The next step is to apply an “efficiency” factor to our process. The
// potentials given for the grain are the maximum possible amount you could draw
// from the grains if you crushed them under laboratory conditions with no
// losses. Real mashing processes and subsequent sparging, boiling and
// transferring are not ideal – so a typical brewhouse has an efficiency number
// far less than 100%. The brewhouse efficiency number includes all of the
// losses in the system into the fermenter including mashing, lautering,
// boiling, trub loss and transferring the finished wort to fermenter. A typical
// brewhouse efficiency number for a home system is 70-75%. In this case we’ll
// use 72%
//
// 313 points * 72% efficiency = 225.4 points
//
// Now we just divide by the “into fermenter” volume which in this case is 5
// gallons:
//
// 225 points / 5 gallons = 44.8 points/gal
//
// And that is the original gravity estimate if we convert it back to specific
// gravity – 44.8 points gives us an OG of approximately 1.045

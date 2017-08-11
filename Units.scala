sealed trait VolumeUnit
case object Gallon extends VolumeUnit
case object Liter extends VolumeUnit

case class Volume(amount: Double, unit: VolumeUnit) {
  val inGallons = unit match {
    case Gallon => amount
    case Liter => amount / 3.78541
  }
}

sealed trait WeightUnit
case object Pound extends WeightUnit
case object Kilogram extends WeightUnit

case class Weight(amount: Double, unit: WeightUnit) {
  val inPounds = unit match {
    case Pound => amount
    case Kilogram => amount / 0.45359237
  }
}

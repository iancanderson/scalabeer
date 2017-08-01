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


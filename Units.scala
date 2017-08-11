sealed trait VolumeUnit
case object Gallon extends VolumeUnit
case object Liter extends VolumeUnit

case class Volume(amount: Double, unit: VolumeUnit) {
  val inGallons = unit match {
    case Gallon => amount
    case Liter => amount / 3.78541
  }

  val inLiters = unit match {
    case Gallon => amount * 3.78541
    case Liter => amount
  }

  def +(that: Volume) = this.unit match {
    case Gallon => Volume(this.amount + that.inGallons, Gallon)
    case Liter => Volume(this.amount + that.inLiters, Liter)
  }

  def /(that: Volume) = this.unit match {
    case Gallon => this.amount / that.inGallons
    case Liter => this.amount / that.inLiters
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

sealed trait TimeUnit
case object Hour extends TimeUnit
case object Minute extends TimeUnit

case class Time(amount: Double, unit: TimeUnit) {
  val inHours = unit match {
    case Hour => amount
    case Minute => amount / 60
  }
  val inMinutes = unit match {
    case Hour => amount * 60
    case Minute => amount
  }
}

case class VolumePerTime(volume: Volume, timeUnit: TimeUnit) {
  def *(time: Time): Volume = timeUnit match {
    case Minute => Volume(volume.amount * time.inMinutes, volume.unit)
    case Hour => Volume(volume.amount * time.inHours, volume.unit)
  }
}

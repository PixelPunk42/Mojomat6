import java.util.{Calendar, Date}

object MojomatContainer {

  def getAverageWeight(samples: List[Sample]): Option[CalculationResult[Float]] = {
    require(samples.length <= 6, s"ERROR, too many samples (${samples.length}). Trying to feed more than 6 samples will result in bad mojo.")

    if (samples.nonEmpty) {
      val average = samples.map(_.weight).sum.toFloat / samples.length
      Some(CalculationResult(average, getOldestTimeStamp(samples)))
    } else {
      None
    }
  }

  def getTotalWeight(samples: List[Sample]): Option[CalculationResult[Int]] = {
    require(samples.length <= 6, s"ERROR, too many samples (${samples.length}). Trying to feed more than 6 samples will result in bad mojo.")

    if (samples.nonEmpty) {
      val total = samples.map(_.weight).sum
      Some(CalculationResult(total, getOldestTimeStamp(samples)))
    } else {
      None
    }
  }

  def getSampleCount(samples: List[Sample]): Option[CalculationResult[Int]] = {
    require(samples.length <= 6, s"ERROR, too many samples (${samples.length}). Trying to feed more than 6 samples will result in bad mojo.")

    if (samples.nonEmpty) {
      Some(CalculationResult(samples.length, getOldestTimeStamp(samples)))
    } else {
      None
    }
  }

  def getMojo(samples: List[Sample]): Option[Mojo] = {
    // TODO: calculate Mojo
    None
  }

  def getTemperature: Option[Temperature] = {
    // TODO: get temp from sensor
    None
  }

  def getOldestTimeStamp(samples: List[Sample]): Date =
  {
    samples.map(_.timeStamp).min
  }
}

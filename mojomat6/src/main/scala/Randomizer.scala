import java.time.YearMonth
import java.util.{Calendar, Date}

object Randomizer {
  def getRandomSample: Sample = Sample(getRandomWeightInMilligrams, getRandomDate)

  private def getRandomDate: Date = {
    val calendar = Calendar.getInstance()
    val rng = scala.util.Random
    val minYear = 1999
    val maxYear = 2021
    val year = rng.nextInt(maxYear - minYear) + minYear
    calendar.set(Calendar.YEAR, year)
    val month = rng.nextInt(12) + 1
    calendar.set(Calendar.MONTH, month)
    val maxDays = YearMonth.of(year, month).lengthOfMonth()
    calendar.set(Calendar.DAY_OF_MONTH, rng.nextInt(maxDays))
    calendar.set(Calendar.HOUR_OF_DAY, rng.nextInt(24))
    calendar.set(Calendar.MINUTE, rng.nextInt(60))
    calendar.set(Calendar.SECOND, rng.nextInt(60))

    calendar.getTime
  }

  private def getRandomWeightInMilligrams: Int = {
    val rng = scala.util.Random
    val minWeight = 42
    val maxWeight = 1337
    rng.nextInt(maxWeight - minWeight) + minWeight
  }
}

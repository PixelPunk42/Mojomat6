import java.util.{Calendar, Date}

class MojomatContainerTest extends org.scalatest.funsuite.AnyFunSuite {
  test("MojomatContainer.getAverageWeight calculates correct average value") {
    val weight1 = 100;
    val date1 = getDate(1990, 5, 14, 20, 30, 44)
    val sample1 = Sample(weight1, date1)

    val weight2 = 50;
    val date2 = getDate(2020, 6 ,8, 14, 20, 23)
    val sample2 = Sample(weight2, date2)

    val weight3 = 150
    val date3 = getDate(2001, 1, 15, 8, 49, 42)
    val sample3 = Sample(weight3, date3)

    val samples = List(sample1, sample2, sample3)
    val result = MojomatContainer.getAverageWeight(samples)
    result match {
      case Some(value) => assert(almostEquals(value.result, (weight1 + weight2 + weight3).toFloat / samples.length))
      case None => assert(false)
    }
  }

  test("MojomatContainer.getAverageWeight result shows correct timestamp") {
    val weight1 = 100;
    val date1 = getDate(1990, 5, 14, 20, 30, 44)
    val sample1 = Sample(weight1, date1)

    val weight2 = 50;
    val date2 = getDate(2020, 6 ,8, 14, 20, 23)
    val sample2 = Sample(weight2, date2)

    val weight3 = 150
    val date3 = getDate(2001, 1, 15, 8, 49, 42)
    val sample3 = Sample(weight3, date3)

    val samples = List(sample1, sample2, sample3)
    val result = MojomatContainer.getAverageWeight(samples)

    result match {
      case Some(value) => assert(value.timeStamp == date1)
      case None => assert(false)
    }
  }

  test("MojomatContainer.getAverageWeight returns None if fed with empty list") {
    val samples = List[Sample]()
    val result = MojomatContainer.getAverageWeight(samples)

    result match {
      case Some(value) => assert(false)
      case None => assert(true)
    }
  }

  test("MojomatContainer.getTotalWeight calculates correct total value ") {
    val weight1 = 100;
    val date1 = getDate(1990, 5, 14, 20, 30, 44)
    val sample1 = Sample(weight1, date1)

    val weight2 = 50;
    val date2 = getDate(2020, 6 ,8, 14, 20, 23)
    val sample2 = Sample(weight2, date2)

    val weight3 = 150
    val date3 = getDate(2001, 1, 15, 8, 49, 42)
    val sample3 = Sample(weight3, date3)

    val samples = List(sample1, sample2, sample3)
    val result = MojomatContainer.getTotalWeight(samples)

    result match {
      case Some(value) => assert(value.result == weight1 + weight2 + weight3)
      case None => assert(false)
    }
  }

  test("MojomatContainer.getTotalWeight result shows correct timestamp") {
    val weight1 = 100;
    val date1 = getDate(1990, 5, 14, 20, 30, 44)
    val sample1 = Sample(weight1, date1)

    val weight2 = 50;
    val date2 = getDate(2020, 6 ,8, 14, 20, 23)
    val sample2 = Sample(weight2, date2)

    val weight3 = 150
    val date3 = getDate(2001, 1, 15, 8, 49, 42)
    val sample3 = Sample(weight3, date3)

    val samples = List(sample1, sample2, sample3)
    val result = MojomatContainer.getTotalWeight(samples)

    result match {
      case Some(value) => assert(value.timeStamp == date1)
      case None => assert(false)
    }
  }

  test("MojomatContainer.getTotalWeight returns None if fed with empty list") {
    val samples = List[Sample]()
    val result = MojomatContainer.getTotalWeight(samples)

    result match {
      case Some(value) => assert(false)
      case None => assert(true)
    }
  }

  test("MojomatContainer.getSampleCount returns correct # of samples") {
    val weight1 = 100;
    val date1 = getDate(1990, 5, 14, 20, 30, 44)
    val sample1 = Sample(weight1, date1)

    val weight2 = 50;
    val date2 = getDate(2020, 6 ,8, 14, 20, 23)
    val sample2 = Sample(weight2, date2)

    val weight3 = 150
    val date3 = getDate(2001, 1, 15, 8, 49, 42)
    val sample3 = Sample(weight3, date3)

    val samples = List(sample1, sample2, sample3)
    val result = MojomatContainer.getSampleCount(samples)

    result match {
      case Some(value) => assert(value.result == samples.length)
      case None => assert(false)
    }
  }

  test("MojomatContainer.getSampleCount result shows correct timestamp") {
    val weight1 = 100;
    val date1 = getDate(1990, 5, 14, 20, 30, 44)
    val sample1 = Sample(weight1, date1)

    val weight2 = 50;
    val date2 = getDate(2020, 6 ,8, 14, 20, 23)
    val sample2 = Sample(weight2, date2)

    val weight3 = 150
    val date3 = getDate(2001, 1, 15, 8, 49, 42)
    val sample3 = Sample(weight3, date3)

    val samples = List(sample1, sample2, sample3)
    val result = MojomatContainer.getSampleCount(samples)

    result match {
      case Some(value) => assert(value.timeStamp == date1)
      case None => assert(false)
    }
  }


  test("MojomatContainer.getSampleCount returns None if fed with empty list") {
    val samples = List[Sample]()
    val result = MojomatContainer.getSampleCount(samples)

    result match {
      case Some(value) => assert(false)
      case None => assert(true)
    }
  }

  test("MojomatContainer.getTemperature returns current temp") {
    val temp = MojomatContainer.getTemperature

    temp match {
      case Some(value) => assert(true)
      case None => assert(false)
    }
  }

  test("MojomatContainer.getMojo returns calculated mojo") {
    val samples = List[Sample]()
    val mojo = MojomatContainer.getMojo(samples)

    mojo match {
      case Some(value) => assert(true)
      case None => assert(false)
    }
  }

  def almostEquals(x: Float, y: Float) = {
    val precision = 0.01
    if ((x - y).abs < precision) true else false
  }

  def getDate(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int): Date = {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.DAY_OF_MONTH, day)
    calendar.set(Calendar.HOUR_OF_DAY, hour)
    calendar.set(Calendar.MINUTE, minute)
    calendar.set(Calendar.SECOND, second)

    calendar.getTime
  }
}

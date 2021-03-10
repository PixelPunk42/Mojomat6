object Mojomat6 extends App {
  val samples = List( Randomizer.getRandomSample,
                      // Randomizer.getRandomSample,
                      // Randomizer.getRandomSample,
                      Randomizer.getRandomSample,
                      Randomizer.getRandomSample,
                      Randomizer.getRandomSample,
                      Randomizer.getRandomSample)
  // val samples = List[Sample]()
  println("\nFound the following samples:")
  samples.foreach(println)

  println("\nCounting Samples:")
  val sampleCount = MojomatContainer.getSampleCount(samples)
  sampleCount match {
    case Some(value) => println(value)
    case None => println("No samples found")
  }

  println("\nCalculating average weight in milligrams:")
  val averageWeight = MojomatContainer.getAverageWeight(samples)
  averageWeight match {
    case Some(value) => println(value)
    case None => println("Unable to evaluate.")
  }
  
  println("\nCalculating total weight in milligrams:")
  val totalWeight = MojomatContainer.getTotalWeight(samples)
  totalWeight match {
    case Some(value) => println(value)
    case None => println("Unable to evaluate.")
  }

  println("\nAccessing temperature probe:")
  val temp = MojomatContainer.getTemperature
  temp match {
    case Some(value) => println(value)
    case None => println("ERROR: Temperature probe not connected.")
  }

  println("\nCalculation Mojo")
  val mojo = MojomatContainer.getMojo(samples)
  mojo match {
    case Some(value) => println(value)
    case None => println("ERROR: Mojo could not be calculated")
  }
}

import java.util.Date

case class CalculationResult[T](result: T, timeStamp: Date) extends BaseSensor {
    override def toString: String = s"Result: $result, time: $timeStamp"
}

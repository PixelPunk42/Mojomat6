import java.util.Date

case class Sample(weight: Int, timeStamp: Date) extends BaseSensor {
  override def toString: String = s"Sample weight: $weight mg, time: $timeStamp"
}

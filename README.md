# Mojomat6

Used technologies:

* Scala 2.13 /w sbt
* Scalatest
* VS Code /w Scala(Metals) extension

Comments
* Entry point is Mojomat6.scala, which shows basic usage with random data.
* Having a BaseSensor class with just one member looks a bit over-engineered. However, since the device is still in early stages of development, there might be other values share by all sensors.
* Unit tests: creating the very same objects in each of the test methods is done on purpose. I personnally prefer the convenience of being able to look at the data in the test method I'm working on, instead of having to scroll away through the file. 
* Trying to operate on a list with more than 6 entries will intentionally crash the app with an error message, as this would be an indication that something went horribly wrong and might harm the device.

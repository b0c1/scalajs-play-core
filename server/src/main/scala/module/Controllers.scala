package module

import com.softwaremill.macwire._
import controllers.{ApiController, DemoController}

/**
  * Controllers dependencies
  */
trait Controllers {
  lazy val applicationController = wire[DemoController]
  lazy val apiController = wire[ApiController]
}

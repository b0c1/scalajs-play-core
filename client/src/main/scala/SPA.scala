import autowire._
import boopickle.Default._
import demo.SampleApi
import service.SampleService

import scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object SPA extends js.JSApp {
  @JSExport
  override def main(): Unit = {
    val jQuery = js.Dynamic.global.jQuery
    SampleService[SampleApi].echo("Hi there").call().map(result => {
      jQuery("#container").html(result)
    })
  }
}

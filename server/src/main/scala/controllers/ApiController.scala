package controllers

import demo.SampleApi
import play.api.mvc.Action
import service.SampleApiImpl

/**
  * API Controller
  * Each request will create a SampleApiImpl instance.
  * It's necessary if you want to set the user in the constructor, otherwise you can use singleton
  */
class ApiController extends ServiceController {
  import boopickle.Default._
  import scala.concurrent.ExecutionContext.Implicits.global

  def userApi(path: String) = Action.async(parse.raw) { implicit request =>
    internalRoute(path, request) {
      Router.route[SampleApi](new SampleApiImpl())
    }
  }
}

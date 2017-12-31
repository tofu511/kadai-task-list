package controllers

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

class GetTasksControllerSpec extends PlayFunSpec with GuiceOneAppPerSuite {

  describe("GetTasksController") {
    describe("route of GetTasksController#index") {
      it("should be valid") {
        val result = route(app, addCsrfToken(FakeRequest(GET, routes.GetTasksController.index().toString))).get
        status(result) mustBe OK
      }
    }
  }
}

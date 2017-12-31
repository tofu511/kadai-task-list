package controllers

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

class GetTaskControllerSpec extends PlayFunSpec with GuiceOneAppPerSuite {

  describe("GetTaskController") {
    describe("route of GetTaskController#index") {
      it("should be valid") {
        val fakeId = 1L
        val result =
          route(app, addCsrfToken(FakeRequest(GET, routes.GetTaskController.index(fakeId).toString))).get
        status(result) mustBe OK
      }
    }
  }
}

package controllers

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import play.api.test.Helpers._

class UpdateTaskControllerSpec extends PlayFunSpec with GuiceOneAppPerSuite {

  describe("UpdateTaskController") {
    describe("route of UpdateTaskController#index") {
      it("should be valid") {
        val fakeId = 1L
        val result = route(app, addCsrfToken(FakeRequest(GET, routes.UpdateTaskController.index(fakeId).toString))).get
        status(result) mustBe OK
      }
    }

    describe("route of UpdateTaskController#update") {
      val result =
        route(app,
              addCsrfToken(
                FakeRequest(POST, routes.UpdateTaskController.update().toString)
                  .withFormUrlEncodedBody("id" -> "1", "status" -> "D", "content" -> "test")
              )).get
      status(result) mustBe SEE_OTHER
    }
  }
}

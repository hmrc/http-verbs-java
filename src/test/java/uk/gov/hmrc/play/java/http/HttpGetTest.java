/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright 2015 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.play.java.http;

import akka.dispatch.Futures;
import org.junit.Test;
import scala.collection.JavaConversions;
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.java.ScalaFixtures;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HttpGetTest extends ScalaFixtures {

    HttpGet stubbedGet(RequestToResponse fn) {
        return new HttpGet() {
            @Override
            public Future<HttpResponse> doGet(String url, HeaderCarrier hc) {
                return fn.apply(url, hc);
            }
        };
    }

    @Test
    public void httpGetShouldBeAbleToReturnPlainResponses() {
        HttpResponse response = new DummyHttpResponse("test body", 200, null);
        HttpGet testGet = stubbedGet((url, hc) -> Futures.successful(response));
        HttpResponse resp = await(testGet.doGet("http://gov.uk/test", mockCarrier()));
        assertThat(resp, is(response));
    }

/*
    "be able to return HTML responses"in new HtmlHttpReads
    {
        val testGet = new StubbedHttpGet(Future.successful(new DummyHttpResponse(testBody, 200)))
        testGet.GET(url).futureValue should be (an[Html])
    }
        "be able to return objects deserialised from JSON"in

    {
        val testGet = new StubbedHttpGet(Future.successful(new DummyHttpResponse("""{"foo":"t","bar":10}""", 200)))
        testGet.GET[TestClass] (url).futureValue should be (TestClass("t", 10))
    }

    behave like

    anErrorMappingHttpCall(GET, (url, responseF) =>new

    StubbedHttpGet(responseF).

    GET(url))
    behave like

    aTracingHttpCall(GET, "GET",new StubbedHttpGet(defaultHttpResponse))

    {
        _.GET(url)
    }

        "Invoke any hooks provided"in

    {
      import uk.gov.hmrc.play.test.Concurrent.await

        val dummyResponseFuture = Future.successful(new DummyHttpResponse(testBody, 200))
        val testGet = new StubbedHttpGet(dummyResponseFuture)
        await(testGet.GET(url))

        verify(testGet.testHook1) (url, "GET", None, dummyResponseFuture)
        verify(testGet.testHook2) (url, "GET", None, dummyResponseFuture)
    }
}

  "HttpGet with params Seq"should

          {
          "return an empty string if the query parameters is empty"in{
          val expected=Some("http://test.net")
          val testGet=new UrlTestingHttpGet()
          testGet.GET("http://test.net",Seq())
          testGet.lastUrl shouldBe expected
          }

          "return a url with a single param pair"in{
          val expected=Some("http://test.net?one=1")
          val testGet=new UrlTestingHttpGet()
          testGet.GET("http://test.net",Seq(("one","1")))
          testGet.lastUrl shouldBe expected
          }

          "return a url with a multiple param pairs"in{
          val expected=Some("http://test.net?one=1&two=2&three=3")
          val testGet=new UrlTestingHttpGet()
          testGet.GET("http://test.net",Seq(("one","1"),("two","2"),("three","3")))
          testGet.lastUrl shouldBe expected
          }

          "return a url with encoded param pairs"in{
          val expected=Some("http://test.net?email=test%2Balias%40email.com&data=%7B%22message%22%3A%22in+json+format%22%7D")
          val testGet=new UrlTestingHttpGet()
          testGet.GET("http://test.net",Seq(("email","test+alias@email.com"),("data","{\"message\":\"in json format\"}")))
          testGet.lastUrl shouldBe expected
          }

          "return a url with duplicate param pairs"in{
          val expected=Some("http://test.net?one=1&two=2&one=11")
          val testGet=new UrlTestingHttpGet()
          testGet.GET("http://test.net",Seq(("one","1"),("two","2"),("one","11")))
          testGet.lastUrl shouldBe expected
          }

          "raise an exception if the URL provided already has a query string"in{
          val testGet=new UrlTestingHttpGet()

          a[UrlValidationException]should be thrownBy testGet.GET("http://test.net?should=not=be+here",Seq(("one","1")))
          }
          }
*/
}

interface RequestToResponse {
    Future<HttpResponse> apply(String url, HeaderCarrier hc);
}

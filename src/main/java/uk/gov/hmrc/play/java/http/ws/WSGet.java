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

package uk.gov.hmrc.play.java.http.ws;

import scala.Tuple2;
import scala.collection.Seq;
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpGet$class;
import uk.gov.hmrc.play.http.HttpReads;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.http.ws.WSGet$class;
import uk.gov.hmrc.play.java.http.HttpGet;

public interface WSGet extends uk.gov.hmrc.play.http.ws.WSGet, WSRequest, HttpGet {

    @Override
    default Future<HttpResponse> doGet(String url, HeaderCarrier hc) {
        return WSGet$class.doGet(this, url, hc);
    }

    @Override
    default <A> Future<A> GET(String url, Seq<Tuple2<String, String>> queryParams, HttpReads<A> rds, HeaderCarrier hc) {
        return HttpGet$class.GET(this, url, queryParams, rds, hc);
    }

    @Override
    default <A> Future<A> GET(String url, HttpReads<A> rds, HeaderCarrier hc) {
        return HttpGet$class.GET(this, url, rds, hc);
    }
}

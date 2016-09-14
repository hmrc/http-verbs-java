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

import play.api.libs.json.Writes;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.Map;
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpPost$class;
import uk.gov.hmrc.play.http.HttpReads;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.http.ws.WSPost$class;
import uk.gov.hmrc.play.java.http.HttpPost;

public interface WSPost extends uk.gov.hmrc.play.http.ws.WSPost, WSRequest, HttpPost {
    @Override
    default <A> Future<HttpResponse> doPost(String url, A body, Seq<Tuple2<String, String>> headers, Writes<A> rds, HeaderCarrier hc) {
        return WSPost$class.doPost(this, url, body, headers, rds, hc);
    }

    @Override
    default Future<HttpResponse> doFormPost(String url, Map<String, Seq<String>> body, HeaderCarrier hc) {
        return WSPost$class.doFormPost(this, url, body, hc);
    }

    @Override
    default Future<HttpResponse> doPostString(String url, String body, Seq<Tuple2<String, String>> headers, HeaderCarrier hc) {
        return WSPost$class.doPostString(this, url, body, headers, hc);
    }

    @Override
    default <A> Future<HttpResponse> doEmptyPost(String url, HeaderCarrier hc) {
        return WSPost$class.doEmptyPost(this, url, hc);
    }

    @Override
    default <I, O> Future<O> POST(String url, I body, Seq<Tuple2<String, String>> headers, Writes<I> wts, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPost$class.POST(this, url, body, headers, wts, rds, hc);
    }

    @Override
    default <I, O> Seq<Tuple2<String, String>> POST$default$3() {
        return HttpPost$class.POST$default$3(this);
    }
}

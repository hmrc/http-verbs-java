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

package uk.gov.hmrc.play.java.http;

import play.api.libs.json.Writes;
import scala.Tuple2;
import scala.collection.Seq;
import scala.collection.immutable.Map;
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpPost$class;
import uk.gov.hmrc.play.http.HttpReads;
import uk.gov.hmrc.play.java.http.logging.ConnectionTracing;

public interface HttpPost extends uk.gov.hmrc.play.http.HttpPost, HttpHooks, ConnectionTracing, HttpErrorFunctions {
    @Override
    default <I, O> Future<O> POST(String url, I body, Seq<Tuple2<String, String>> headers, Writes<I> wts, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPost$class.POST(this, url, body, headers, wts, rds, hc);
    }

    @Override
    default <O> Future<O> POSTString(String url, String body, Seq<Tuple2<String, String>> headers, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPost$class.POSTString(this, url, body, headers, rds, hc);
    }

    @Override
    default <O> Future<O> POSTForm(String url, Map<String, Seq<String>> body, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPost$class.POSTForm(this, url, body, rds, hc);
    }

    @Override
    default <O> Future<O> POSTEmpty(String url, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPost$class.POSTEmpty(this, url, rds, hc);
    }

    @Override
    default <O> Seq<Tuple2<String, String>> POSTString$default$3() {
        return HttpPost$class.POSTString$default$3(this);
    }

    @Override
    default <I, O> Seq<Tuple2<String, String>> POST$default$3() {
        return HttpPost$class.POST$default$3(this);
    }
}

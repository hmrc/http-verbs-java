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

import scala.Option;
import scala.collection.JavaConversions;
import scala.collection.Seq;
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.http.hooks.HttpHook;
import uk.gov.hmrc.play.http.hooks.HttpHooks$class;

import java.util.Collections;

public interface HttpHooks extends uk.gov.hmrc.play.http.hooks.HttpHooks {
    Seq NoneRequired = JavaConversions.asScalaBuffer(Collections.EMPTY_LIST);

    @Override
    default Seq<HttpHook> hooks() {
        return NoneRequired;
    }

    default Seq<Object> NoneRequired() {
        return NoneRequired;
    }

    @Override
    default void executeHooks(String url, String verb, Option<?> body, Future<HttpResponse> responseF, HeaderCarrier hc) {
        HttpHooks$class.executeHooks(this, url, verb, body, responseF, hc);
    }

    @Override
    default void uk$gov$hmrc$play$http$hooks$HttpHooks$_setter_$NoneRequired_$eq(Seq httpHooks) {
        // No-op
    }
}

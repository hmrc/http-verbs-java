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

import play.api.libs.ws.WSRequestHolder;
import scala.collection.JavaConversions;
import scala.collection.Seq;
import scala.util.matching.Regex;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.ws.WSRequest$class;

import java.util.Collections;

public interface WSRequest extends uk.gov.hmrc.play.http.ws.WSRequest {
    @Override
    default <A> WSRequestHolder buildRequest(String url, HeaderCarrier hc) {
        return WSRequest$class.buildRequest(this, url, hc);
    }

    @Override
    default void uk$gov$hmrc$play$http$ws$WSRequest$_setter_$uk$gov$hmrc$play$http$ws$WSRequest$$internalHostPatterns_$eq(Seq patterns) {
        // No-op
    }

    @Override
    default scala.collection.Seq<Regex> uk$gov$hmrc$play$http$ws$WSRequest$$internalHostPatterns() {
        return JavaConversions.asScalaBuffer(Collections.singletonList(new Regex("^.*\\.service$", null)));
    }
}

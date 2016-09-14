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
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.http.ws.WSPatch$class;
import uk.gov.hmrc.play.java.http.HttpPatch;

public interface WSPatch extends uk.gov.hmrc.play.http.ws.WSPatch, WSRequest, HttpPatch {
    @Override
    default <A> Future<HttpResponse> doPatch(String url, A body, Writes<A> rds, HeaderCarrier hc) {
        return WSPatch$class.doPatch(this, url, body, rds, hc);
    }
}

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
import uk.gov.hmrc.play.http.HttpPut$class;
import uk.gov.hmrc.play.http.HttpReads;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.http.ws.WSPut$class;
import uk.gov.hmrc.play.java.http.HttpPut;

public interface WSPut extends uk.gov.hmrc.play.http.ws.WSPut, WSRequest, HttpPut {
    @Override
    default <A> Future<HttpResponse> doPut(String url, A body, Writes<A> rds, HeaderCarrier hc) {
        return WSPut$class.doPut(this, url, body, rds, hc);
    }

    @Override
    default <I, O> Future<O> PUT(String url, I body, Writes<I> wts, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPut$class.PUT(this, url, body, wts, rds, hc);
    }
}

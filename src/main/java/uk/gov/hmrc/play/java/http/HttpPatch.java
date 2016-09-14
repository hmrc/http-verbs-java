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
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpPatch$class;
import uk.gov.hmrc.play.http.HttpReads;
import uk.gov.hmrc.play.java.http.logging.ConnectionTracing;

@FunctionalInterface
public interface HttpPatch extends uk.gov.hmrc.play.http.HttpPatch, HttpHooks, HttpErrorFunctions, ConnectionTracing {
    @Override
    default <I, O> Future<O> PATCH(String url, I body, Writes<I> wts, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpPatch$class.PATCH(this, url, body, wts, rds, hc);
    }
}

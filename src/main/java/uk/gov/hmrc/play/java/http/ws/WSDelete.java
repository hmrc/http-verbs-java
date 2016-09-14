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

import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HeaderCarrier;
import uk.gov.hmrc.play.http.HttpDelete$class;
import uk.gov.hmrc.play.http.HttpReads;
import uk.gov.hmrc.play.http.HttpResponse;
import uk.gov.hmrc.play.http.ws.WSDelete$class;
import uk.gov.hmrc.play.java.http.HttpDelete;

public interface WSDelete extends uk.gov.hmrc.play.http.ws.WSDelete, WSRequest, HttpDelete {

    @Override
    default Future<HttpResponse> doDelete(String url, HeaderCarrier hc) {
        return WSDelete$class.doDelete(this, url, hc);
    }

    @Override
    default <O> Future<O> DELETE(String url, HttpReads<O> rds, HeaderCarrier hc) {
        return HttpDelete$class.DELETE(this, url, rds, hc);
    }
}

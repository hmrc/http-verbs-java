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

package uk.gov.hmrc.play.java.http.logging;

import play.api.Logger;
import scala.Function0;
import scala.concurrent.Future;
import scala.util.Try;
import uk.gov.hmrc.play.http.logging.ConnectionTracing$class;
import uk.gov.hmrc.play.http.logging.LoggingDetails;

public interface ConnectionTracing extends uk.gov.hmrc.play.http.logging.ConnectionTracing {
    @Override
    default Logger connectionLogger() {
        return Logger.apply("connector");
    }

    @Override
    default <T> Future<T> withTracing(String method, String uri, Function0<Future<T>> body, LoggingDetails ld) {
        return ConnectionTracing$class.withTracing(this, method, uri, body, ld);
    }

    @Override
    default <A> void logResult(LoggingDetails ld, String method, String uri, long startAge, Try<A> result) {
        ConnectionTracing$class.logResult(this, ld, method, uri, startAge, result);
    }

    @Override
    default String formatMessage(LoggingDetails ld, String method, String uri, long startAge, String message) {
        return ConnectionTracing$class.formatMessage(this, ld, method, uri, startAge, message);
    }
}

class XConnectionTracing implements ConnectionTracing {}

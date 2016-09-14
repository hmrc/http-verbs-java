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

import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;
import uk.gov.hmrc.play.http.HttpErrorFunctions$class;
import uk.gov.hmrc.play.http.HttpResponse;

public interface HttpErrorFunctions extends uk.gov.hmrc.play.http.HttpErrorFunctions {
    @Override
    default String upstreamResponseMessage(String verbName, String url, int status, String responseBody) {
        return HttpErrorFunctions$class.upstreamResponseMessage(this, verbName, url, status, responseBody);
    }

    @Override
    default String gatewayTimeoutMessage(String verbName, String url, Exception e) {
        return HttpErrorFunctions$class.gatewayTimeoutMessage(this, verbName, url, e);
    }

    @Override
    default String notFoundMessage(String verbName, String url, String responseBody) {
        return HttpErrorFunctions$class.notFoundMessage(this, verbName, url, responseBody);
    }

    @Override
    default String preconditionFailedMessage(String verbName, String url, String responseBody) {
        return HttpErrorFunctions$class.preconditionFailedMessage(this, verbName, url, responseBody);
    }

    @Override
    default String badRequestMessage(String verbName, String url, String responseBody) {
        return HttpErrorFunctions$class.badRequestMessage(this, verbName, url, responseBody);
    }

    @Override
    default String badGatewayMessage(String verbName, String url, int status, String responseBody) {
        return HttpErrorFunctions$class.badGatewayMessage(this, verbName, url, status, responseBody);
    }

    @Override
    default String badGatewayMessage(String verbName, String url, Exception e) {
        return HttpErrorFunctions$class.badGatewayMessage(this, verbName, url, e);
    }

    @Override
    default boolean is2xx(int status) {
        return HttpErrorFunctions$class.is2xx(this, status);
    }

    @Override
    default boolean is4xx(int status) {
        return HttpErrorFunctions$class.is4xx(this, status);
    }

    @Override
    default boolean is5xx(int status) {
        return HttpErrorFunctions$class.is5xx(this, status);
    }

    @Override
    default HttpResponse handleResponse(String httpMethod, String url, HttpResponse response) {
        return HttpErrorFunctions$class.handleResponse(this, httpMethod, url, response);
    }

    @Override
    default Future<HttpResponse> mapErrors(String httpMethod, String url, Future<HttpResponse> f, ExecutionContext ec) {
        return HttpErrorFunctions$class.mapErrors(this, httpMethod, url, f, ec);
    }
}

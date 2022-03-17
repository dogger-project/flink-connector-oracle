/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.terminus.fdp.flink.oracle.connector.failure;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default failure handling logic that doesn't do any handling but throws
 * an error.
 */
public class DefaultOracleFailureHandler implements OracleFailureHandler {

    @Override
    public void onFailure(List<String> failure) throws IOException {
        String errors = failure.stream()
                .map(error -> error.toString() + System.lineSeparator())
                .collect(Collectors.joining());

        throw new IOException("Error while sending value. \n " + errors);
    }
}

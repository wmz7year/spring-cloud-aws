/*
 * Copyright 2013-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.awspring.cloud.samples.parameterstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudAwsParameterStoreSample {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudAwsParameterStoreSample.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAwsParameterStoreSample.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(@Value("${message}") String message, @Value("${messages[0]}") String msg1,
										@Value("${messages[1]}") String msg2) {
		return args -> LOGGER.info("`messages` loaded from the AWS Parameter store: {}, {} and {}", message, msg1,
			msg2);
	}

}

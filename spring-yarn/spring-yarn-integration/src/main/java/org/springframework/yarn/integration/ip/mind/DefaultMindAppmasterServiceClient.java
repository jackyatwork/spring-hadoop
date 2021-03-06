/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.yarn.integration.ip.mind;

import org.springframework.core.convert.ConversionService;
import org.springframework.yarn.am.RpcMessage;
import org.springframework.yarn.integration.ip.mind.binding.BaseObject;
import org.springframework.yarn.integration.ip.mind.binding.BaseResponseObject;

/**
 * Default implementation of {@link MindAppmasterServiceClient} which
 * handles the message serialization using type information in
 * mind message headers.
 *
 * @author Janne Valkealahti
 *
 */
public class DefaultMindAppmasterServiceClient extends MindAppmasterServiceClient {

	@Override
	protected BaseResponseObject getBaseResponseObject(RpcMessage<?> rpcMessage) {
		MindRpcMessageHolder holder = (MindRpcMessageHolder) rpcMessage.getBody();
		ConversionService conversionService = getConversionService();
		if(conversionService != null) {
			return (BaseResponseObject) conversionService.convert(holder, BaseObject.class);
		}
		return null;
	}

}

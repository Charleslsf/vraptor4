/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.caelum.vraptor.http;

import static com.google.common.base.Objects.firstNonNull;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.caelum.vraptor.config.BasicConfiguration;

/**
 * Create an instance for {@link EncodingHandler}. If {@link BasicConfiguration#ENCODING} is defined into web.xml,
 * the {@link DefaultEncodingHandler} instance is created with the value, or UTF-8 otherwise.
 * 
 * @author Lucas Cavalcanti
 */
@ApplicationScoped
public class EncodingHandlerFactory{

	private EncodingHandler handler;

	//CDI eyes only
	@Deprecated
	public EncodingHandlerFactory() {
	}
	
	@Inject
	public EncodingHandlerFactory(BasicConfiguration configuration) {
		String encoding = firstNonNull(configuration.getEncoding(), "UTF-8");
		handler = new DefaultEncodingHandler(encoding);
	}
	
	@Produces @javax.enterprise.context.ApplicationScoped
	public EncodingHandler getInstance() {
		return handler;
	}
}

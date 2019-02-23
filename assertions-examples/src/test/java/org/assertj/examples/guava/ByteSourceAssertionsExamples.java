/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.examples.guava;

import static org.assertj.guava.api.Assertions.assertThat;

import java.io.IOException;

import org.assertj.examples.AbstractAssertionsExamples;
import org.junit.Test;

import com.google.common.io.ByteSource;


/**
 * {@link ByteSource} assertions example.
 *
 * @author Andrew Gaul
 */
public class ByteSourceAssertionsExamples extends AbstractAssertionsExamples {

  @Test
  public void bytesource_assertions_examples() throws IOException {
    int size = 1;
    ByteSource actual = ByteSource.wrap(new byte[size]);

    assertThat(actual).hasSize(size);
    assertThat(actual).hasSameContentAs(ByteSource.wrap(new byte[size]));

    ByteSource emptyByteSource = ByteSource.wrap(new byte[0]);
    assertThat(emptyByteSource).isEmpty();
  }

}

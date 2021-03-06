/*
 * Copyright (C) 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dataflow.sdk.values;

import com.google.cloud.dataflow.sdk.Pipeline;

import java.util.Collection;

/**
 * The interface for things that might be input to a
 * {@link com.google.cloud.dataflow.sdk.transforms.PTransform}.
 */
public interface PInput {
  /**
   * Returns the owning {@link Pipeline} of this {@code PInput}.
   */
  public Pipeline getPipeline();

  /**
   * Expands this {@code PInput} into a list of its component input {@link PValue}s.
   *
   * <p>A {@link PValue} expands to itself.
   *
   * <p>A tuple or list of {@link PValue}s (e.g., {@link PCollectionTuple},
   * and {@link PCollectionList}) expands to its component {@link PValue}s.
   *
   * <p>Not intended to be invoked directly by user code.
   */
  public Collection<? extends PValue> expand();

  /**
   * <p>After building, finalizes this {@code PInput} to make it ready for
   * being used as an input to a {@link com.google.cloud.dataflow.sdk.transforms.PTransform}.
   *
   * <p>Automatically invoked whenever {@code apply()} is invoked on
   * this {@code PInput}, so users do not normally call this explicitly.
   */
  public void finishSpecifying();
}

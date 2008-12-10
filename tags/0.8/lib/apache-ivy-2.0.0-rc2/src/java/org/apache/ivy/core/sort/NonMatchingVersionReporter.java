/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.ivy.core.sort;

import org.apache.ivy.core.module.descriptor.DependencyDescriptor;
import org.apache.ivy.core.module.descriptor.ModuleDescriptor;

public interface NonMatchingVersionReporter {

    /**
     * Report to the user that ivy has detected that a module to sort has a dependency on an other
     * module to sort, but the revisions doesn't match.
     * 
     * @param descriptor
     *            The non matching dependency descriptor.
     * @param md
     *            The module to sort having the corect moduleID but a non matching revision
     */
    public void reportNonMatchingVersion(DependencyDescriptor descriptor, ModuleDescriptor md);

}

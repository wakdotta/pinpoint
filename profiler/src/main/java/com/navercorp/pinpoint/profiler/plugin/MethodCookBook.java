/**
 * Copyright 2014 NAVER Corp.
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
package com.navercorp.pinpoint.profiler.plugin;

import java.util.List;

import com.navercorp.pinpoint.bootstrap.instrument.InstrumentClass;
import com.navercorp.pinpoint.bootstrap.instrument.InstrumentException;
import com.navercorp.pinpoint.bootstrap.instrument.MethodInfo;

/**
 * @author Jongho Moon
 *
 */
public class MethodCookBook implements MethodRecipe {
    private final List<MethodRecipe> recipes;
    
    public MethodCookBook(List<MethodRecipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public void edit(ClassLoader targetClassLoader, InstrumentClass targetClass, MethodInfo targetMethod) throws InstrumentException {
        for (MethodRecipe recipe : recipes) {
            recipe.edit(targetClassLoader, targetClass, targetMethod);
        }
    }
}

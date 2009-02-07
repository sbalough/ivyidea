/*
 *    Copyright 2009 Guy Mahieu
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 *
 * Copyright (c) , Your Corporation. All Rights Reserved.
 */

package org.clarent.ivyidea.intellij;

import com.intellij.facet.FacetManager;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import org.clarent.ivyidea.intellij.facet.IvyIdeaFacet;
import org.clarent.ivyidea.intellij.facet.IvyIdeaFacetType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guy Mahieu
 */

public class IntellijUtils {

    public static Project getCurrentProject() {
        DataContext dataContext = DataManager.getInstance().getDataContext();
        return DataKeys.PROJECT.getData(dataContext);
    }

    @NotNull
    public static Module[] getAllModulesWithIvyIdeaFacet() {
        return getAllModulesWithIvyIdeaFacet(getCurrentProject());
    }

    @NotNull
    public static Module[] getAllModulesWithIvyIdeaFacet(Project project) {
        final Module[] allModules = ModuleManager.getInstance(project).getModules();
        final List<Module> result = new ArrayList<Module>();
        for (Module module : allModules) {
            final IvyIdeaFacet ivyIdeaFacet = FacetManager.getInstance(module).getFacetByType(IvyIdeaFacetType.ID);
            if (ivyIdeaFacet != null) {
                result.add(module);
            }
        }
        return result.toArray(new Module[result.size()]);
    }

    @NotNull
    public static FileType getXmlFileType() {
        return FileTypeManager.getInstance().getFileTypeByExtension("xml");
    }
}
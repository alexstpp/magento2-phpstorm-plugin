/*
 * Copyright © Magento, Inc. All rights reserved.
 * See COPYING.txt for license details.
 */

package com.magento.idea.magento2uct.execution.scanner.data;

import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NotNull;

public class ComponentData {

    private final String name;
    private final String composerName;
    private final String type;
    private final PsiDirectory directory;

    /**
     * Magento component DTO constructor.
     *
     * @param name String
     * @param composerName String
     * @param type String
     * @param directory PsiDirectory
     */
    public ComponentData(
            final @NotNull String name,
            final String composerName,
            final @NotNull String type,
            final @NotNull PsiDirectory directory
    ) {
        this.name = name;
        this.composerName = composerName;
        this.type = type;
        this.directory = directory;
    }

    /**
     * Get module name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Get composer based component name.
     *
     * @return String
     */
    public String getComposerName() {
        return composerName;
    }

    /**
     * Get component type.
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * Get component directory.
     *
     * @return PsiDirectory
     */
    public PsiDirectory getDirectory() {
        return directory;
    }
}

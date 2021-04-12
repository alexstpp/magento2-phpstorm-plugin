/*
 * Copyright © Magento, Inc. All rights reserved.
 * See COPYING.txt for license details.
 */
package com.magento.idea.magento2plugin.actions.generation.generator;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.magento.idea.magento2plugin.actions.generation.data.ProductEntityData;
import com.magento.idea.magento2plugin.magento.packages.eav.AttributeScope;
import com.magento.idea.magento2plugin.magento.packages.eav.AttributeSourceModel;

public class EavAttributeSetupPatchGeneratorTest extends BaseGeneratorTestCase {
    private final static String MODULE_NAME = "Foo_Bar";

    /**
     * Test Data patch for product's eav attribute generator.
     */
    public void testGenerateFile() {
        final Project project = myFixture.getProject();

        final ProductEntityData productEntityData = new ProductEntityData();
        productEntityData.setCode("test");
        productEntityData.setVisibleInGrid(false);
        productEntityData.setHtmlAllowedOnFront(false);
        productEntityData.setVisibleOnFront(false);
        productEntityData.setVisible(true);
        productEntityData.setScope(AttributeScope.GLOBAL.getScope());
        productEntityData.setLabel("Test Label");
        productEntityData.setType("static");
        productEntityData.setUsedInGrid(false);
        productEntityData.setRequired(false);
        productEntityData.setInput("text");
        productEntityData.setFilterableInGrid(false);
        productEntityData.setSortOrder(10);
        productEntityData.setGroup("General");

        productEntityData.setDataPatchName("AddTestAttribute");
        productEntityData.setModuleName(MODULE_NAME);

        final EavAttributeSetupPatchGenerator setupPatchGenerator =
                new EavAttributeSetupPatchGenerator(productEntityData, project);
        final PsiFile dataPatchFile = setupPatchGenerator.generate("testGenerateFile");

        final String filePatch = this.getFixturePath("AddTestAttribute.php");
        final PsiFile expectedFile = myFixture.configureByFile(filePatch);

        assertGeneratedFileIsCorrect(expectedFile, "src/app/code/Foo/Bar/Setup/Patch/Data", dataPatchFile);
    }

    public void testGenerateFileWithBooleanSourceModel() {
        final Project project = myFixture.getProject();

        final ProductEntityData productEntityData = new ProductEntityData();
        productEntityData.setCode("boolean_input_attribute");
        productEntityData.setVisibleInGrid(false);
        productEntityData.setHtmlAllowedOnFront(false);
        productEntityData.setVisibleOnFront(false);
        productEntityData.setVisible(true);
        productEntityData.setScope(AttributeScope.GLOBAL.getScope());
        productEntityData.setLabel("Test Label");
        productEntityData.setType("static");
        productEntityData.setUsedInGrid(false);
        productEntityData.setRequired(false);
        productEntityData.setInput("boolean");
        productEntityData.setSource(AttributeSourceModel.BOOLEAN.getSource());
        productEntityData.setFilterableInGrid(false);
        productEntityData.setSortOrder(10);
        productEntityData.setGroup("General");

        productEntityData.setDataPatchName("AddBooleanInputAttributeAttribute");
        productEntityData.setModuleName(MODULE_NAME);

        final EavAttributeSetupPatchGenerator setupPatchGenerator =
                new EavAttributeSetupPatchGenerator(productEntityData, project);
        final PsiFile dataPatchFile = setupPatchGenerator.generate("testGenerateFileWithBooleanSourceModel");

        final String filePatch = this.getFixturePath("AddBooleanInputAttributeAttribute.php");
        final PsiFile expectedFile = myFixture.configureByFile(filePatch);

        assertGeneratedFileIsCorrect(expectedFile, "src/app/code/Foo/Bar/Setup/Patch/Data", dataPatchFile);
    }

    public void testGenerateFileWithGeneratedSourceModel() {
        final Project project = myFixture.getProject();

        final ProductEntityData productEntityData = new ProductEntityData();
        productEntityData.setCode("attribute_with_custom_source");
        productEntityData.setVisibleInGrid(false);
        productEntityData.setHtmlAllowedOnFront(false);
        productEntityData.setVisibleOnFront(false);
        productEntityData.setVisible(true);
        productEntityData.setScope(AttributeScope.GLOBAL.getScope());
        productEntityData.setLabel("Test Label");
        productEntityData.setType("static");
        productEntityData.setUsedInGrid(false);
        productEntityData.setRequired(false);
        productEntityData.setInput("text");
        productEntityData.setSource("\\Foo\\Bar\\Model\\Source\\AttributeWithCustomSource");
        productEntityData.setFilterableInGrid(false);
        productEntityData.setSortOrder(10);
        productEntityData.setGroup("General");

        productEntityData.setDataPatchName("AddAttributeWithCustomSourceAttribute");
        productEntityData.setModuleName(MODULE_NAME);

        final EavAttributeSetupPatchGenerator setupPatchGenerator =
                new EavAttributeSetupPatchGenerator(productEntityData, project);
        final PsiFile dataPatchFile = setupPatchGenerator.generate("testGenerateFileWithBooleanSourceModel");

        final String filePatch = this.getFixturePath("AddAttributeWithCustomSourceAttribute.php");
        final PsiFile expectedFile = myFixture.configureByFile(filePatch);

        assertGeneratedFileIsCorrect(expectedFile, "src/app/code/Foo/Bar/Setup/Patch/Data", dataPatchFile);
    }
}
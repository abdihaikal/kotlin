/*
 * Copyright 2010-2014 JetBrains s.r.o.
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

package org.jetbrains.jet.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.jet.context.GlobalContext;
import org.jetbrains.jet.storage.StorageManager;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptorImpl;
import org.jetbrains.jet.lang.PlatformToKotlinClassMap;
import org.jetbrains.jet.lang.resolve.TopDownAnalyzer;
import org.jetbrains.jet.lang.resolve.MutablePackageFragmentProvider;
import org.jetbrains.jet.lang.types.DependencyClassByQualifiedNameResolverDummyImpl;
import org.jetbrains.jet.lang.resolve.BodyResolver;
import org.jetbrains.jet.lang.resolve.AnnotationResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolver;
import org.jetbrains.jet.lang.resolve.calls.ArgumentTypeResolver;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingServices;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingComponents;
import org.jetbrains.jet.lang.types.expressions.ControlStructureTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ForLoopConventionsChecker;
import org.jetbrains.jet.lang.resolve.calls.CallExpressionResolver;
import org.jetbrains.jet.lang.resolve.DescriptorResolver;
import org.jetbrains.jet.lang.resolve.DelegatedPropertyResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver;
import org.jetbrains.jet.lang.resolve.QualifiedExpressionResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolverExtensionProvider;
import org.jetbrains.jet.lang.resolve.calls.CandidateResolver;
import org.jetbrains.jet.lang.resolve.ControlFlowAnalyzer;
import org.jetbrains.jet.lang.resolve.DeclarationsChecker;
import org.jetbrains.jet.lang.resolve.FunctionAnalyzerExtension;
import org.jetbrains.jet.lang.resolve.ScriptBodyResolver;
import org.jetbrains.jet.lang.resolve.DeclarationResolver;
import org.jetbrains.jet.lang.resolve.ImportsResolver;
import org.jetbrains.jet.lang.psi.JetImportsFactory;
import org.jetbrains.jet.lang.resolve.ScriptHeaderResolver;
import org.jetbrains.jet.lang.resolve.OverloadResolver;
import org.jetbrains.jet.lang.resolve.OverrideResolver;
import org.jetbrains.jet.lang.resolve.TypeHierarchyResolver;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.InjectorsPackage. DO NOT EDIT! */
@SuppressWarnings("ALL")
public class InjectorForTopDownAnalyzerBasic {
    
    private final Project project;
    private final GlobalContext globalContext;
    private final StorageManager storageManager;
    private final BindingTrace bindingTrace;
    private final ModuleDescriptorImpl moduleDescriptor;
    private final PlatformToKotlinClassMap platformToKotlinClassMap;
    private final TopDownAnalyzer topDownAnalyzer;
    private final MutablePackageFragmentProvider mutablePackageFragmentProvider;
    private final DependencyClassByQualifiedNameResolverDummyImpl dependencyClassByQualifiedNameResolverDummy;
    private final BodyResolver bodyResolver;
    private final AnnotationResolver annotationResolver;
    private final CallResolver callResolver;
    private final ArgumentTypeResolver argumentTypeResolver;
    private final ExpressionTypingServices expressionTypingServices;
    private final ExpressionTypingComponents expressionTypingComponents;
    private final ControlStructureTypingUtils controlStructureTypingUtils;
    private final ExpressionTypingUtils expressionTypingUtils;
    private final ForLoopConventionsChecker forLoopConventionsChecker;
    private final CallExpressionResolver callExpressionResolver;
    private final DescriptorResolver descriptorResolver;
    private final DelegatedPropertyResolver delegatedPropertyResolver;
    private final TypeResolver typeResolver;
    private final QualifiedExpressionResolver qualifiedExpressionResolver;
    private final CallResolverExtensionProvider callResolverExtensionProvider;
    private final CandidateResolver candidateResolver;
    private final ControlFlowAnalyzer controlFlowAnalyzer;
    private final DeclarationsChecker declarationsChecker;
    private final FunctionAnalyzerExtension functionAnalyzerExtension;
    private final ScriptBodyResolver scriptBodyResolver;
    private final DeclarationResolver declarationResolver;
    private final ImportsResolver importsResolver;
    private final JetImportsFactory jetImportsFactory;
    private final ScriptHeaderResolver scriptHeaderResolver;
    private final OverloadResolver overloadResolver;
    private final OverrideResolver overrideResolver;
    private final TypeHierarchyResolver typeHierarchyResolver;
    
    public InjectorForTopDownAnalyzerBasic(
        @NotNull Project project,
        @NotNull GlobalContext globalContext,
        @NotNull BindingTrace bindingTrace,
        @NotNull ModuleDescriptorImpl moduleDescriptor
    ) {
        this.project = project;
        this.globalContext = globalContext;
        this.storageManager = globalContext.getStorageManager();
        this.bindingTrace = bindingTrace;
        this.moduleDescriptor = moduleDescriptor;
        this.platformToKotlinClassMap = moduleDescriptor.getPlatformToKotlinClassMap();
        this.topDownAnalyzer = new TopDownAnalyzer();
        this.mutablePackageFragmentProvider = new MutablePackageFragmentProvider(getModuleDescriptor());
        this.dependencyClassByQualifiedNameResolverDummy = new DependencyClassByQualifiedNameResolverDummyImpl();
        this.bodyResolver = new BodyResolver();
        this.annotationResolver = new AnnotationResolver();
        this.callResolver = new CallResolver();
        this.argumentTypeResolver = new ArgumentTypeResolver();
        this.expressionTypingComponents = new ExpressionTypingComponents();
        this.expressionTypingServices = new ExpressionTypingServices(expressionTypingComponents);
        this.controlStructureTypingUtils = new ControlStructureTypingUtils(expressionTypingServices);
        this.expressionTypingUtils = new ExpressionTypingUtils(expressionTypingServices, callResolver);
        this.forLoopConventionsChecker = new ForLoopConventionsChecker();
        this.callExpressionResolver = new CallExpressionResolver();
        this.descriptorResolver = new DescriptorResolver();
        this.delegatedPropertyResolver = new DelegatedPropertyResolver();
        this.typeResolver = new TypeResolver();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.callResolverExtensionProvider = new CallResolverExtensionProvider();
        this.candidateResolver = new CandidateResolver();
        this.controlFlowAnalyzer = new ControlFlowAnalyzer();
        this.declarationsChecker = new DeclarationsChecker();
        this.functionAnalyzerExtension = new FunctionAnalyzerExtension();
        this.scriptBodyResolver = new ScriptBodyResolver();
        this.declarationResolver = new DeclarationResolver();
        this.importsResolver = new ImportsResolver();
        this.jetImportsFactory = new JetImportsFactory();
        this.scriptHeaderResolver = new ScriptHeaderResolver();
        this.overloadResolver = new OverloadResolver();
        this.overrideResolver = new OverrideResolver();
        this.typeHierarchyResolver = new TypeHierarchyResolver();

        this.topDownAnalyzer.setBodyResolver(bodyResolver);
        this.topDownAnalyzer.setDeclarationResolver(declarationResolver);
        this.topDownAnalyzer.setModuleDescriptor(moduleDescriptor);
        this.topDownAnalyzer.setOverloadResolver(overloadResolver);
        this.topDownAnalyzer.setOverrideResolver(overrideResolver);
        this.topDownAnalyzer.setPackageFragmentProvider(mutablePackageFragmentProvider);
        this.topDownAnalyzer.setTrace(bindingTrace);
        this.topDownAnalyzer.setTypeHierarchyResolver(typeHierarchyResolver);

        bodyResolver.setAnnotationResolver(annotationResolver);
        bodyResolver.setCallResolver(callResolver);
        bodyResolver.setControlFlowAnalyzer(controlFlowAnalyzer);
        bodyResolver.setDeclarationsChecker(declarationsChecker);
        bodyResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        bodyResolver.setExpressionTypingServices(expressionTypingServices);
        bodyResolver.setFunctionAnalyzerExtension(functionAnalyzerExtension);
        bodyResolver.setScriptBodyResolverResolver(scriptBodyResolver);
        bodyResolver.setTrace(bindingTrace);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setExpressionTypingServices(expressionTypingServices);

        callResolver.setArgumentTypeResolver(argumentTypeResolver);
        callResolver.setCandidateResolver(candidateResolver);
        callResolver.setExpressionTypingServices(expressionTypingServices);
        callResolver.setTypeResolver(typeResolver);

        argumentTypeResolver.setExpressionTypingServices(expressionTypingServices);
        argumentTypeResolver.setTypeResolver(typeResolver);

        expressionTypingServices.setAnnotationResolver(annotationResolver);
        expressionTypingServices.setCallExpressionResolver(callExpressionResolver);
        expressionTypingServices.setCallResolver(callResolver);
        expressionTypingServices.setDescriptorResolver(descriptorResolver);
        expressionTypingServices.setExtensionProvider(callResolverExtensionProvider);
        expressionTypingServices.setProject(project);
        expressionTypingServices.setTypeResolver(typeResolver);

        expressionTypingComponents.setCallResolver(callResolver);
        expressionTypingComponents.setControlStructureTypingUtils(controlStructureTypingUtils);
        expressionTypingComponents.setExpressionTypingServices(expressionTypingServices);
        expressionTypingComponents.setExpressionTypingUtils(expressionTypingUtils);
        expressionTypingComponents.setForLoopConventionsChecker(forLoopConventionsChecker);
        expressionTypingComponents.setGlobalContext(globalContext);
        expressionTypingComponents.setPlatformToKotlinClassMap(platformToKotlinClassMap);

        forLoopConventionsChecker.setExpressionTypingServices(expressionTypingServices);
        forLoopConventionsChecker.setExpressionTypingUtils(expressionTypingUtils);
        forLoopConventionsChecker.setProject(project);

        callExpressionResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setStorageManager(storageManager);
        descriptorResolver.setTypeResolver(typeResolver);

        delegatedPropertyResolver.setCallResolver(callResolver);
        delegatedPropertyResolver.setExpressionTypingServices(expressionTypingServices);

        typeResolver.setAnnotationResolver(annotationResolver);
        typeResolver.setModuleDescriptor(moduleDescriptor);
        typeResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);

        candidateResolver.setArgumentTypeResolver(argumentTypeResolver);

        controlFlowAnalyzer.setTrace(bindingTrace);

        declarationsChecker.setTrace(bindingTrace);

        functionAnalyzerExtension.setTrace(bindingTrace);

        scriptBodyResolver.setExpressionTypingServices(expressionTypingServices);
        scriptBodyResolver.setTrace(bindingTrace);

        declarationResolver.setAnnotationResolver(annotationResolver);
        declarationResolver.setDescriptorResolver(descriptorResolver);
        declarationResolver.setImportsResolver(importsResolver);
        declarationResolver.setScriptHeaderResolver(scriptHeaderResolver);
        declarationResolver.setTrace(bindingTrace);

        importsResolver.setImportsFactory(jetImportsFactory);
        importsResolver.setModuleDescriptor(moduleDescriptor);
        importsResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);
        importsResolver.setTrace(bindingTrace);

        jetImportsFactory.setProject(project);

        scriptHeaderResolver.setDependencyClassByQualifiedNameResolver(dependencyClassByQualifiedNameResolverDummy);
        scriptHeaderResolver.setPackageFragmentProvider(mutablePackageFragmentProvider);
        scriptHeaderResolver.setTrace(bindingTrace);

        overloadResolver.setTrace(bindingTrace);

        overrideResolver.setTrace(bindingTrace);

        typeHierarchyResolver.setDescriptorResolver(descriptorResolver);
        typeHierarchyResolver.setImportsResolver(importsResolver);
        typeHierarchyResolver.setPackageFragmentProvider(mutablePackageFragmentProvider);
        typeHierarchyResolver.setScriptHeaderResolver(scriptHeaderResolver);
        typeHierarchyResolver.setTrace(bindingTrace);

    }
    
    @PreDestroy
    public void destroy() {
    }
    
    public ModuleDescriptorImpl getModuleDescriptor() {
        return this.moduleDescriptor;
    }
    
    public TopDownAnalyzer getTopDownAnalyzer() {
        return this.topDownAnalyzer;
    }
    
}

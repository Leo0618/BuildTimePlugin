package com.leo618.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class PluginImpl implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.gradle.addListener(new BuildTimeListener())
    }
}

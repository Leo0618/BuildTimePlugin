package com.leo618.gradle.plugin

import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState
import org.gradle.util.Clock

class BuildTimeListener implements TaskExecutionListener, BuildListener {
    private Clock mClock
    private mBuildTimesActionsList = []

    @Override
    void beforeExecute(Task task) {
        mClock = new Clock()
    }

    @Override
    void afterExecute(Task task, TaskState taskState) {
        def ms = mClock.timeInMs
        mBuildTimesActionsList.add([ms, task.path])
    }

    @Override
    void buildFinished(BuildResult result) {
        println "Build Tasks 耗时详情:"
        for (time in mBuildTimesActionsList) {
            if (time[0] >= 10) {
                printf "%10sms  %s\n", time
            }
        }
    }

    @Override
    void buildStarted(Gradle gradle) {
    }

    @Override
    void projectsEvaluated(Gradle gradle) {}

    @Override
    void projectsLoaded(Gradle gradle) {}

    @Override
    void settingsEvaluated(Settings settings) {}
}

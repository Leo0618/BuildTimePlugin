# BuildTimePlugin
an android studio gradle plugin for show builded tasks time detail.


##Usage

**Step1:** 项目根目录文件build.gradle中加入如下

	buildscript {
	    repositories {
	        jcenter()
	    }
	    dependencies {
	        classpath 'com.leo618.gradle.plugin:buildtime:0.0.1'
	    }
	}

	allprojects {
	    repositories {
	        jcenter()
	    }
	}


**Step2:** app目录下文件build.gradle中使用插件

	apply plugin: 'buildtime'

Enjoy！！！

每次同步或者编译项目完成都会在Gradle Console里面打印Build Tasks 耗时详情.

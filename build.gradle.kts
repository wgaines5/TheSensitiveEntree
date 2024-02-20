buildscript {
    val agp_version1 by extra("8.2.2")
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    // Fire base dependency
    id("com.google.gms.google-services") version "4.4.1" apply false
}
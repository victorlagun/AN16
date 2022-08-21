package com.example.background;

import java.lang.System;

@kotlin.jvm.JvmName(name = "Constants")
@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"CHANNEL_ID", "", "DELAY_TIME_MILLIS", "", "IMAGE_MANIPULATION_WORK_NAME", "KEY_IMAGE_URI", "NOTIFICATION_ID", "", "NOTIFICATION_TITLE", "", "OUTPUT_PATH", "TAG_OUTPUT", "VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION", "VERBOSE_NOTIFICATION_CHANNEL_NAME", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmField()
    public static final java.lang.CharSequence VERBOSE_NOTIFICATION_CHANNEL_NAME = "Verbose WorkManager Notifications";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION = "Shows notifications whenever work starts";
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmField()
    public static final java.lang.CharSequence NOTIFICATION_TITLE = "WorkRequest Starting";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "VERBOSE_NOTIFICATION";
    public static final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_MANIPULATION_WORK_NAME = "image_manipulation_work";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OUTPUT_PATH = "blur_filter_outputs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_IMAGE_URI = "KEY_IMAGE_URI";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG_OUTPUT = "OUTPUT";
    public static final long DELAY_TIME_MILLIS = 3000L;
}
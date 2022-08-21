package com.example.background;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0017\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000\u00a2\u0006\u0002\b\rJ\u0014\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010 H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/example/background/BlurViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "imageUri", "Landroid/net/Uri;", "getImageUri$app_debug", "()Landroid/net/Uri;", "setImageUri$app_debug", "(Landroid/net/Uri;)V", "outputUri", "getOutputUri$app_debug", "setOutputUri$app_debug", "worker", "Landroidx/work/WorkManager;", "getWorker", "()Landroidx/work/WorkManager;", "setWorker", "(Landroidx/work/WorkManager;)V", "applyBlur", "", "blurLevel", "", "applyBlur$app_debug", "createInputDataForUri", "Landroidx/work/Data;", "getImageUri", "context", "Landroid/content/Context;", "setOutputUri", "outputImageUri", "", "uriOrNull", "uriString", "BlurViewModelFactory", "app_debug"})
public final class BlurViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri imageUri;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri outputUri;
    @org.jetbrains.annotations.NotNull()
    private androidx.work.WorkManager worker;
    
    public BlurViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getImageUri$app_debug() {
        return null;
    }
    
    public final void setImageUri$app_debug(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getOutputUri$app_debug() {
        return null;
    }
    
    public final void setOutputUri$app_debug(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.work.WorkManager getWorker() {
        return null;
    }
    
    public final void setWorker(@org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager p0) {
    }
    
    /**
     * Create the WorkRequest to apply the blur and save the resulting image
     * @param blurLevel The amount to blur the image
     */
    public final void applyBlur$app_debug(int blurLevel) {
    }
    
    private final androidx.work.Data createInputDataForUri() {
        return null;
    }
    
    private final android.net.Uri uriOrNull(java.lang.String uriString) {
        return null;
    }
    
    private final android.net.Uri getImageUri(android.content.Context context) {
        return null;
    }
    
    public final void setOutputUri$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String outputImageUri) {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/background/BlurViewModel$BlurViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class BlurViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
        private final android.app.Application application = null;
        
        public BlurViewModelFactory(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}
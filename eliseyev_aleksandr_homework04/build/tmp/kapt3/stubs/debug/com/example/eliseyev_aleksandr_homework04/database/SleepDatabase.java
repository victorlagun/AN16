package com.example.eliseyev_aleksandr_homework04.database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.eliseyev_aleksandr_homework04.database.SleepNight.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/example/eliseyev_aleksandr_homework04/database/SleepDatabase;", "Landroidx/room/RoomDatabase;", "()V", "sleepDatabaseDao", "Lcom/example/eliseyev_aleksandr_homework04/database/SleepDatabaseDao;", "getSleepDatabaseDao", "()Lcom/example/eliseyev_aleksandr_homework04/database/SleepDatabaseDao;", "Companion", "eliseyev_aleksandr_homework04_debug"})
public abstract class SleepDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.eliseyev_aleksandr_homework04.database.SleepDatabase.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.example.eliseyev_aleksandr_homework04.database.SleepDatabase INSTANCE;
    
    public SleepDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.eliseyev_aleksandr_homework04.database.SleepDatabaseDao getSleepDatabaseDao();
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/eliseyev_aleksandr_homework04/database/SleepDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/eliseyev_aleksandr_homework04/database/SleepDatabase;", "getInstance", "context", "Landroid/content/Context;", "eliseyev_aleksandr_homework04_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.eliseyev_aleksandr_homework04.database.SleepDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}
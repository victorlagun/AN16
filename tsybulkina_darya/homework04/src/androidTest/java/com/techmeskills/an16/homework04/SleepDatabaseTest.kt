/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techmeskills.an16.homework04

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.Update
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.techmeskills.an16.homework04.database.SleepDatabaseDao
import com.techmeskills.an16.homework04.database.SleepDatabase
import com.techmeskills.an16.homework04.database.SleepNight
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@RunWith(AndroidJUnit4::class)
class SleepDatabaseTest {

    private lateinit var sleepDao: SleepDatabaseDao
    private lateinit var db: SleepDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, SleepDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        sleepDao = db.sleepDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val night = SleepNight()
        sleepDao.insert(night)
        val tonight = sleepDao.getTonight()
        assertEquals(tonight?.sleepQuality, -1)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAll() {
        val night = SleepNight()
        sleepDao.insert(night)
        sleepDao.clear()
        assertNull(sleepDao.get(0))
    }

    @Test
    @Throws(Exception::class)
    fun getAllNight() {
        val night = SleepNight()
        sleepDao.insert(night)
        assertNotNull(sleepDao.getAllNight() )
    }

    @Test
    @Throws(Exception::class)
    fun update() {
        val night = SleepNight()
        sleepDao.insert(night)
        night.sleepQuality = 5
        sleepDao.get(0)?.let { assertEquals(it.sleepQuality, 5) }
    }

    @Test
    @Throws(Exception::class)
    fun get() {
        sleepDao.get(1)?.let { assertEquals(it.nightId, 1) }
    }
//    @Insert
//    fun insert(night: SleepNight)
//    @Update
//    fun update(night: SleepNight)
//    @Query("SELECT * from daily_sleep_quality_table WHERE nightId = :key")
//    fun get(key:Long): SleepNight?
//    @Query("DELETE FROM daily_sleep_quality_table")
//    fun clear()
//    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
//    fun getTonight():SleepNight?
//    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
//    fun getAllNight(): LiveData<List<SleepNight>>
}
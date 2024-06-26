package com.fylora.emilytodo.di

import android.content.Context
import androidx.room.Room
import com.fylora.emilytodo.data.local.TaskDatabase
import com.fylora.emilytodo.data.repository.TaskRepositoryImpl
import com.fylora.emilytodo.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTaskDatabase(
        @ApplicationContext
        context: Context
    ): TaskDatabase {
        return Room.databaseBuilder(
            context = context,
            TaskDatabase::class.java,
            name = "task_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(taskDatabase: TaskDatabase): TaskRepository {
        return TaskRepositoryImpl(taskDatabase.taskDao)
    }
}
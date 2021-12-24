package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) // The OnConflictStrategy.IGNORE strategy ignores a new item if it's primary key is already in the database.
    suspend fun insert(item : Item) // Make the function a suspend function, so that this function can be called from a coroutine.

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id: Int) : Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>
}
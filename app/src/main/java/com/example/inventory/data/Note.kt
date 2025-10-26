// Note.kt
package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Entidad de la base de datos que representa una nota.
 * Se asume que se añadirán 'createdAt' y 'dueAt' en un futuro para el ordenamiento,
 * ya que los campos redundantes de fecha/hora se han evitado/quitado.
 */
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,          // Título de la nota
    val content: String,        // Contenido de la nota
    val multimediaUris: List<String> // URIs de imágenes, audio, o videos
)

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int): Flow<Note?>  // Obtenemos la nota por ID

}
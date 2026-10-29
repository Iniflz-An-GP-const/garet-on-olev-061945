package anuvix.garetonolev.hubapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import anuvix.garetonolev.hubapp.data.database.converter.Converters
import anuvix.garetonolev.hubapp.data.database.dao.HighScoreDao
import anuvix.garetonolev.hubapp.data.entity.HighScore

@Database(
    entities = [HighScore::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AXOVPAppDatabase : RoomDatabase() {

    abstract fun highScoreDao(): HighScoreDao
}

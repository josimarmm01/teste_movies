package com.example.teste_pratico.model

import android.os.Parcelable
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import kotlinx.android.parcel.Parcelize

@Parcelize
@DatabaseTable(tableName = "filme")
class FilmeDados(
    @DatabaseField(columnName = "id")
    var id: String = "",
    @DatabaseField(columnName = "poster_path")
    var poster_path: String = "",
    @DatabaseField(columnName = "backdrop_path")
    var backdrop_path: String = "",
    @DatabaseField(columnName = "overview")
    var overview: String = "",
    @DatabaseField(columnName = "release_date")
    var release_date: String = "",
    @DatabaseField(columnName = "title")
    var title: String = "",
    @DatabaseField(columnName = "generos")
    var generos: String = ""
) : Parcelable
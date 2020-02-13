package com.example.teste_pratico.model

import android.os.Parcelable
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.field.ForeignCollectionField
import com.j256.ormlite.table.DatabaseTable
import kotlinx.android.parcel.Parcelize

class Filme (
    var id: String,
    var poster_path: String,
    var backdrop_path: String,
    var overview: String,
    var release_date: String,
    var title: String,
    var genre_ids: List<String>
)





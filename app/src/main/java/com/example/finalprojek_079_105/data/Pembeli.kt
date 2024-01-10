package com.example.finalprojek_079_105.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblPembeli")
class Pembeli (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val alamat : String,
    val telpon : String,
    val email : String,
    val payment : String
)
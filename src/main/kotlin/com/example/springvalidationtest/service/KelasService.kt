package com.example.springvalidationtest.service

import com.example.springvalidationtest.dto.request.ReqKelas
import com.example.springvalidationtest.entity.Kelas

interface KelasService {

    fun saveKelas(kelas: ReqKelas): Kelas

    fun getAllKelas(): List<Kelas>

    fun getKelasById(id: Int): Kelas

    fun updateKelas(id: Int, kelas: ReqKelas): Kelas

    fun deleteKelasById(id: Int)
}
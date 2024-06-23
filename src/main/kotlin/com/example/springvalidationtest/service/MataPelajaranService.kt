package com.example.springvalidationtest.service

import com.example.springvalidationtest.dto.request.ReqMataPelajaran
import com.example.springvalidationtest.entity.MataPelajaran

interface MataPelajaranService {

    fun saveMapel(mapel: ReqMataPelajaran): MataPelajaran

    fun getAllMapel(): List<MataPelajaran>

    fun getMapelById(id: Int): MataPelajaran

    fun updateMapel(id: Int, mapel: ReqMataPelajaran): MataPelajaran

    fun deleteMapel(id: Int)
}
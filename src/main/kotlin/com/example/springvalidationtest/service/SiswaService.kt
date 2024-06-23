package com.example.springvalidationtest.service

import com.example.springvalidationtest.dto.request.ReqSiswa
import com.example.springvalidationtest.entity.Siswa

interface SiswaService {

    fun saveSiswa(siswa: ReqSiswa): Siswa

    fun updateSiswa(id: Int, siswa: ReqSiswa): Siswa

    fun getAllSiswa(): List<Siswa>

    fun getSiswa(id: Int): Siswa

    fun delete(id: Int)
}
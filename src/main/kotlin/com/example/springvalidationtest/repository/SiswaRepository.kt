package com.example.springvalidationtest.repository

import com.example.springvalidationtest.entity.Siswa
import org.springframework.data.jpa.repository.JpaRepository

interface SiswaRepository: JpaRepository<Siswa, Int> {

    fun existsSiswaByNik(nik: String): Boolean
}
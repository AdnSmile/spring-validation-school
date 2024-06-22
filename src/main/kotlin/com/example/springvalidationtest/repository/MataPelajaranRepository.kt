package com.example.springvalidationtest.repository

import com.example.springvalidationtest.entity.MataPelajaran
import org.springframework.data.jpa.repository.JpaRepository

interface MataPelajaranRepository: JpaRepository<MataPelajaran, Int> {

    fun existsByNamaMataPelajaran(name: String): Boolean
}
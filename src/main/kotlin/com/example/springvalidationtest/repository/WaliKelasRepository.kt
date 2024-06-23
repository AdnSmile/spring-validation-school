package com.example.springvalidationtest.repository

import com.example.springvalidationtest.entity.WaliKelas
import org.springframework.data.jpa.repository.JpaRepository

interface WaliKelasRepository: JpaRepository<WaliKelas, Int> {

    fun existsByNama(nama: String): Boolean
}
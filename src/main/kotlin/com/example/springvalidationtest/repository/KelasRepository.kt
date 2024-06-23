package com.example.springvalidationtest.repository

import com.example.springvalidationtest.entity.Kelas
import com.example.springvalidationtest.entity.WaliKelas
import org.springframework.data.jpa.repository.JpaRepository

interface KelasRepository: JpaRepository<Kelas, Int> {

    fun existsByNamaKelas(nama: String): Boolean

    fun existsKelasByWaliKelas(waliKelas: WaliKelas): Boolean

}
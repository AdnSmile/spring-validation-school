package com.example.springvalidationtest.service.impl

import com.example.springvalidationtest.dto.request.ReqKelas
import com.example.springvalidationtest.entity.Kelas
import com.example.springvalidationtest.exception.DuplicateException
import com.example.springvalidationtest.exception.NotFoundException
import com.example.springvalidationtest.repository.KelasRepository
import com.example.springvalidationtest.repository.WaliKelasRepository
import com.example.springvalidationtest.service.KelasService
import com.example.springvalidationtest.validation.ValidationUtil
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class KelasServiceImpl(
    val kelasRepository: KelasRepository,
    val validationUtil: ValidationUtil,
    val waliKelasRepository: WaliKelasRepository
): KelasService {

    override fun saveKelas(kelas: ReqKelas): Kelas {

        validationUtil.validate(kelas)

        if (kelasRepository.existsByNamaKelas(kelas.namaKelas!!)) {
            throw DuplicateException("Nama kelas sudah ada")
        }

        val waliKelas = waliKelasRepository.findById(kelas.idWaliKelas!!)

        if (!waliKelas.isPresent) {
            throw NotFoundException("Wali kelas tidak ditemukan")
        }

        // cek wali kelas apakah sudah jadi wali kelas untuk kelas lain
        if (kelasRepository.existsKelasByWaliKelas(waliKelas.get())) {
            throw DuplicateException("${waliKelas.get().nama} sudah menjadi Wali kelas dari kelas lain")
        }

        val data = Kelas(
            namaKelas = kelas.namaKelas,
            waliKelas = waliKelas.get(),
            siswa = null
        )

        kelasRepository.save(data)

        return data
    }

    override fun getAllKelas(): List<Kelas> {

        return kelasRepository.findAll()
    }

    override fun getKelasById(id: Int): Kelas {

        return findById(id)
    }

    override fun updateKelas(id: Int, kelas: ReqKelas): Kelas {

        val getKelas = findById(id)

        validationUtil.validate(kelas)

        val getWaliKelas = waliKelasRepository.findById(kelas.idWaliKelas!!)

        if (!getWaliKelas.isPresent) {
            throw NotFoundException("Wali kelas tidak ditemukan")
        }

        // cek wali kelas apakah sudah jadi wali kelas untuk kelas lain
        if (kelasRepository.existsKelasByWaliKelas(getWaliKelas.get())) {
            throw DuplicateException("${getWaliKelas.get().nama} sudah menjadi Wali kelas dari kelas lain")
        }

        getKelas.apply {
            namaKelas = kelas.namaKelas
            waliKelas = getWaliKelas.get()
        }

        kelasRepository.save(getKelas)

        return getKelas
    }

    @Transactional
    override fun deleteKelasById(id: Int) {

        // jika terdapat relasi antar table adalah 1 on 1
        // maka hapus terlebih dahulu  referensi kelasnya

        val getKelas = findById(id)

        getKelas.waliKelas?.let {
            it.kelas = null
            waliKelasRepository.save(it)
        }

        kelasRepository.delete(getKelas)
    }

    private fun findById(id: Int): Kelas {

        return kelasRepository.findByIdOrNull(id) ?: throw NotFoundException("Kelas dengan id $id tidak ditemukan")
    }
}
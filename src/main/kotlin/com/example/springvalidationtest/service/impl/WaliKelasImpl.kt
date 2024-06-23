package com.example.springvalidationtest.service.impl

import com.example.springvalidationtest.dto.request.ReqWaliKelas
import com.example.springvalidationtest.entity.WaliKelas
import com.example.springvalidationtest.exception.DuplicateException
import com.example.springvalidationtest.exception.NotFoundException
import com.example.springvalidationtest.repository.MataPelajaranRepository
import com.example.springvalidationtest.repository.WaliKelasRepository
import com.example.springvalidationtest.service.WaliKelasService
import com.example.springvalidationtest.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class WaliKelasImpl(
    val waliKelasRepository: WaliKelasRepository,
    val mapelRepository: MataPelajaranRepository,
    val validationUtil: ValidationUtil
): WaliKelasService {

    override fun saveWaliKelas(waliKelas: ReqWaliKelas): WaliKelas {

        validationUtil.validate(waliKelas)

        if (waliKelasRepository.existsByNama(waliKelas.nama!!)) {
            throw DuplicateException("Nama Wali Kelas sudah ada")
        }

        val mapel = mapelRepository.findById(waliKelas.idMataPelajaran!!)

        if (!mapel.isPresent) {
            throw NotFoundException("Mata pelajaran tidak ditemukan")
        }

        val data = WaliKelas(
            nama = waliKelas.nama,
            jenisKelamin = waliKelas.jenisKelamin,
            mataPelajaran = mapel.get(),
            kelas = null
        )

        waliKelasRepository.save(data)

        return data
    }

    override fun getAllWaliKelas(): List<WaliKelas> {

        return waliKelasRepository.findAll()
    }

    override fun getWaliKelasById(id: Int): WaliKelas {

        return findById(id)
    }

    override fun updateWaliKelas(id: Int, waliKelas: ReqWaliKelas): WaliKelas {

        val getWaliKeas = findById(id)

        validationUtil.validate(waliKelas)

        val mapel = mapelRepository.findById(waliKelas.idMataPelajaran!!)

        if (!mapel.isPresent) {
            throw NotFoundException("Mata pelajaran tidak ditemukan")
        }

        getWaliKeas.apply {
            nama = waliKelas.nama
            jenisKelamin = waliKelas.jenisKelamin
            mataPelajaran = mapel.get()
        }

        waliKelasRepository.save(getWaliKeas)

        return getWaliKeas
    }

    override fun deleteWaliKelas(id: Int) {

        val getWaliKelas = findById(id)

        waliKelasRepository.delete(getWaliKelas)
    }

    private fun findById(id: Int): WaliKelas {
        return waliKelasRepository.findByIdOrNull(id) ?: throw NotFoundException("Wali kelas dengan id $id tidak ditemukan")
    }

}
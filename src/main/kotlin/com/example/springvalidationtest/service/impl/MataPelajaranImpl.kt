package com.example.springvalidationtest.service.impl

import com.example.springvalidationtest.dto.request.ReqMataPelajaran
import com.example.springvalidationtest.entity.MataPelajaran
import com.example.springvalidationtest.exception.DuplicateException
import com.example.springvalidationtest.exception.NotFoundException
import com.example.springvalidationtest.repository.MataPelajaranRepository
import com.example.springvalidationtest.service.MataPelajaranService
import com.example.springvalidationtest.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MataPelajaranImpl(
    val mapelRepository: MataPelajaranRepository,
    val validationUtil: ValidationUtil
) : MataPelajaranService {

    override fun saveMapel(mapel: ReqMataPelajaran): MataPelajaran {

        validationUtil.validate(mapel)

        if (mapelRepository.existsByNamaMataPelajaran(mapel.namaMataPelajaran!!)) {
            throw DuplicateException("Mata Pelajaran sudah ada")
        }

        val data = MataPelajaran(
            namaMataPelajaran = mapel.namaMataPelajaran,
            waliKelas = null
        )

        mapelRepository.save(data)

        return data
    }

    override fun getAllMapel(): List<MataPelajaran> {

        val allMapel = mapelRepository.findAll()

        return allMapel
    }

    override fun getMapelById(id: Int): MataPelajaran {

        val mapel = findById(id)

        return mapel
    }

    override fun updateMapel(id: Int, mapel: ReqMataPelajaran): MataPelajaran {

        val getMapel = findById(id)

        validationUtil.validate(mapel)

        if (mapelRepository.existsByNamaMataPelajaran(mapel.namaMataPelajaran!!)) {
            throw DuplicateException("Mata Pelajaran sudah ada")
        }

        getMapel.apply {
            namaMataPelajaran = mapel.namaMataPelajaran
        }

        mapelRepository.save(getMapel)

        return getMapel
    }

    override fun deleteMapel(id: Int) {

        val getMapel = findById(id)

        mapelRepository.delete(getMapel)
    }

    private fun findById(id: Int): MataPelajaran {
        return mapelRepository.findByIdOrNull(id) ?: throw NotFoundException("Mata Pelajaran dengan id: $id tidak ditemukan")
    }
}
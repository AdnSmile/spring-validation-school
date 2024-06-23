package com.example.springvalidationtest.service.impl

import com.example.springvalidationtest.dto.request.ReqSiswa
import com.example.springvalidationtest.entity.Siswa
import com.example.springvalidationtest.entity.WaliKelas
import com.example.springvalidationtest.exception.DuplicateException
import com.example.springvalidationtest.exception.NotFoundException
import com.example.springvalidationtest.repository.KelasRepository
import com.example.springvalidationtest.repository.SiswaRepository
import com.example.springvalidationtest.service.SiswaService
import com.example.springvalidationtest.validation.ValidationUtil
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SiswaServiceImpl(
    val siswaRepository: SiswaRepository,
    val kelasRepository: KelasRepository,
    var validationUtil: ValidationUtil
): SiswaService {

    @Transactional
    override fun saveSiswa(siswa: ReqSiswa): Siswa {

        validationUtil.validate(siswa)

        if (siswaRepository.existsSiswaByNik(siswa.nik!!)) {
            throw DuplicateException("Nik sudah ada")
        }

        val kelas = kelasRepository.findById(siswa.idKelas!!)

        if (!kelas.isPresent) {
            throw NotFoundException("kelas tidak ditemukan")
        }

        val data = Siswa(
            namaSiswa = siswa.namaSiswa,
            kelas = kelas.get(),
            jenisKelamin = siswa.jenisKelamin,
            nik = siswa.nik,
            alamat = siswa.alamat,
            namaWali = siswa.namaWali,
            tglLahir = siswa.tglLahir
        )

        siswaRepository.save(data)

        return data
    }

    @Transactional
    override fun updateSiswa(id: Int, siswa: ReqSiswa): Siswa {

        val getSiswa = findById(id)

        validationUtil.validate(siswa)

        var getKelas = kelasRepository.findById(siswa.idKelas!!)

        if (!getKelas.isPresent) {
            throw NotFoundException("kelas tidak ditemukan")
        }

        getSiswa.apply {
            namaSiswa = siswa.namaSiswa
            kelas = getKelas.get()
            jenisKelamin = siswa.jenisKelamin
            nik = siswa.nik
            alamat = siswa.alamat
            namaWali = siswa.namaWali
            tglLahir = siswa.tglLahir
        }

        siswaRepository.save(getSiswa)

        return getSiswa
    }

    override fun getAllSiswa(): List<Siswa> {

        return siswaRepository.findAll()
    }

    override fun getSiswa(id: Int): Siswa {

        return findById(id)
    }

    @Transactional
    override fun delete(id: Int) {

        val data = findById(id)

        siswaRepository.delete(data)
    }

    private fun findById(id: Int): Siswa {
        return siswaRepository.findByIdOrNull(id) ?: throw NotFoundException("Siswa dengan id $id tidak ditemukan")
    }
}
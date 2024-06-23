package com.example.springvalidationtest.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.NumberFormat
import java.util.Date

data class ReqSiswa(

    @field:NotNull
    @field:NotBlank(message = "Nama siswa tidak boleh kosong")
    @field:JsonProperty("nama_siswa")
    var namaSiswa: String?,

    @field:NotNull
    @field:NotBlank(message = "jenis kelamin tidak boleh kosong")
    @field:JsonProperty("jenis_kelamin")
    var jenisKelamin: String?,

    @field:NotNull
    @field:NotBlank(message = "alamat siswa tidak boleh kosong")
    var alamat: String?,

    @field:NotNull
    @field:NotBlank(message = "Nama wali siswa tidak boleh kosong")
    @field:JsonProperty("nama_wali")
    var namaWali: String?,

    @field:NotNull
    @field:NotBlank(message = "NIK siswa tidak boleh kosong")
    var nik: String?,

    @field:NotNull(message = "Tanggal lahir siswa tidak boleh kosong")
    @field:Past(message = "Masukkan tanggal yang benar")
    @field:DateTimeFormat(pattern = "yyyy-MM-dd")
    @field:JsonProperty("tgl_lahir")
    var tglLahir: Date?,

    @field:NotNull
    @field:NumberFormat
    @field:JsonProperty("id_kelas")
    var idKelas: Int
)

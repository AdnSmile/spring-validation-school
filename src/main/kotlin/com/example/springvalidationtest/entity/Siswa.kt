package com.example.springvalidationtest.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "siswa")
data class Siswa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_siswa")
    val idSiswa: Int? = null,

    @JsonProperty("nama_siswa")
    var namaSiswa: String?,

    @JsonProperty("jenis_kelamin")
    var jenisKelamin: String?,

    @JsonProperty("alamat")
    var alamat: String?,

    @JsonProperty("nama_wali")
    var namaWali: String?,

    @JsonProperty("tgl_lahir")
    var tglLahir: Date?,

    @JsonProperty("nik")
    var nik: String?,

    @ManyToOne
    @JoinColumn(name = "id_kelas")
    @JsonProperty("kelas")
    var kelas: Kelas
)

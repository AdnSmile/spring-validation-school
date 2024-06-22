package com.example.springvalidationtest.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "kelas")
data class Kelas(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_kelas")
    val idKelas: Int? = null,

    @JsonProperty("nama_kelas")
    val namaKelas: String?,

    @OneToOne
    @JoinColumn(name = "id_wali_kelas")
    @JsonProperty("wali_kelas")
    var waliKelas: WaliKelas,

    @JsonIgnore
    @OneToMany(mappedBy = "kelas", cascade = [CascadeType.ALL], orphanRemoval = true)
    val siswa: List<Siswa>
)

package com.example.springvalidationtest.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "wali_kelas")
data class WaliKelas(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_wali_kelas")
    val idWaliKelas: Int? = null,

    @JsonProperty("nama")
    var nama: String?,

    @JsonProperty("jenis_kelamin")
    var jenisKelamin: String?,

    @ManyToOne
    @JoinColumn(name = "id_mapel")
    @JsonProperty("mata_pelajaran")
    var mataPelajaran: MataPelajaran?,

    @JsonIgnore
    @OneToOne(mappedBy = "waliKelas", cascade = [CascadeType.ALL], orphanRemoval = true)
    val kelas: Kelas
)
